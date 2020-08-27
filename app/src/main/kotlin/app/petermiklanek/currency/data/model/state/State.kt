package app.petermiklanek.currency.data.model.state

sealed class State<out T>

object StateLoading : State<Nothing>()
data class StateContent<T>(val item: T) : State<T>()
data class StateError(val throwable: Throwable) : State<Nothing>()

fun <T> State<T>.contentOrNull() = (this as? StateContent)?.item
fun <T> State<T>.errorOrNull() = (this as? StateError)?.throwable
