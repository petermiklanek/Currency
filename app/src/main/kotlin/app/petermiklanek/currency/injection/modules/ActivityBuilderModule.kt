package app.petermiklanek.currency.injection.modules

import app.petermiklanek.currency.ui.navigation.NavigationActivity
import app.petermiklanek.currency.ui.navigation.NavigationActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [NavigationActivityModule::class])
    abstract fun mainActivity(): NavigationActivity
}
