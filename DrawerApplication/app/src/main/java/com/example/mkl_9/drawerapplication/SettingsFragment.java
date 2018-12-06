package com.example.mkl_9.drawerapplication;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SettingsFragment extends PreferenceFragment
        implements Preference.OnPreferenceChangeListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_general);

      /*  Preference attPref = findPreference("attack");
        attPref.setOnPreferenceChangeListener(this);

        SharedPreferences sh_att = PreferenceManager
                .getDefaultSharedPreferences(this.getActivity().getApplicationContext());

        onPreferenceChange(attPref, sh_att.getString(attPref.getKey(),""));
        addPreferencesFromResource(R.xml.pref_general);
        */
    }
    @Override
    public boolean onPreferenceChange(Preference preference, Object value) {
        String stringValue = value.toString();

      //  Log.v("deneme", Integer.parseInt(value.toString()) + "");
      //  if(preference.getKey().equals("attack"))

        //preference.setSummary(stringValue);
        return true;
    }
}