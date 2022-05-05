package com.example.fitdroid.userData

import android.app.Application
import androidx.lifecycle.*
import com.example.fitdroid.database.CaloriesDao

/**
 * CaloriesViewModel used for data binding. Provides a connection to the database
 * for storing and retrieving corresponding values. It retrieves the corresponding calories
 * with the provided calories ID.
 */
class CaloriesItemViewModel(
    val caloriesId: Long,
    val database: CaloriesDao, // Data access object for the Calories entity
    application: Application
) : AndroidViewModel(application) {

    // Retrieves a LiveData-wrapped calories object given its ID
    val calories = database.get(caloriesId)
}