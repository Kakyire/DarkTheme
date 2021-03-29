package com.kakyiretechnologies.darktheme.java;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;

import com.kakyiretechnologies.darktheme.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    private final String light = "light";
    private final String dark = "dark";
    private final String themeKey = "theme"; //assign the same key value in the preferences xml file

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);

        //find the key of the theme preference
        ListPreference theme = findPreference(themeKey);

        //listen to events or change by user to apply theme
        theme.setOnPreferenceChangeListener((preference, newValue) -> {
            changeTheme(newValue.toString());
            return true;
        });
    }

    private void changeTheme(String value) {

        if (value.equals(light)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            return;
        }

        if (value.equals(dark)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            return;
        }

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
    }


}
