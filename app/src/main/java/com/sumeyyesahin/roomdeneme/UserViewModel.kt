package com.sumeyyesahin.roomdeneme

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.sumeyyesahin.roomdeneme.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

// Veritabanı işlemleri için ViewModel
class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val userDao = MyApp.database.userDao()

    fun insertUser(firstName: String, lastName: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val user = User(firstName = firstName, lastName = lastName)
            userDao.insert(user)
        }
    }

    fun getAllUsers(): Flow<List<User>> {
        return userDao.getAllUsers()
    }
}
