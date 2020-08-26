package app.petermiklanek.currency.ui.main

import app.futured.arkitekt.crusecases.BaseCrViewModel
import app.petermiklanek.currency.data.domain.ObserveCurrenciesUseCase
import app.petermiklanek.currency.data.domain.SyncCurrenciesUseCase
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(
    override val viewState: MainViewState,
    private val observeCurrenciesUseCase: ObserveCurrenciesUseCase,
    private val syncCurrenciesUseCase: SyncCurrenciesUseCase
) : BaseCrViewModel<MainViewState>(){

    override fun onStart() {
        syncCurrenciesUseCase.execute {
            onSuccess {
                sendEvent(ShowToastEvent("Sync successful"))
            }
            onError {
                Timber.e(it)
                sendEvent(ShowToastEvent(it.message))
            }
        }

        observeCurrenciesUseCase.execute {
            onNext {
                viewState.currencies.value = it
            }
        }
    }
}
