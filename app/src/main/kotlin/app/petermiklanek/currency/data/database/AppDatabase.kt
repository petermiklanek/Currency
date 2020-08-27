package app.petermiklanek.currency.data.database

import androidx.room.*
import app.petermiklanek.currency.data.database.dao.CurrencyDao
import app.petermiklanek.currency.data.model.database.Currency

@Database(
    entities = [
        Currency::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val CURRENCY_DATABASE = "currency_database"
    }

    abstract fun currencyDao(): CurrencyDao
}
