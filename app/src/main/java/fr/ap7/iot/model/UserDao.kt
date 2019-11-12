package fr.ap7.iot.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 * DAO class to allow us to insert and retrievePosts
 *
 * I use a PostDao instance in the PostViewModel to retrieve Post from the database and insert them.
 * we will add a PostDao argument to the constructor of PostListViewModel
 *
 * @author Ap7
 */
@Dao
interface UserDao {
    @get:Query("SELECT * FROM user")
    val selectAllUsers: User

    @Insert
    fun insertAll(vararg users: User)

    @Update
    fun updateUser(task: User)
}