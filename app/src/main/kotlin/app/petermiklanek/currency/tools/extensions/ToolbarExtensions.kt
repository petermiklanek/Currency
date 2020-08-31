package app.petermiklanek.currency.tools.extensions

import androidx.appcompat.widget.Toolbar
import androidx.databinding.BindingAdapter

@BindingAdapter("onNavigationBackClick")
fun Toolbar.onNavigationClicked(callback: () -> Unit) {
    //setNavigationOnClickListener {
    //    callback()
    //}
}