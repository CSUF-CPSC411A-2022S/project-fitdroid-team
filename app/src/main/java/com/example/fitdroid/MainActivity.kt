package com.example.fitdroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Food(var calories: Int, var name: String){
    init{
        print("making food")
    }

    constructor() : this(0, "unknown") {
    }

    fun printInfo(){
        print("$name - calories:$calories")
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}