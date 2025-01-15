package com.example.hellokitty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class AboutActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        String recipient = getIntent().getStringExtra("nameRecipient");
        String describe  = getIntent().getStringExtra("describe");

        TextView info = findViewById(R.id.textview_about_content);
        info.setText("Кому: "          + recipient
                     + "\n" + "Посылка: " + describe);



    }

    public void onAnswerClick(View view){
        Intent answerIntent = new Intent();
        answerIntent.putExtra("answer_intent", "Thank you!!!");
        setResult(RESULT_OK, answerIntent);
        finish();

    }
}
