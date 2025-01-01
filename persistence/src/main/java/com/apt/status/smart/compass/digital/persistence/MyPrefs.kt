package com.apt.status.smart.compass.digital.persistence

import android.content.Context

class MyPrefs(
    context: Context
) {

    private val prefs = context.getSharedPreferences("Main", Context.MODE_PRIVATE)
    private val prefsEdit = prefs.edit()
    var localeLanguageCode: String?
        get() = prefs.getString("localeLanguageCode", null)
        set(value) = prefs.edit().putString("localeLanguageCode", value).apply()
    var sessionCount: Int
        get() = prefs.getInt("sessionCount", 0)
        set(value) = prefsEdit.putInt("sessionCount", value).apply()
}