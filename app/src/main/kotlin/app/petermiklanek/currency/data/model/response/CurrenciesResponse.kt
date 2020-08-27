package app.petermiklanek.currency.data.model.response

data class CurrenciesResponse(
    val base: String,
    val rates: Map<String, String>
)