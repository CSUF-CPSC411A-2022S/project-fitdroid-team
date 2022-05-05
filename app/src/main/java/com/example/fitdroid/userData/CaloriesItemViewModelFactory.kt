package com.example.fitdroid.userData
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fitdroid.database.CaloriesDao

/**
 * Generates an CaloriesViewModel tied to the database. It uses the provided calories ID to
 * to create the CaloriesItemViewModel.
 */
class CaloriesItemViewModelFactory(
    private val caloriesId: Long,
    private val dataSource: CaloriesDao, // Data access object
    private val application: Application
): ViewModelProvider.Factory {

    /**
     * Creates the CaloriesViewModel
     */
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CaloriesItemViewModel::class.java)) { // ViewModel class
            return CaloriesItemViewModel(caloriesId, dataSource, application) as T // Call ViewModel constructor
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}