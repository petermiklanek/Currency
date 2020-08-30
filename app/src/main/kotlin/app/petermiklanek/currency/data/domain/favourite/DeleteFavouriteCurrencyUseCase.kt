package app.petermiklanek.currency.data.domain.favourite

import app.futured.arkitekt.crusecases.UseCase
import app.petermiklanek.currency.data.store.FavouriteCurrencyStore
import javax.inject.Inject

class DeleteFavouriteCurrencyUseCase @Inject constructor(
    private val favouriteCurrencyStore: FavouriteCurrencyStore
) : UseCase<DeleteFavouriteCurrencyArgs, Unit>() {

    override suspend fun build(args: DeleteFavouriteCurrencyArgs) {
        favouriteCurrencyStore.deleteFavouriteCurrency(args.code)
    }
}

data class DeleteFavouriteCurrencyArgs(
    val code: String
)