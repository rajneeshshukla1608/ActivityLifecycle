package com.rajneesh.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

     var titlename: String? = "Avengers"
     lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        setContentView(R.layout.scrollview_example)

        titlename = sharedPreferences.getString("Title", "The Avengers")
        title = titlename


    }

    fun main_act_tony(view: View) {
        val intent = Intent(this@MainActivity,new_tony::class.java)
        startActivity(intent)
    }

}

    