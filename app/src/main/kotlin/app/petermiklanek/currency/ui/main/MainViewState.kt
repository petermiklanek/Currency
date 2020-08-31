package app.petermiklanek.currency.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import app.futured.arkitekt.core.ViewState
import app.futured.arkitekt.core.livedata.DefaultValueLiveData
import app.futured.arkitekt.core.livedata.combineLiveData
import app.petermiklanek.currency.ui.common.ui.placeholder.PlaceholderLayoutState
import app.petermiklanek.currency.data.model.database.combi.FavouriteCurrencyAll
import app.petermiklanek.currency.data.model.state.*
import app.petermiklanek.currency.data.model.ui.UIFavouriteCurrencyData
import javax.inject.Inject

class MainViewState @Inject constructor() : ViewState {

    val favouriteCurrencies = MutableLiveData<List<FavouriteCurrencyAll>>(listOf())

    val convertValue = MutableLiveData<String>("1")

    val isRefreshing = DefaultValueLiveData(false)

    internal val state = DefaultValueLiveData<State<Unit>>(StateLoading)

    val placeholderLayoutState = state.map {
        when (it) {
            is StateContent -> PlaceholderLayoutState.CONTENT
            is StateLoading -> PlaceholderLayoutState.LOADING
            is StateError -> PlaceholderLayoutState.ERROR
            else -> error("Invalid state")
        }
    }

    val currenciesData = combineLiveData(favouriteCurrencies, convertValue) { currencies, convertValue ->
        currencies.map { UIFavouriteCurrencyData(it, convertValue.toDoubleOrNull()) }
    }
}
