package app.petermiklanek.currency.ui.main.adapter

import androidx.recyclerview.widget.RecyclerView
import app.petermiklanek.currency.data.model.ui.UIFavouriteCurrencyData
import app.petermiklanek.currency.databinding.ListItemFavouriteCurrencyBinding
import app.petermiklanek.currency.tools.extensions.roundCurrencyRate

class MainCurrencyViewHolder(private val binding: ListItemFavouriteCurrencyBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: UIFavouriteCurrencyData) {
        binding.currencyCode = data.all.currency.code
        setConvertValue(data)
        binding.executePendingBindings()
    }

    private fun setConvertValue(data: UIFavouriteCurrencyData){
        binding.currencyValue = (if (data.convertValue == null || data.convertValue == 0.0) {
            data.all.currency.rate
        } else {
            data.all.currency.rate * data.convertValue
        }).roundCurrencyRate()
    }
}
