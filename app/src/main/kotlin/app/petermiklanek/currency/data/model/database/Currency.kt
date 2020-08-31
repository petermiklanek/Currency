package app.petermiklanek.currency.data.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import app.petermiklanek.currency.tools.extensions.roundCurrencyRate

@Entity(tableName = "currency")
data class Currency(
    @PrimaryKey
    @ColumnInfo(name = "code")
    val code: String,

    @ColumnInfo(name = "rate")
    val rate: Double
) {
    companion object {
        val EMPTY = Currency(
            code = "",
            rate = 0.0
        )
    }

    fun getRateText() = rate.roundCurrencyRate()
}
