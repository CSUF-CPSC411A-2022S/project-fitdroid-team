package com.example.fitdroid.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// TODO: Create Profile entity
@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    var UserId: Long = 0L,

    @ColumnInfo()
    var name: String = "",

    @ColumnInfo()
    var email: String = "",

    @ColumnInfo()
    var gender: String = "",

    @ColumnInfo()
    var age: String = "",

    @ColumnInfo()
    var zipCode: String = "",

)