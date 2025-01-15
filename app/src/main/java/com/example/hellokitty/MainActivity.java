package com.example.hellokitty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button   mRavenCounterButton;
    private int      mRavenCounter;
    private TextView mInfoTextView;

    private final String APP_PREFERENCES_COUNTER = "ravenCounter";

    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE);


        mInfoTextView = findViewById(R.id.info_counter_raven);
        mRavenCounterButton = findViewById(R.id.button_counter);

        mRavenCounterButton.setOnClickListener(
                view -> mInfoTextView.setText("Я насчитал: " + ++mRavenCounter)
        );


    }

    public void onClick(View view) {
        TextView helloTextView = findViewById(R.id.textView);
        helloTextView.setText("Hello Kitty!");
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(sharedPreferences.contains(APP_PREFERENCES_COUNTER)){
            mRavenCounter = sharedPreferences.getInt(APP_PREFERENCES_COUNTER, 0);
            mInfoTextView.setText("Я насчитал: " + mRavenCounter);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(APP_PREFERENCES_COUNTER, mRavenCounter).apply();

    }
}