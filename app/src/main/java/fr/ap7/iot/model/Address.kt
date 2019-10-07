package fr.ap7.iot.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Address constructor(
    @Expose @SerializedName("city") val city: String,
    @Expose @SerializedName("postalCode") val postalCode: Int,
    @Expose @SerializedName("street") val street: String,
    @Expose @SerializedName("streetCode") val streetCode: String,
    @Expose @SerializedName("country") val country: String
) : Parcelable {

    init {
        println("Address object was created")
    }
}