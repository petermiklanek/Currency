package app.petermiklanek.currency.ui.currency

import android.os.Bundle
import android.view.View
import app.futured.arkitekt.core.livedata.observeNonNull
import app.petermiklanek.currency.R
import app.petermiklanek.currency.databinding.FragmentMainBinding
import app.petermiklanek.currency.tools.extensions.*
import app.petermiklanek.currency.ui.base.BaseBindingFragment
import app.petermiklanek.currency.ui.currency.adapter.CurrenciesAdapter
import app.petermiklanek.currency.ui.main.*
import app.petermiklanek.currency.ui.main.adapter.MainAdapter
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class CurrenciesFragment : BaseBindingFragment<CurrenciesViewModel, CurrenciesViewState, FragmentMainBinding>(), CurrenciesView {

    @Inject override lateinit var viewModelFactory: CurrenciesViewModelFactory

    @Inject lateinit var currenciesAdapter: CurrenciesAdapter

    override val layoutResId = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.currenciesRecycler.apply {
            adapter = currenciesAdapter
        }

        viewModel.viewState.currenciesData.observeNonNull(this) { currenciesData ->
            binding.currenciesRecycler.visible(currenciesData.isNotEmpty())
            binding.currenciesEmpty.visible(currenciesData.isEmpty())
            currenciesAdapter.updateData(currenciesData)
        }

        observeEvent(ShowToastEvent::class) {
            showToast(it.message)
        }
    }

    override fun onFavouriteCurrency(code: String) {
        viewModel.onFavouriteCurrency(code)
    }
}
