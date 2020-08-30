package app.petermiklanek.currency.data.domain.favourite

import app.futured.arkitekt.crusecases.FlowUseCase
import app.petermiklanek.currency.data.model.database.combi.FavouriteCurrencyAll
import app.petermiklanek.currency.data.store.FavouriteCurrencyStore
import javax.inject.Inject

class ObserveFavouriteCurrencyAllUseCase @Inject constructor(
    private val favouriteCurrencyStore: FavouriteCurrencyStore
) : FlowUseCase<Unit, List<FavouriteCurrencyAll>>() {

    override fun build(args: Unit) = favouriteCurrencyStore.getAll()
}
