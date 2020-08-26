package app.petermiklanek.currency.tools.extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion

@BindingConversion
fun visibility(visible: Boolean) = if (visible) View.VISIBLE else View.GONE

@BindingAdapter("invisible")
fun View.isInvisible(isInvisible: Boolean) {
    if (isInvisible) {
        this.visibility = View.INVISIBLE
    } else {
        this.visibility = View.VISIBLE
    }
}
