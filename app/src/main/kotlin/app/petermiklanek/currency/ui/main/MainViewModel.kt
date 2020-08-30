package app.petermiklanek.currency.ui.main

import app.futured.arkitekt.crusecases.BaseCrViewModel
import app.petermiklanek.currency.data.domain.currency.SyncCurrenciesUseCase
import app.petermiklanek.currency.data.domain.favourite.ObserveFavouriteCurrencyAllUseCase
import app.petermiklanek.currency.data.model.state.*
import javax.inject.Inject

class MainViewModel @Inject constructor(
    override val viewState: MainViewState,
    private val observeFavouriteCurrencyAllUseCase: ObserveFavouriteCurrencyAllUseCase,
    private val syncCurrenciesUseCase: SyncCurrenciesUseCase
) : BaseCrViewModel<MainViewState>() {

    override fun onStart() {
        with(viewState) {
            syncCurrenciesUseCase.execute {
                onStart {
                    state.value = StateLoading
                }
                onSuccess {
                    state.value = StateContent(Unit)
                }
                onError {
                    state.value = StateContent(Unit)
                    sendEvent(ShowToastEvent(it.message.toString()))
                }
            }
        }

        with(viewState) {
            observeFavouriteCurrencyAllUseCase.execute {
                onNext {
                    favouriteCurrencies.value = it
                }
            }
        }
    }

    fun onSwipeRefresh() {
        with(viewState) {
            syncCurrenciesUseCase.execute {
                onStart {
                    isRefreshing.value = true
                    state.value = StateContent(Unit)
                }
                onSuccess {
                    isRefreshing.value = false
                    state.value = StateContent(Unit)
                }
                onError {
                    isRefreshing.value = false
                    sendEvent(ShowToastEvent(it.message.toString()))
                }
            }
        }
    }

    fun addFavouriteCurrency() {

    }
}
