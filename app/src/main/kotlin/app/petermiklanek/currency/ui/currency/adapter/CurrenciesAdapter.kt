package app.petermiklanek.currency.ui.currency.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import app.petermiklanek.currency.data.model.ui.UICurrencyData
import app.petermiklanek.currency.databinding.ListItemCurrencyBinding
import app.petermiklanek.currency.databinding.ListItemFavouriteCurrencyBinding
import app.petermiklanek.currency.tools.extensions.layoutInflater
import app.petermiklanek.currency.ui.currency.CurrenciesView
import app.petermiklanek.currency.ui.main.adapter.MainCurrencyViewHolder
import javax.inject.Inject

class CurrenciesAdapter @Inject constructor(
    private val view: CurrenciesView
) : ListAdapter<UICurrencyData, CurrenciesItemViewHolder>(DiffCallback) {

    private val data = mutableListOf<UICurrencyData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrenciesItemViewHolder {
        return ListItemCurrencyBinding
            .inflate(parent.layoutInflater(), parent, false)
            .let { CurrenciesItemViewHolder(it, view) }
    }

    override fun onBindViewHolder(holder: CurrenciesItemViewHolder, position: Int) =
        holder.bind(data[position])

    override fun getItemCount() = data.size

    fun updateData(data: List<UICurrencyData>) {
        val oldCurrencies = this.data.map { it.currency }
        val newCurrencies = data.map { it.currency }

        this.data.clear()
        this.data.addAll(data)

        if (oldCurrencies != newCurrencies) {
            notifyDataSetChanged()
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<UICurrencyData>() {
        override fun areItemsTheSame(oldItem: UICurrencyData, newItem: UICurrencyData) = false

        override fun areContentsTheSame(oldItem: UICurrencyData, newItem: UICurrencyData) = false
    }
}
