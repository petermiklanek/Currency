package app.petermiklanek.currency.ui.navigation

import android.content.Context
import android.content.Intent
import app.petermiklanek.currency.R
import app.petermiklanek.currency.databinding.ActivityNavigationBinding
import app.petermiklanek.currency.ui.base.BaseBindingActivity
import javax.inject.Inject

class NavigationActivity :
    BaseBindingActivity<NavigationViewModel, NavigationViewState, ActivityNavigationBinding>(),
        NavigationView {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, NavigationActivity::class.java)
    }

    @Inject
    override lateinit var viewModelFactory: NavigationViewModelFactory

    override val layoutResId = R.layout.activity_navigation
}
