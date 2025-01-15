package com.example.hellokitty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFour;
    private Button buttonFive;
    private Button buttonSix;
    private TextView textView;
    private int number = 0;
    private static final String KEY_NUMBER = "NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView    = findViewById(R.id.textView);
        buttonOne   = findViewById(R.id.button);
        buttonTwo   = findViewById(R.id.button2);
        buttonThree = findViewById(R.id.button3);
        buttonFour  = findViewById(R.id.button4);
        buttonFive  = findViewById(R.id.button5);
        buttonSix   = findViewById(R.id.button6);

        buttonOne   .setOnClickListener(this);
        buttonTwo   .setOnClickListener(this);
        buttonThree .setOnClickListener(this);
        buttonFour  .setOnClickListener(this);
        buttonFive  .setOnClickListener(this);
        buttonSix   .setOnClickListener(this);

        if(savedInstanceState != null){
            number = savedInstanceState.getInt(KEY_NUMBER, 0);
            textView.setText(""+number);
        }

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button: {
                number = 1;
                break;
            }
            case R.id.button2: {
                number = 2;
                break;
            }
            case R.id.button3: {
                number = 3;
                break;
            }
            case R.id.button4: {
                number = 4;
                break;

            }
            case R.id.button5: {
                number = 5;
                break;
            }
            case R.id.button6: {
                number = 6;
                break;

            }

        }
        textView.setText(""+number);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(KEY_NUMBER, number);
    }
}