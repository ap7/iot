package fr.ap7.iot.ui

import android.view.View
import androidx.lifecycle.MutableLiveData
import fr.ap7.iot.BaseViewModel
import fr.ap7.iot.R
import fr.ap7.iot.model.Device
import fr.ap7.iot.model.UserDao
import fr.ap7.iot.network.DeviceApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * ViewModel component and injection
 *
 * get results from API then display it in the view
 *
 * @author Ap7
 */
class DeviceListViewModel(private val userDao: UserDao) : BaseViewModel() {
    @Inject
    lateinit var deviceApi: DeviceApi

    val deviceListAdapter: DeviceListAdapter = DeviceListAdapter()

    /**
     * A MutableLiveData the view will be able to observe in order to update the visibility of the ProgressBar we will show while retrieving the data from the API.
     */
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadPosts() }

    private lateinit var subscription: Disposable

    init {
        loadPosts()
        Timber.i("called to load post method")
    }

    /**
     * Android ViewModel provides the onCleared() method which will be called when this occurs.
     *
     *  @param "subscription" Is a property when the ViewModel is no longer used and will be destroyed.
     */
    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
        Timber.i("onCleared is called")
    }

    private fun loadPosts() {
        /* subscription = Observable.fromCallable { userDao.selectAllUsers }
            .concatMap {
                    dbPostList ->
                deviceApi.getDevices().concatMap { apiPostList -> userDao.insertAll(apiPostList.user)
                    Observable.just(apiPostList)
                }
            }*/
        subscription = deviceApi.getDevices()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }
            .subscribe(
                { result -> onRetrievePostListSuccess(result.devices) },
                {
                    Timber.i(it.fillInStackTrace())
                    it.printStackTrace()
                    onRetrievePostListError()
                }
            )
    }

    fun onRetrievePostListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
        Timber.i("Retrieve data is beginning")
    }

    fun onRetrievePostListFinish() {
        loadingVisibility.value = View.GONE
        Timber.i("Retrieve data is finished")
    }

    private fun onRetrievePostListSuccess(deviceList: List<Device>) {
        // set the DeviceListAdapter to the RecyclerView
        deviceListAdapter.updatePostList(deviceList)
        Timber.i("Retrieve data is succeed: $deviceList")
        onRetrievePostListFinish()
    }

    private fun onRetrievePostListError() {
        errorMessage.value = R.string.post_error
        onRetrievePostListFinish()
        Timber.i("Failed to retrieve data")
    }
}