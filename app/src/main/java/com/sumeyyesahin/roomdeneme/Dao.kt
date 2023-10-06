package com.sumeyyesahin.roomdeneme

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sumeyyesahin.roomdeneme.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM users")
    fun getAllUsers(): Flow<List<User>>
}