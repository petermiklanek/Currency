package app.petermiklanek.currency.ui.currency

import app.futured.arkitekt.core.BaseView

interface CurrenciesView : BaseView {

    fun onFavouriteCurrency(code: String)
}
