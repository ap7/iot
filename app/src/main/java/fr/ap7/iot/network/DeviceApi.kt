package fr.ap7.iot.network

import fr.ap7.iot.model.Data
import io.reactivex.Single
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */
interface DeviceApi {
    /**
     * Get the list of the pots from the API
     */
    @GET("/modulotest/data.json")
    fun getDevices(): Single<Data>
    //fun getDevices(): Observable<Data>
}