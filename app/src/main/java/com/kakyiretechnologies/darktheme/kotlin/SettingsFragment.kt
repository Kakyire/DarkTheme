package com.kakyiretechnologies.darktheme.kotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.kakyiretechnologies.darktheme.R

class SettingsFragment : PreferenceFragmentCompat() {

    private val light = "light"
    private val dark = "dark"
    private val themeKey = "theme"//assign the same key value in the preferences xml file

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)

        //find the key of the theme preference
        val theme = findPreference<ListPreference>(themeKey)
       
        //listen to events or change by user to apply theme
        theme?.onPreferenceChangeListener =
            Preference.OnPreferenceChangeListener { preference, newValue ->
                
                changeTheme(newValue.toString())
                Log.d(TAG, "onCreatePreferences: $newValue")
                
                true
            }
    }

    private fun changeTheme(value: String) = when (value) {
        light -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        dark -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        else -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
    }

}
private const val TAG = "SettingsFragment"
