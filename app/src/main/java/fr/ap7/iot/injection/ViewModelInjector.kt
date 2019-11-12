package fr.ap7.iot.injection

import dagger.Component
import fr.ap7.iot.module.NetworkModule
import fr.ap7.iot.ui.DeviceListViewModel
import fr.ap7.iot.ui.DeviceViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    /**
     * Injects required dependencies into the specified PostListViewModel.
     * @param deviceListViewModel DeviceListViewModel in which to inject the dependencies
     */
    fun inject(deviceListViewModel: DeviceListViewModel)

    /**
     * Injects required dependencies into the specified PostListViewModel.
     * @param deviceViewModel DeviceViewModel in which to inject the dependencies
     */
    fun inject(deviceViewModel: DeviceViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}