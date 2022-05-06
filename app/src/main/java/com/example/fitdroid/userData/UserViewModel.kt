package com.example.fitdroid.userData

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.fitdroid.database.User
import com.example.fitdroid.database.UserDao
import kotlinx.coroutines.launch

class UserViewModel(
    val database: UserDao,
    application: Application) : AndroidViewModel(application) {
    //_name
    //_gender
    //_age
    //_zipCode
    var name = MutableLiveData("")
    var email = MutableLiveData("")
    var gender = MutableLiveData("")
    var age = MutableLiveData("")
    var address = MutableLiveData("")

    val UserList = database.getAllUser()

    var UserString = Transformations.map(UserList){
            users ->
        var result = ""
        for(user in users){
            result += "${user.name} @ ${user.gender}\n"
        }
        result
    }
    fun insert(){
        viewModelScope.launch {
            var user = User()
            user.name = name.value.toString()
            user.email = email.value.toString()
            user.gender = gender.value.toString()
            user.age = Integer.parseInt(age.value.toString())
            user.address = address.value.toString()

            database.insert(user)
        }
    }

    fun clear() {
        // Launch coroutines in the viewModelScope so that the coroutines are automatically
        // canceled when the ViewModel is destroyed.
        viewModelScope.launch {
            // Delete data from the database using the clear coroutine.
            database.clear()
        }
    }
}