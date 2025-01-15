package com.example.hellokitty;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.view.Menu;

public class MyPreferenceActivity extends PreferenceActivity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        // addPreferencesFromResource(R.xml.settings); // устаревший метод
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new MyPreferenceFragment())
                .commit();

    }
}
