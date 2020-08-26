package app.petermiklanek.currency.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

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
}
