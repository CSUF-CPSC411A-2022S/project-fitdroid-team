package com.example.fitdroid.calorieslist

import android.app.Application
import androidx.lifecycle.*
import com.example.fitdroid.database.Calories
import com.example.fitdroid.database.CaloriesDao
import kotlinx.coroutines.launch

/**
 * CaloriesViewModel used for data binding. Provides a connection to the database
 * for storing and retrieving corresponding values.
 */
class CaloriesViewModel(
    val database: CaloriesDao, // Data access object for the Calories entity
    application: Application
) : AndroidViewModel(application) {

    // Used to assign and retrieve name and location values from the interface.
    var name = MutableLiveData("")
    var location = MutableLiveData("")

    // Retrieves all Calories objects from the database
    // Represented as a LiveData<List<Calories>>
    val caloriesList = database.getAllCaloriess()

    /**
     * Inserts the Calories object into the database.
     */
    fun insert() {
        // Launch coroutines in the viewModelScope so that the coroutines are automatically
        // canceled when the ViewModel is destroyed.
        viewModelScope.launch {
            // Create Calories object using data stored in the EditText views
            var calories = Calories()
            calories.name = name.value.toString()
            calories.location = location.value.toString()

            // Insert data to the database using the insert coroutine.
            database.insert(calories)
        }
    }

    /**
     * Deletes all Calories entities in the database.
     */
    fun clear() {
        // Launch coroutines in the viewModelScope so that the coroutines are automatically
        // canceled when the ViewModel is destroyed.
        viewModelScope.launch {
            // Delete data from the database using the clear coroutine.
            database.clear()
        }
    }
}