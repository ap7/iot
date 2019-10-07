package fr.ap7.iot.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Device constructor(
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("deviceName") val deviceName: String,
    @Expose @SerializedName("intensity") val intensity: Int,
    @Expose @SerializedName("mode") val mode: String,
    @Expose @SerializedName("productType") val productType: String,
    @Expose @SerializedName("position") val position: Int,
    @Expose @SerializedName("temperature") val temperature: Int
) : Parcelable {

    init {
        println("Device object was created")
    }
}