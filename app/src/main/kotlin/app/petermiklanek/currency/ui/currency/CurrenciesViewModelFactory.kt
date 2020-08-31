package app.petermiklanek.currency.ui.currency

import app.futured.arkitekt.core.factory.BaseViewModelFactory
import app.petermiklanek.currency.ui.main.MainViewModel
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

class CurrenciesViewModelFactory @Inject constructor(
    override val viewModelProvider: Provider<CurrenciesViewModel>
) : BaseViewModelFactory<CurrenciesViewModel>() {
    override val viewModelClass: KClass<CurrenciesViewModel> = CurrenciesViewModel::class
}
