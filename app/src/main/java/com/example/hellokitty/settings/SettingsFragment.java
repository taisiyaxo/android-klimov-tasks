package com.example.hellokitty.settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.example.hellokitty.R;

public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferebces);
    }

}
