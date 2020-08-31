package app.petermiklanek.currency.ui.currency

import android.os.Bundle
import android.view.View
import app.futured.arkitekt.core.livedata.observeNonNull
import app.petermiklanek.currency.R
import app.petermiklanek.currency.databinding.FragmentCurrenciesBinding
import app.petermiklanek.currency.tools.extensions.*
import app.petermiklanek.currency.ui.base.BaseBindingFragment
import app.petermiklanek.currency.ui.currency.adapter.CurrenciesAdapter
import javax.inject.Inject

class CurrenciesFragment : BaseBindingFragment<CurrenciesViewModel, CurrenciesViewState, FragmentCurrenciesBinding>(), CurrenciesView {

    @Inject override lateinit var viewModelFactory: CurrenciesViewModelFactory

    @Inject lateinit var currenciesAdapter: CurrenciesAdapter

    override val layoutResId = R.layout.fragment_currencies

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.currenciesRecycler.apply {
            adapter = currenciesAdapter
        }

        viewModel.viewState.currenciesData.observeNonNull(this) { currenciesData ->
            currenciesAdapter.updateData(currenciesData)
        }

        observeEvent(ShowToastEvent::class) {
            showToast(it.message)
        }

        observeEvent(NavigateBackEvent::class) {
            navigateBack()
        }
    }

    override fun onFavouriteCurrency(code: String) {
        viewModel.onFavouriteCurrency(code)
    }
}
