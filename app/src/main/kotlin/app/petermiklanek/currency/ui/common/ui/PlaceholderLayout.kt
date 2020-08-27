package app.petermiklanek.currency.ui.common.ui

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.res.use
import androidx.core.view.forEach
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import app.petermiklanek.currency.R
import app.petermiklanek.currency.tools.extensions.*
import kotlinx.android.synthetic.main.layout_placeholder.view.*

/**
 * [PlaceholderLayout] is a ViewGroup, that shows only one layout at a time, according to it's state.
 * Place your content, loading, error and empty views inside,
 * reference them using placeholder_<state|content|error|loading> attribute, and switch their visibility
 * by setting the layout state using [setState] method.
 */
class PlaceholderLayout @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    private val defStyleAttr: Int = 0,
    private val defStyleRes: Int = 0
) : FrameLayout(context, attrs, defStyleAttr, defStyleRes) {

    private var contentViewId: Int = -1
    private var emptyViewId: Int = -1
    private var errorViewId: Int = -1
    private var loadingViewId: Int = -1
    private lateinit var defaultState: PlaceholderLayoutState

    private var isInitialized = false

    private var contentView: View? = null
    private var emptyView: View? = null
    private var errorView: View? = null
    private var loadingView: View? = null

    private var visibleView: View? = null

    init {
        obtainAttributes()
        inflate(context, R.layout.layout_placeholder, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        if (!isInitialized) {
            initialize()
            isInitialized = true
        }
    }

    fun setOnRefresh(listener: SwipeRefreshLayout.OnRefreshListener) {
        placeholder_layout_swipeToRefresh.isEnabled = true
        placeholder_layout_swipeToRefresh.setOnRefreshListener(listener)
    }

    fun setRefreshing(isRefreshing: Boolean) {
        placeholder_layout_swipeToRefresh.isRefreshing = isRefreshing
    }

    fun setRefreshEnabled(isEnabled: Boolean) {
        placeholder_layout_swipeToRefresh.isEnabled = isEnabled
    }

    @Suppress("ThrowsCount")
    fun setState(placeholderLayoutState: PlaceholderLayoutState) {
        val newView = when (placeholderLayoutState) {
            PlaceholderLayoutState.LOADING -> loadingView
                ?: throw IllegalStateException("PlaceholderLayoutView does not reference placeholder_loading view")
            PlaceholderLayoutState.CONTENT -> contentView
                ?: throw IllegalStateException("PlaceholderLayoutView does not reference placeholder_content view")
            PlaceholderLayoutState.EMPTY -> emptyView
                ?: throw IllegalStateException("PlaceholderLayoutView does not reference placeholder_empty view")
            PlaceholderLayoutState.ERROR -> errorView
                ?: throw IllegalStateException("PlaceholderLayoutView does not reference placeholder_error view")
        }

        if (newView != visibleView) {
            visibleView?.gone()
            visibleView = newView.also {
                if (!isInEditMode) {
                    it.animateShow {}
                } else {
                    it.visible()
                }
            }
        }
    }

    @SuppressLint("Recycle")
    private fun obtainAttributes() {
        context.obtainStyledAttributes(attrs, R.styleable.PlaceholderLayout, defStyleAttr, defStyleRes).use {
            contentViewId = it.getResourceId(R.styleable.PlaceholderLayout_placeholder_content, -1)
            emptyViewId = it.getResourceId(R.styleable.PlaceholderLayout_placeholder_empty, -1)
            errorViewId = it.getResourceId(R.styleable.PlaceholderLayout_placeholder_error, -1)
            loadingViewId = it.getResourceId(R.styleable.PlaceholderLayout_placeholder_loading, -1)
            defaultState = it.getInt(R.styleable.PlaceholderLayout_placeholder_default_state, -1).let { index ->
                if (index == -1) {
                    PlaceholderLayoutState.CONTENT
                } else {
                    PlaceholderLayoutState.values()[index]
                }
            }
        }
    }

    private fun initialize() {
        val childCount = childCount
        if (childCount == 0) {
            throw IllegalStateException("PlaceholderLayoutView must contain at least one child")
        }

        forEach { child ->
            when (child.id) {
                loadingViewId -> loadingView = child.apply { gone() }
                contentViewId -> contentView = child.apply { gone() }
                emptyViewId -> emptyView = child.apply { gone() }
                errorViewId -> errorView = child.apply { gone() }
            }
        }

        if (contentView == null) {
            throw IllegalStateException("PlaceholderLayoutView does not contain content view, " +
                "have you referenced the view in app:placeholder_content attribute?")
        }

        removeView(contentView)
        placeholder_layout_content.addView(contentView)

        setState(defaultState)
    }
}