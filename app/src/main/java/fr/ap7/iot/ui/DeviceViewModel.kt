package fr.ap7.iot.ui

import androidx.lifecycle.MutableLiveData
import fr.ap7.iot.BaseViewModel
import fr.ap7.iot.model.Device

/**
 * PostViewModel associated to an PostListActivity
 *
 * Displaying the list of Posts.
 *
 * To do so, I created a ViewModel for each item of the list
 * Here I have just one
 *
 * @author Ap7
 */
class DeviceViewModel : BaseViewModel() {

    private val deviceTitle = MutableLiveData<String>()
    private val productName = MutableLiveData<String>()
    private val deviceMode = MutableLiveData<String>()
    private val intensity = MutableLiveData<Int>()

    fun bind(device: Device) {
        deviceTitle.value = device.deviceName
        productName.value = device.productType
        deviceMode.value = device.mode
        intensity.value = device.intensity
    }

    fun getDeviceName(): MutableLiveData<String> {
        return deviceTitle
    }

    fun getProductType(): MutableLiveData<String> {
        return productName
    }

    fun getMode(): MutableLiveData<String> {
        return deviceMode
    }

    fun getIntensity(): MutableLiveData<Int> {
        return intensity
    }
}