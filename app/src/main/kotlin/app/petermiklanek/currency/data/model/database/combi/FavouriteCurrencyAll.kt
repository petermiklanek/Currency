package app.petermiklanek.currency.data.model.database.combi

import androidx.room.Embedded
import androidx.room.Ignore
import app.petermiklanek.currency.data.model.database.Currency
import app.petermiklanek.currency.data.model.database.FavouriteCurrency

data class FavouriteCurrencyAll(
    @Embedded
    var currency: Currency,

    @Embedded
    var favouriteCurrency: FavouriteCurrency
) {
    constructor() : this(Currency.EMPTY, FavouriteCurrency.EMPTY)
}