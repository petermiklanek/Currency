package app.petermiklanek.currency.data.domain

import app.futured.arkitekt.crusecases.FlowUseCase
import app.futured.arkitekt.crusecases.UseCase
import app.petermiklanek.currency.data.model.Currency
import app.petermiklanek.currency.data.store.CurrencyStore
import javax.inject.Inject

class ObserveCurrenciesUseCase @Inject constructor(
    private val currencyStore: CurrencyStore
) : FlowUseCase<Unit, List<Currency>>() {

    override fun build(args: Unit) = currencyStore.getAll()
}
