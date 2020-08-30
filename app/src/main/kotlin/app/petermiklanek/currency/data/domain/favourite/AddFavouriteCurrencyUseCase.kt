package app.petermiklanek.currency.data.domain.favourite

import app.futured.arkitekt.crusecases.UseCase
import app.petermiklanek.currency.data.store.FavouriteCurrencyStore
import javax.inject.Inject

class AddFavouriteCurrencyUseCase @Inject constructor(
    private val favouriteCurrencyStore: FavouriteCurrencyStore
) : UseCase<AddFavouriteCurrencyArgs, Unit>() {

    override suspend fun build(args: AddFavouriteCurrencyArgs) {
        favouriteCurrencyStore.addFavouriteCurrency(args.code)
    }
}

data class AddFavouriteCurrencyArgs(
    val code: String
)