package fr.ap7.iot.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data constructor(
    @Expose @SerializedName("devices") val devices: List<Device>,
    @Expose @SerializedName("user") val user: User
) : Parcelable {

    init {
        println("Data object was created")
    }
}