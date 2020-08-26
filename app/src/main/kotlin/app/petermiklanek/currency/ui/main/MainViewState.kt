package app.petermiklanek.currency.ui.main

import androidx.lifecycle.MutableLiveData
import app.futured.arkitekt.core.ViewState
import app.petermiklanek.currency.data.model.Currency
import javax.inject.Inject

class MainViewState @Inject constructor() : ViewState {

    val currencies = MutableLiveData<List<Currency>>(listOf())
}
