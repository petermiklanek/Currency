package app.petermiklanek.currency.data.domain.favourite

import app.futured.arkitekt.crusecases.FlowUseCase
import app.futured.arkitekt.crusecases.UseCase
import app.petermiklanek.currency.data.model.database.FavouriteCurrency
import app.petermiklanek.currency.data.store.FavouriteCurrencyStore
import javax.inject.Inject

class GetFavouriteCurrenciesUseCase @Inject constructor(
    private val favouriteCurrencyStore: FavouriteCurrencyStore
) : UseCase<Unit, List<FavouriteCurrency>>() {

    override suspend fun build(args: Unit) = favouriteCurrencyStore.getFavouriteCurrencies()
}
