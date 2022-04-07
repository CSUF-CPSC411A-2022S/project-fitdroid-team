package com.example.fitdroid.UserData

import android.util.Log
import androidx.lifecycle.ViewModel

class UserModel : ViewModel() {
    private var _gender = ""
    val gender: String
        get() = _gender

    private var _age = 0
    val age: Int
        get() = _age

    private var _zipCode = ""
    val zipCode: String
        get() = _zipCode

    init {
        _gender = ""
        _age = 0
        _zipCode = ""
        Log.d("GameFragment", "GameViewModel created!")
    }
}