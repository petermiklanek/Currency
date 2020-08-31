package app.petermiklanek.currency.ui.currency

import dagger.Module
import dagger.Provides

@Module
class CurrenciesFragmentModule {

    @Provides
    fun view(fragment: CurrenciesFragment): CurrenciesView = fragment
}
