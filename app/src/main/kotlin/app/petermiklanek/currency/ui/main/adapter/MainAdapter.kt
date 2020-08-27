package app.petermiklanek.currency.ui.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import app.petermiklanek.currency.data.model.database.Currency
import app.petermiklanek.currency.data.model.ui.UICurrencyData
import app.petermiklanek.currency.databinding.ListItemCurrencyBinding
import app.petermiklanek.currency.tools.extensions.layoutInflater
import javax.inject.Inject

class MainAdapter @Inject constructor() : ListAdapter<UICurrencyData, MainCurrencyViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListItemCurrencyBinding.inflate(parent.layoutInflater(), parent, false).let {
            MainCurrencyViewHolder(it)
        }

    override fun onBindViewHolder(holder: MainCurrencyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object DiffCallback : DiffUtil.ItemCallback<UICurrencyData>() {
        override fun areItemsTheSame(oldItem: UICurrencyData, newItem: UICurrencyData) = oldItem.currency == newItem.currency

        override fun areContentsTheSame(oldItem: UICurrencyData, newItem: UICurrencyData) = oldItem == newItem
    }
}
