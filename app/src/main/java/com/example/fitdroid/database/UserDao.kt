package com.example.fitdroid.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

// TODO: Create User data access object (DAO)
@Dao
interface UserDao{
    @Insert
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Query("SELECT * from user_table WHERE UserId = :key")
    fun get(key: Long): LiveData<User>

    @Query("SELECT * from user_table ORDER BY UserId DESC")
    fun getAllUser(): LiveData<List<User>>

    @Query("DELETE from user_table")
    suspend fun clear()
}