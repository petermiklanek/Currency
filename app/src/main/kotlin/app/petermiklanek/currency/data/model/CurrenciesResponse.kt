package app.petermiklanek.currency.data.model

data class CurrenciesResponse(
    val base: String,
    val rates: List<Currency>
)