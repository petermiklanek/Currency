// ktlint-disable filename
package app.petermiklanek.currency.ui.currency

import app.futured.arkitekt.core.event.Event

sealed class CurrenciesEvent : Event<CurrenciesViewState>()

data class ShowToastEvent(val message: String) : CurrenciesEvent()
