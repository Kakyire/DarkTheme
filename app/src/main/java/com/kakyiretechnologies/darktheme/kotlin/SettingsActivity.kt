package com.kakyiretechnologies.darktheme.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kakyiretechnologies.darktheme.R

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        //add the settings fragment to its activity
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, SettingsFragment())
            .commit()
    }
}