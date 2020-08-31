package app.petermiklanek.currency.data.domain.currency

import app.futured.arkitekt.crusecases.FlowUseCase
import app.petermiklanek.currency.data.model.database.Currency
import app.petermiklanek.currency.data.store.CurrencyStore
import javax.inject.Inject

class ObserveCurrenciesUseCase @Inject constructor(
    private val currencyStore: CurrencyStore
) : FlowUseCase<Unit, List<Currency>>() {

    override fun build(args: Unit) = currencyStore.getAll()
}
