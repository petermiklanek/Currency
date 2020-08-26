package app.petermiklanek.currency.injection.components

import app.petermiklanek.currency.App
import app.petermiklanek.currency.injection.modules.ActivityBuilderModule
import app.petermiklanek.currency.injection.modules.ApplicationModule
import app.petermiklanek.currency.injection.modules.FragmentBuilderModule
import app.petermiklanek.currency.injection.modules.NetworkModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class,
    ApplicationModule::class,
    ActivityBuilderModule::class,
    FragmentBuilderModule::class,
    NetworkModule::class
]
)
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<App>
}
