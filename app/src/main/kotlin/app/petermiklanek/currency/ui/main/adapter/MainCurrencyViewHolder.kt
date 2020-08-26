package app.petermiklanek.currency.ui.main.adapter

import androidx.recyclerview.widget.RecyclerView
import app.petermiklanek.currency.data.model.Currency
import app.petermiklanek.currency.databinding.ListItemCurrencyBinding

class MainCurrencyViewHolder(private val binding: ListItemCurrencyBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(currency: Currency) {
        binding.currency = currency
        binding.executePendingBindings()
    }
}
