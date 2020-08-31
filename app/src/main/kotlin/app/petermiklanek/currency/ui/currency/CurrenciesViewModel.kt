package app.petermiklanek.currency.ui.currency

import app.futured.arkitekt.crusecases.BaseCrViewModel
import app.petermiklanek.currency.data.domain.currency.ObserveCurrenciesUseCase
import app.petermiklanek.currency.data.domain.currency.SyncCurrenciesUseCase
import app.petermiklanek.currency.data.domain.favourite.*
import app.petermiklanek.currency.data.model.database.FavouriteCurrency
import timber.log.Timber
import javax.inject.Inject

class CurrenciesViewModel @Inject constructor(
    override val viewState: CurrenciesViewState,
    private val observeCurrenciesUseCase: ObserveCurrenciesUseCase,
    private val getFavouriteCurrenciesUseCase: GetFavouriteCurrenciesUseCase,
    private val addFavouriteCurrencyUseCase: AddFavouriteCurrencyUseCase,
    private val deleteFavouriteCurrencyUseCase: DeleteFavouriteCurrencyUseCase,
    private val syncCurrenciesUseCase: SyncCurrenciesUseCase
) : BaseCrViewModel<CurrenciesViewState>() {

    override fun onStart() {
        with(viewState) {
            getFavouriteCurrenciesUseCase.execute {
                onSuccess {
                    favouriteCurrencies.value = it
                    observeCurrencies()
                }
            }
        }
    }

    private fun observeCurrencies() {
        with(viewState) {
            observeCurrenciesUseCase.execute {
                onNext {
                    currencies.value = it
                }
            }
        }
    }

    fun onRefresh() {
        with(viewState) {
            syncCurrenciesUseCase.execute {
                onStart {
                    isRefreshing.value = true
                }
                onSuccess {
                    isRefreshing.value = false
                }
                onError {
                    isRefreshing.value = false
                    sendEvent(ShowToastEvent(it.message.toString()))
                }
            }
        }
    }

    fun onFavouriteCurrency(code: String) {
        with(viewState) {
            val favourites = favouriteCurrencies.value?.toMutableList() ?: mutableListOf()
            val isFavourite = code in favourites.map { it.currency_code }

            if (isFavourite) {
                deleteFavouriteCurrencyUseCase.execute(DeleteFavouriteCurrencyArgs(code)) {
                    onStart { favouriteCurrencies.value = favourites.apply { remove(FavouriteCurrency(code)) } }
                    onError { Timber.e(it) }
                }
            } else {
                addFavouriteCurrencyUseCase.execute(AddFavouriteCurrencyArgs(code)) {
                    onStart { favouriteCurrencies.value = favourites.apply { add(FavouriteCurrency(code)) } }
                    onError { Timber.e(it) }
                }
            }
        }
    }

    fun onBack() {
        sendEvent(NavigateBackEvent)
    }
}
