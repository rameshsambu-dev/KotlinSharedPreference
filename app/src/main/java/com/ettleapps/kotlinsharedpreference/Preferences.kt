package com.ettleapps.kotlinsharedpreference

import android.content.Context
import android.content.SharedPreferences

object Preferences {

    private const val NAME = "TestPref"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    private val EMAIL = Pair("email", "")

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }


    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var email: String
        get() = preferences.getString(EMAIL.first, EMAIL.second)
        set(value) = preferences.edit {
            it.putString(EMAIL.first, value)
        }

}