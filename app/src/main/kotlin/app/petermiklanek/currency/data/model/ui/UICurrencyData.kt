package app.petermiklanek.currency.data.model.ui

import app.petermiklanek.currency.data.model.database.Currency

data class UICurrencyData(
    val currency: Currency,
    val convertValue: Double?
)