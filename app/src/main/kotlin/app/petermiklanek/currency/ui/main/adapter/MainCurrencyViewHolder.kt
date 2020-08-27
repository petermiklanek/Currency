package app.petermiklanek.currency.ui.main.adapter

import androidx.recyclerview.widget.RecyclerView
import app.petermiklanek.currency.data.model.database.Currency
import app.petermiklanek.currency.data.model.ui.UICurrencyData
import app.petermiklanek.currency.databinding.ListItemCurrencyBinding
import app.petermiklanek.currency.tools.extensions.roundCurrencyRate

class MainCurrencyViewHolder(private val binding: ListItemCurrencyBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: UICurrencyData) {
        binding.currencyCode = data.currency.code
        binding.currencyValue = calculateConvertValue(data)
        binding.executePendingBindings()
    }

    private fun calculateConvertValue(data: UICurrencyData): String {
        return (if (data.convertValue == null || data.convertValue == 0.0) {
            data.currency.rate
        } else {
            data.currency.rate * data.convertValue
        }).roundCurrencyRate()
    }
}
