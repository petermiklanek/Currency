package app.petermiklanek.currency.ui.common.ui.placeholder

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import app.petermiklanek.currency.ui.common.ui.placeholder.PlaceholderLayout

// Explicitly declared binding adapters, so AS can make suggestions in XML layout
// As of AS4.1, binding autocomplete still doesn't work for public setter methods

@BindingAdapter("onRefresh")
fun PlaceholderLayout.bindOnRefresh(listener: SwipeRefreshLayout.OnRefreshListener) = setOnRefresh(listener)

@BindingAdapter("refreshing")
fun PlaceholderLayout.bindRefreshing(isRefreshing: Boolean) {
    setRefreshing(isRefreshing)
}

@BindingAdapter("swipeRefresh")
fun PlaceholderLayout.bindSwipeRefresh(callback: () -> Unit) {
    setOnRefresh(SwipeRefreshLayout.OnRefreshListener { callback() })
}

@BindingAdapter("refreshEnabled")
fun PlaceholderLayout.bindRefreshEnabled(isEnabled: Boolean) {
    setRefreshEnabled(isEnabled)
}

@BindingAdapter("state")
fun PlaceholderLayout.bindState(placeholderLayoutState: PlaceholderLayoutState) {
    setState(placeholderLayoutState)
}
