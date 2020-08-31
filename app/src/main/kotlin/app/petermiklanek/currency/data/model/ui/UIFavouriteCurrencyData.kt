package app.petermiklanek.currency.data.model.ui

import app.petermiklanek.currency.data.model.database.combi.FavouriteCurrencyAll

data class UIFavouriteCurrencyData(
    var all: FavouriteCurrencyAll,
    val convertValue: Double?
)