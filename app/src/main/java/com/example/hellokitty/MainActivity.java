package com.example.hellokitty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView mHelloTextView;
    private EditText mNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mHelloTextView = findViewById(R.id.textView);
        mNameEditText = findViewById(R.id.textnameCat);


        Log.i("MainActivity", "onCreate() called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "onStart() called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainActivity", "onRestart() called");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity", "onResume() called");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity", "onCreate() called");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity", "onStop() called");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity", "onDestroy() called");

    }

    public void onClick(View view) {
        if(mNameEditText.getText().length() == 0){
           mHelloTextView.setText("Hello, Kitty");
        } else {
            mHelloTextView.setText("Hello, " + mNameEditText.getText());
        }
    }
}