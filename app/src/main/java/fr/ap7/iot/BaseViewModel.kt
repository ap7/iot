package fr.ap7.iot

import androidx.lifecycle.ViewModel
import fr.ap7.iot.injection.DaggerViewModelInjector
import fr.ap7.iot.injection.ViewModelInjector
import fr.ap7.iot.module.NetworkModule
import fr.ap7.iot.ui.DeviceListViewModel
import fr.ap7.iot.ui.DeviceViewModel
import timber.log.Timber

/**
 * Use it for dependency injection only
 *
 * ViewModel class is an Android Architecture Components
 * I added dependency to the lifecycle extension library (which includes both ViewModel and LiveData libraries)
 *
 * Help me to inject data model to my android view
 *
 * @author Ap7
 */

abstract class BaseViewModel : ViewModel() {

   private val injector: ViewModelInjector = DaggerViewModelInjector
    .builder()
    .networkModule(NetworkModule)
    .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is DeviceListViewModel -> {
                injector.inject(this)
                Timber.i("devicelist view model was injected")
            }
            is DeviceViewModel -> {
                injector.inject(this)
                Timber.i("device view model was injected")
            }
        }
    }
}