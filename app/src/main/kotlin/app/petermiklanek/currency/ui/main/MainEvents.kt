package app.petermiklanek.currency.ui.main

import app.futured.arkitekt.core.event.Event

sealed class MainEvent : Event<MainViewState>()

data class ShowToastEvent(val message: String) : MainEvent()

object NavigateToCurrenciesEvent : MainEvent()
