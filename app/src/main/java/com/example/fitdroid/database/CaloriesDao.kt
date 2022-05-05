package com.example.fitdroid.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 * Data access object for the Calories entity. The class describes how data is
 * stored, updated, retrieved, or deleted from the database.
 */
@Dao
interface CaloriesDao {
    // Add an calories entity to a table in the database.
    // We use suspend to run the function asynchronously (coroutine).
    @Insert
    suspend fun insert(calories: Calories)

    // Update an calories entity to a table in the database. Often uses the primary key
    // We use suspend to run the function asynchronously (coroutine).
    @Update
    suspend fun update(calories: Calories)

    // Custom query for retrieving a single Calories from a table in the database using
    // its calories id. We don't use suspend because LiveData objects are already designed
    // to work asynchronous.
    @Query("SELECT * from calories_table WHERE caloriesId = :key")
    fun get(key: Long): LiveData<Calories>?

    // Custom query for retrieving all Calories entities from a table in the database.
    // Data is stored to a List LiveData. We don't use suspend because LiveData objects
    // are already designed to work asynchronously.
    @Query("SELECT * from calories_table ORDER BY caloriesId DESC")
    fun getAllCaloriess(): LiveData<List<Calories>>

    // Custom query for deleting all entities on a table in the database
    // We use suspend to run the function asynchronously (coroutine).
    @Query("DELETE from calories_table")
    suspend fun clear()
}