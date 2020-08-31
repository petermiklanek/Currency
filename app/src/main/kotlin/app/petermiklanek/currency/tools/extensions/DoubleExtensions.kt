package app.petermiklanek.currency.tools.extensions

import java.util.*

fun Double.roundCurrencyRate(): String {
    return "%.3f".format(Locale.US, this)
}