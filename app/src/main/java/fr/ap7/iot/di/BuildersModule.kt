package fr.ap7.iot.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import fr.ap7.iot.ui.MainActivity

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector
    internal abstract fun bindMainActivity(): MainActivity
}