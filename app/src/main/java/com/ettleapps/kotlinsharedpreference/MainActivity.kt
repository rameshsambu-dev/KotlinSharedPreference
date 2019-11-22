package com.ettleapps.kotlinsharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Insert in to shared preference
        Preferences.email="rameshsambu44@gmail.com"
        
        //Get the data from preference

        println("Email is "+Preferences.email)

    }
}
