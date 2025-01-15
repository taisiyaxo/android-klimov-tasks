package com.example.hellokitty;

import android.preference.PreferenceActivity;

import java.util.List;

public class HeaderPrefsActivity extends PreferenceActivity {

    @Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.header_settings, target);
    }

    protected boolean isValidFragment(String fragmentName) {
        return UpdatePreferenceFragment.class.getName().equals(fragmentName);
    }
}