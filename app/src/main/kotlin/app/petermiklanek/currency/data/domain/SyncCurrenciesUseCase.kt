package app.petermiklanek.currency.data.domain

import app.futured.arkitekt.crusecases.UseCase
import app.petermiklanek.currency.data.database.AppDatabase
import app.petermiklanek.currency.data.model.Currency
import app.petermiklanek.currency.data.store.CurrencyStore
import javax.inject.Inject

class SyncCurrenciesUseCase @Inject constructor(
    private val currencyStore: CurrencyStore,
    private val database: AppDatabase
) : UseCase<Unit, Unit>() {

    override suspend fun build(args: Unit) {
        val currencies = currencyStore.sync().rates.map {
            Currency(code = it.key, rate = it.value.toDoubleOrNull() ?: 0.0)
        }
        database.currencyDao().replaceAll(currencies)
    }
}
