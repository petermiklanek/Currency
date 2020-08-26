package app.petermiklanek.currency.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import app.petermiklanek.currency.data.model.Currency

@Dao
abstract class CurrencyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertAll(currencies: List<Currency>)

    @Query("SELECT * FROM currency")
    abstract suspend fun getAll(): List<Currency>

    @Query("DELETE FROM currency")
    abstract suspend fun deleteAll()

    @Transaction
    suspend fun replaceAll(currencies: List<Currency>) {
        deleteAll()
        insertAll(currencies)
    }
}
