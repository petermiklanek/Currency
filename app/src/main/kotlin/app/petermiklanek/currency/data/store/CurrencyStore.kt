package app.petermiklanek.currency.data.store

import app.petermiklanek.currency.data.database.AppDatabase
import app.petermiklanek.currency.data.model.Currency
import app.petermiklanek.currency.data.remote.ApiManager
import app.petermiklanek.currency.tools.Constants
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CurrencyStore @Inject constructor(
    private val database: AppDatabase,
    private val apiManager: ApiManager
) {

    // region API

    suspend fun sync() = apiManager.getCurrencies(Constants.Api.KEY)

    // endregion

    // region Room

    fun getAll(): Flow<List<Currency>> = database.currencyDao().getAll()

    // endregion
}
