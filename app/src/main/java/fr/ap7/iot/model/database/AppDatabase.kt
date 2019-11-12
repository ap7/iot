package fr.ap7.iot.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.ap7.iot.model.Device
import fr.ap7.iot.model.User
import fr.ap7.iot.model.UserDao

/**
 * AppDatabase class its my database
 *
 * @author Ap7
 */
@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}