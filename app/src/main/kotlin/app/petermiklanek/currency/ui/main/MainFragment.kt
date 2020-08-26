package app.petermiklanek.currency.ui.main

import app.petermiklanek.currency.R
import app.petermiklanek.currency.databinding.FragmentMainBinding
import app.petermiklanek.currency.ui.base.BaseBindingFragment
import javax.inject.Inject

class MainFragment : BaseBindingFragment<MainViewModel, MainViewState, FragmentMainBinding>(),
        MainView {

    @Inject
    override lateinit var viewModelFactory: MainViewModelFactory

    override val layoutResId = R.layout.fragment_main
}
