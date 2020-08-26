package app.petermiklanek.currency.tools.extensions

import androidx.core.content.res.ResourcesCompat
import app.petermiklanek.currency.R
import com.google.android.material.appbar.CollapsingToolbarLayout

fun CollapsingToolbarLayout.titleTypeface() {
    val typeface = ResourcesCompat.getFont(context, R.font.roboto_bold)
    setCollapsedTitleTypeface(typeface)
    setExpandedTitleTypeface(typeface)
}
