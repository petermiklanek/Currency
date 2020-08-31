package app.petermiklanek.currency.data.store

import app.petermiklanek.currency.data.database.AppDatabase
import app.petermiklanek.currency.data.model.database.FavouriteCurrency
import app.petermiklanek.currency.data.model.database.combi.FavouriteCurrencyAll
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavouriteCurrencyStore @Inject constructor(
    private val database: AppDatabase
) {
    fun getAll(): Flow<List<FavouriteCurrencyAll>> = database.favouriteCurrencyDao().getAll()

    suspend fun getFavouriteCurrencies(): List<FavouriteCurrency> = database.favouriteCurrencyDao().getFavouriteCurrencies()

    suspend fun addFavouriteCurrency(code: String) = database.favouriteCurrencyDao().insert(FavouriteCurrency(code))

    suspend fun deleteFavouriteCurrency(code: String) = database.favouriteCurrencyDao().delete(code)

}
