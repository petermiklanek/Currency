package app.petermiklanek.currency.injection.modules

import android.content.Context
import android.content.res.Resources
import androidx.preference.PreferenceManager
import androidx.room.Room
import app.petermiklanek.currency.App
import app.petermiklanek.currency.data.database.AppDatabase
import app.petermiklanek.currency.injection.ApplicationContext
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @ApplicationContext
    fun context(app: App): Context = app

    @Singleton
    @Provides
    fun resources(@ApplicationContext context: Context): Resources = context.resources

    @Singleton
    @Provides
    fun moshi(): Moshi = Moshi.Builder()
        .build()

    @Singleton
    @Provides
    fun sharedPrefs(@ApplicationContext context: Context) =
        PreferenceManager.getDefaultSharedPreferences(context)

    @Singleton
    @Provides
    fun database(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.CURRENCY_DATABASE)
            .fallbackToDestructiveMigration()
            .build()
    }
}
