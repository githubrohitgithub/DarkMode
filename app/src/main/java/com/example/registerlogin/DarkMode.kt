package com.example.registerlogin

import `in`.madapps.prefrences.EasyPreferences
import `in`.madapps.prefrences.EasyPreferences.get
import `in`.madapps.prefrences.EasyPreferences.set
import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate

object DarkMode {



    fun applyTheme(enabled: Boolean = false,context: Context) {
        val nightMode = if (enabled) {
            saveModePref(enabled,context)
            AppCompatDelegate.MODE_NIGHT_YES
        } else {
            saveModePref(enabled,context)
            AppCompatDelegate.MODE_NIGHT_NO
        }
        saveModePref(enabled,context)
        AppCompatDelegate.setDefaultNightMode(nightMode)
    }

    fun isDarkThemeEnabled(context: Context): Boolean {
        return context.resources.configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK ==
                Configuration.UI_MODE_NIGHT_YES
    }

    fun saveModePref(enabled: Boolean,context: Context){
        val prefs = EasyPreferences.defaultPrefs(context)
        prefs["DarkMode"] = enabled

    }

    fun getModePref(context: Context): Boolean? {
        val prefs = EasyPreferences.defaultPrefs(context)
        return prefs["DarkMode",false]

    }



}