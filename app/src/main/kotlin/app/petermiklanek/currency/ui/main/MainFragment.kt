package app.petermiklanek.currency.ui.main

import android.os.Bundle
import android.view.View
import app.futured.arkitekt.core.livedata.observeNonNull
import app.petermiklanek.currency.R
import app.petermiklanek.currency.databinding.FragmentMainBinding
import app.petermiklanek.currency.tools.extensions.titleTypeface
import app.petermiklanek.currency.ui.base.BaseBindingFragment
import app.petermiklanek.currency.ui.main.adapter.MainAdapter
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class MainFragment : BaseBindingFragment<MainViewModel, MainViewState, FragmentMainBinding>(), MainView {

    @Inject override lateinit var viewModelFactory: MainViewModelFactory

    @Inject lateinit var mainAdapter: MainAdapter

    override val layoutResId = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currencies_collapsing_toolbar.titleTypeface()

        binding.currenciesRecycler.apply {
            adapter = mainAdapter
        }

        viewModel.viewState.currencies.observeNonNull(this) {
            mainAdapter.submitList(it)
        }
    }
}
