package fr.ap7.iot.model

/**
 * Class which provides a model for post
 *
 * Defining Post object as it is in the JSONPlaceholder API.
 *
 * @constructor Sets all properties of the post
 * @property userId the unique identifier of the author of the post
 * @property id the unique identifier of the post
 * @property title the title of the post
 * @property body the content of the post
 *
 *  @author Ap7
 */
data class Device(
    val id: Int,
    val deviceName: String,
    val position: Int? = null,
    val mode: String? = null,
    val intensity: Int? = null,
    val temperature: Int? = null,
    val productType: String
)