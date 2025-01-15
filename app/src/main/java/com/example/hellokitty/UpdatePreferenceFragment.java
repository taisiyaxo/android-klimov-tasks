package com.example.hellokitty;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class UpdatePreferenceFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference_update);
    }
}