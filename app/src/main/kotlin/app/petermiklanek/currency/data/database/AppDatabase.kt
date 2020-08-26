package app.petermiklanek.currency.data.database

import androidx.databinding.adapters.Converters
import androidx.room.*
import app.petermiklanek.currency.data.database.dao.CurrencyDao
import app.petermiklanek.currency.data.model.Currency

@Database(
    entities = [
        Currency::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val CURRENCY_DATABASE = "currency_database"
    }

    abstract fun currencyDao(): CurrencyDao
}
