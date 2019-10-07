package fr.ap7.iot.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import fr.ap7.iot.App
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        BuildersModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}