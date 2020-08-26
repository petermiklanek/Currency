package app.petermiklanek.currency.injection.modules

import app.petermiklanek.currency.ui.main.MainFragment
import app.petermiklanek.currency.ui.main.MainFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun mainFragment(): MainFragment
}
