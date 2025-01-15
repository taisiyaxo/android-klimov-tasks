package com.example.hellokitty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.*;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView settingCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settingCheckBox = findViewById(R.id.setting_cat_height);
    }

    public void onClickSetting(View view) {
        Intent intent = new Intent(this, MyPreferenceActivity.class);
        startActivityForResult(intent, 0);
    }

    public void onClickRingtone(View view){
        Intent intent = new Intent(this, RingtonePreferenceActivity.class);
        startActivity(intent);
    }

    public void onClickHeader(View view){
        Intent intent = new Intent(this, HeaderPrefsActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);

        int catHeight = sharedPreferences.getInt("height", 20);
        // Добавим TextView, в котором будем выводить значение настройки

        settingCheckBox.setText("Высота кота = "
                + catHeight);
    }

}