package com.example.mkl_9.drawerapplication;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SettingsFragment extends PreferenceFragment
        implements Preference.OnPreferenceChangeListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_general);

    }
    @Override
    public boolean onPreferenceChange(Preference preference, Object value) {

        Log.v("prefer", "nuuuuuuuuuuuul");
        NavigationView navigationView = getView().findViewById(R.id.nav_view);
        navigationView.getMenu().clear();

        return true;
    }
}