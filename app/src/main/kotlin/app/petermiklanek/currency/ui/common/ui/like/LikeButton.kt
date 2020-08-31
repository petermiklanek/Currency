package app.petermiklanek.currency.ui.common.ui.like

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.adapters.ImageViewBindingAdapter.setImageDrawable
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import app.petermiklanek.currency.R
import app.petermiklanek.currency.tools.extensions.drawable
import kotlinx.android.synthetic.main.layout_placeholder.view.*
import kotlinx.android.synthetic.main.view_like_button.view.*

class LikeButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    var isFavourite: Boolean = false

    init {
        View.inflate(getContext(), R.layout.view_like_button, this)
    }

    fun setButton(isFavourite: Boolean) {
        this.isFavourite = isFavourite

        like_button.setImageDrawable(
            if (isFavourite) {
                context.drawable(R.drawable.ic_like_filled)
            } else {
                context.drawable(R.drawable.ic_like)
            }
        )
    }
}

@BindingAdapter("isFavourite")
fun LikeButton.bindIsFavourite(isFavourite: Boolean) {
    setButton(isFavourite)
}

@BindingAdapter("onLikeClick")
fun LikeButton.bindOnLikeClick(callback: () -> Unit) {
    like_button.setOnClickListener {
        callback()
        setButton(!this.isFavourite)
    }
}