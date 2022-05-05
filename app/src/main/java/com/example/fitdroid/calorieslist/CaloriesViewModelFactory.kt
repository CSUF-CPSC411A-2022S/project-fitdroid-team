package com.example.fitdroid.calorieslist

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fitdroid.database.CaloriesDao

/**
 * Generates an CaloriesViewModel tied to the database.
 */
class CaloriesViewModelFactory(
    private val dataSource: CaloriesDao, // Data access object
    private val application: Application
) : ViewModelProvider.Factory {

    /**
     * Creates the CaloriesViewModel
     */
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CaloriesViewModel::class.java)) { // ViewModel class
            return CaloriesViewModel(dataSource, application) as T // Call ViewModel constructor
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}