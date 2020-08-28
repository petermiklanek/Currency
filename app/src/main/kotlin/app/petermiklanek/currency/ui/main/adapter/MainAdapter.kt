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

    private val data = mutableListOf<UICurrencyData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainCurrencyViewHolder {
        return ListItemCurrencyBinding
            .inflate(parent.layoutInflater(), parent, false)
            .let { MainCurrencyViewHolder(it) }
    }

    override fun onBindViewHolder(holder: MainCurrencyViewHolder, position: Int) =
        holder.bind(data[position])

    override fun getItemCount() = data.size

    fun upadteData(data: List<UICurrencyData>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    object DiffCallback : DiffUtil.ItemCallback<UICurrencyData>() {
        override fun areItemsTheSame(oldItem: UICurrencyData, newItem: UICurrencyData) = false

        override fun areContentsTheSame(oldItem: UICurrencyData, newItem: UICurrencyData) = false
    }
}
