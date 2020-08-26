package app.petermiklanek.currency.ui.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import app.petermiklanek.currency.data.model.Currency
import app.petermiklanek.currency.databinding.ListItemCurrencyBinding
import app.petermiklanek.currency.tools.extensions.layoutInflater
import javax.inject.Inject

class MainAdapter @Inject constructor() : ListAdapter<Currency, MainCurrencyViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListItemCurrencyBinding.inflate(parent.layoutInflater(), parent, false).let {
            MainCurrencyViewHolder(it)
        }

    override fun onBindViewHolder(holder: MainCurrencyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object DiffCallback : DiffUtil.ItemCallback<Currency>() {
        override fun areItemsTheSame(oldItem: Currency, newItem: Currency) = oldItem == newItem

        override fun areContentsTheSame(oldItem: Currency, newItem: Currency) = oldItem == newItem
    }
}
