package app.petermiklanek.currency.ui.common.ui

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

// Explicitly declared binding adapters, so AS can make suggestions in XML layout
// As of AS4.1, binding autocomplete still doesn't work for public setter methods

@BindingAdapter("onRefresh")
fun PlaceholderLayout.bindOnRefresh(listener: SwipeRefreshLayout.OnRefreshListener) = setOnRefresh(listener)

@BindingAdapter("refreshing")
fun PlaceholderLayout.bindRefreshing(isRefreshing: Boolean) {
    setRefreshing(isRefreshing)
}

@BindingAdapter("refreshEnabled")
fun PlaceholderLayout.bindRefreshEnabled(isEnabled: Boolean) {
    setRefreshEnabled(isEnabled)
}

@BindingAdapter("state")
fun PlaceholderLayout.bindState(placeholderLayoutState: PlaceholderLayoutState) {
    setState(placeholderLayoutState)
}
