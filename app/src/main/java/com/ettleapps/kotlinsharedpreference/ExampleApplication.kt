package com.ettleapps.kotlinsharedpreference

import android.app.Application

open class ExampleApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        Preferences.init(this)
    }

}