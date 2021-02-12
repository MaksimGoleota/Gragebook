package com.merio.gradebook.data.authorization

import android.content.Context
import android.content.SharedPreferences

object PasswordStorage {

    private const val NAME = "PasswordStorage"
    private const val MODE = Context.MODE_PRIVATE
    private var preferences: SharedPreferences? = null
    private val PASSWORD = "password"

    fun init(context: Context) {
        preferences = context.getSharedPreferences(
            NAME,
            MODE
        )
    }

    fun savePassword(newPassword: String) {
        val editor = preferences?.edit()
        if (editor != null) {
            editor.putString(PASSWORD, newPassword)
            editor.apply()
        }
    }

    fun getPassword(): String = preferences?.getString(
        PASSWORD, ""
    ) ?: ""

}