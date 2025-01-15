package com.example.hellokitty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class InputActivity extends Activity {

    static final private int ANSWER_ABOUT = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_activity);

    }

    public void onClick(View view){
        EditText nameRecipientEditText = findViewById(R.id.name_recipient);
        EditText describeEditText      = findViewById(R.id.describe);

        Intent intent = new Intent(InputActivity.this, AboutActivity.class);

        intent.putExtra("nameRecipient", nameRecipientEditText.getText().toString());
        intent.putExtra("describe", describeEditText.getText().toString());

        System.out.println(nameRecipientEditText.getText());
        System.out.println(describeEditText.getText());

        startActivityForResult(intent, ANSWER_ABOUT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView infoTextView = findViewById(R.id.info_answer);

        if (requestCode == ANSWER_ABOUT) {
            if (resultCode == RESULT_OK) {
                String ans = data.getStringExtra("answer_intent");
                infoTextView.setText(ans);
            }else {
                infoTextView.setText(""); // стираем текст
            }
        }
    }
}
