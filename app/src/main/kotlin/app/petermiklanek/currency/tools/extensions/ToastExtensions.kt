package app.petermiklanek.currency.tools.extensions

import android.widget.Toast

fun Toast.showAlert(message: String?) {
    setText(message)
    duration = Toast.LENGTH_LONG
    show()
}
