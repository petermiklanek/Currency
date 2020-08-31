package app.petermiklanek.currency.ui.main.adapter

import androidx.recyclerview.widget.RecyclerView
import app.petermiklanek.currency.data.model.ui.UIFavouriteCurrencyData
import app.petermiklanek.currency.databinding.ListItemFavouriteCurrencyBinding
import app.petermiklanek.currency.tools.extensions.roundCurrencyRate
import java.util.*

class MainCurrencyViewHolder(private val binding: ListItemFavouriteCurrencyBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: UIFavouriteCurrencyData) {
        val currencySymbol = Currency.getInstance(data.all.currency.code).symbol
        binding.currency = data.all.currency
        binding.currencyValue = "${getConvertValue(data)} $currencySymbol"
        binding.executePendingBindings()
    }

    private fun getConvertValue(data: UIFavouriteCurrencyData): String {
        return (if (data.convertValue == null || data.convertValue == 0.0) {
            data.all.currency.rate
        } else {
            data.all.currency.rate * data.convertValue
        }).roundCurrencyRate()
    }
}
