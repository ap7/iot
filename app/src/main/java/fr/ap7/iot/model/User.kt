package fr.ap7.iot.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

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
@Entity
data class User (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    val firstName: String,
    val lastName: String,
    @Embedded
    val address: Address,
    val birthDate: Long
)