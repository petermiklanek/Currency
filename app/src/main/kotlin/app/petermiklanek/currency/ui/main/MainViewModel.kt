package app.petermiklanek.currency.ui.main

import app.futured.arkitekt.crusecases.BaseCrViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    override val viewState: MainViewState
) : BaseCrViewModel<MainViewState>()
