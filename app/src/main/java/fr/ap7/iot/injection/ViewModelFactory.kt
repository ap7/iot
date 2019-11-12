package fr.ap7.iot.injection

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import fr.ap7.iot.model.database.AppDatabase
import fr.ap7.iot.ui.DeviceListViewModel

/**
 * ViewModelFactory its a provider to instantiate the PostViewModel class
 *
 * @author Ap7
 */
class ViewModelFactory(private val activity: AppCompatActivity) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DeviceListViewModel::class.java)) {
            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "devices")
                .build()
            @Suppress("UNCHECKED_CAST")
            return DeviceListViewModel(db.userDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}