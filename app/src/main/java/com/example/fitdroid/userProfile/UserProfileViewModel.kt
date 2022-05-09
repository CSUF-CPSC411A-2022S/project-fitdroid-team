package com.example.fitdroid.userProfile;


import android.app.Application
import com.example.fitdroid.database.User
import com.example.fitdroid.database.UserDao
import kotlinx.coroutines.launch
import androidx.lifecycle.*

class UserProfileViewModel(
    val database: UserDao,
    application: Application) : AndroidViewModel(application) {

    val user = database.getLastUser()
    fun clear() {
        // Launch coroutines in the viewModelScope so that the coroutines are automatically
        // canceled when the ViewModel is destroyed.
        viewModelScope.launch {
            // Delete data from the database using the clear coroutine.
            database.clear()
        }
    }
}
