package app.petermiklanek.currency.ui.currency.adapter

import androidx.recyclerview.widget.RecyclerView
import app.petermiklanek.currency.data.model.ui.UICurrencyData
import app.petermiklanek.currency.databinding.ListItemCurrencyBinding
import app.petermiklanek.currency.databinding.ListItemFavouriteCurrencyBinding
import app.petermiklanek.currency.tools.extensions.roundCurrencyRate

class CurrenciesItemViewHolder(private val binding: ListItemCurrencyBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: UICurrencyData) {
        binding.currencyCode = data.currency.code
        binding.isFavourite = data.isFavourite
        binding.executePendingBindings()
    }
}
