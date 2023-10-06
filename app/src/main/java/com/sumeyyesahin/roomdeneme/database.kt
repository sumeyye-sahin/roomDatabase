package com.sumeyyesahin.roomdeneme

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sumeyyesahin.roomdeneme.model.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}