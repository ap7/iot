package fr.ap7.iot.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User constructor(
    @Expose @SerializedName("firstName") val firstName: String,
    @Expose @SerializedName("lastName") val lastName: String,
    @Expose @SerializedName("address") val address: Address,
    @Expose @SerializedName("birthDate") val birthDate: Int
) : Parcelable {

    init {
        println("User object was created")
    }
}