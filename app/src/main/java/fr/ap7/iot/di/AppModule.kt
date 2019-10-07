package fr.ap7.iot.di

import android.content.Context
import dagger.Module
import dagger.Provides
import fr.ap7.iot.App
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app: App): Context {
        return app.applicationContext
    }

}