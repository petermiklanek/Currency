package app.petermiklanek.currency.data.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite_currency")
data class FavouriteCurrency(
    @PrimaryKey
    @ColumnInfo(name = "currency_code")
    val currency_code: String
) {
    companion object {
        val EMPTY = FavouriteCurrency(
            currency_code = ""
        )
    }
}
