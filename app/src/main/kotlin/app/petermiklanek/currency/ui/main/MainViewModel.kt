package app.petermiklanek.currency.ui.main

import app.futured.arkitekt.crusecases.BaseCrViewModel
import app.petermiklanek.currency.data.domain.ObserveCurrenciesUseCase
import app.petermiklanek.currency.data.domain.SyncCurrenciesUseCase
import app.petermiklanek.currency.data.model.state.*
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(
    override val viewState: MainViewState,
    private val observeCurrenciesUseCase: ObserveCurrenciesUseCase,
    private val syncCurrenciesUseCase: SyncCurrenciesUseCase
) : BaseCrViewModel<MainViewState>() {

    override fun onStart() {
        with(viewState) {
            syncCurrenciesUseCase.execute {
                onStart {
                    state.value = StateLoading
                }
                onSuccess {
                    state.value = StateContent(it)
                }
                onError {
                    Timber.e(it)
                    state.value = StateError(throwable = it)
                }
            }
        }

        with(viewState) {
            observeCurrenciesUseCase.execute {
                onNext {
                    currencies.value = it
                }
            }
        }
    }
}
