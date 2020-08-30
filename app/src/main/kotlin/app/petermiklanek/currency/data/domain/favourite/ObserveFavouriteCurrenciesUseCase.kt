package app.petermiklanek.currency.data.domain.favourite

import app.futured.arkitekt.crusecases.FlowUseCase
import app.petermiklanek.currency.data.model.database.Currency
import app.petermiklanek.currency.data.model.database.FavouriteCurrency
import app.petermiklanek.currency.data.model.ui.UIFavouriteCurrencyData
import app.petermiklanek.currency.data.store.CurrencyStore
import app.petermiklanek.currency.data.store.FavouriteCurrencyStore
import javax.inject.Inject

class ObserveFavouriteCurrenciesUseCase @Inject constructor(
    private val favouriteCurrencyStore: FavouriteCurrencyStore
) : FlowUseCase<Unit, List<FavouriteCurrency>>() {

    override fun build(args: Unit) = favouriteCurrencyStore.getFavouriteCurrencies()
}
