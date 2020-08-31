package app.petermiklanek.currency.data.database

import androidx.room.*
import app.petermiklanek.currency.data.database.dao.CurrencyDao
import app.petermiklanek.currency.data.database.dao.FavouriteCurrencyDao
import app.petermiklanek.currency.data.model.database.Currency
import app.petermiklanek.currency.data.model.database.FavouriteCurrency

@Database(
    entities = [
        Currency::class,
        FavouriteCurrency::class
    ],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val CURRENCY_DATABASE = "currency_database"
    }

    abstract fun currencyDao(): CurrencyDao

    abstract fun favouriteCurrencyDao(): FavouriteCurrencyDao

}
