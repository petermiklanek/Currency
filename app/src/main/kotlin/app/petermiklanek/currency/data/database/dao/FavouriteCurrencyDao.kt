package app.petermiklanek.currency.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import app.petermiklanek.currency.data.model.database.FavouriteCurrency
import app.petermiklanek.currency.data.model.database.combi.FavouriteCurrencyAll
import kotlinx.coroutines.flow.Flow

@Dao
abstract class FavouriteCurrencyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(favouriteCurrency: FavouriteCurrency)

    @Transaction
    @Query(value =
    "SELECT favourite_currency.*, currency.* " +
        "FROM favourite_currency " +
        "INNER JOIN currency " +
        "ON favourite_currency.currency_code = currency.code"
    )
    abstract fun getAll(): Flow<List<FavouriteCurrencyAll>>

    @Query("SELECT * FROM favourite_currency")
    abstract fun getFavouriteCurrencies(): Flow<List<FavouriteCurrency>>

    @Query("DELETE FROM favourite_currency WHERE currency_code = :code")
    abstract suspend fun delete(code: String)
}
