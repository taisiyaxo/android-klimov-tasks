package com.example.hellokitty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TimeBroadcastReceiver mTimeBroadCastReceiver = new TimeBroadcastReceiver();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static final String WHERE_MY_CAT_ACTION = "action.CAT";
    public static final String ALARM_MESSAGE = "Срочно пришлите кота!";

    //почему то не работает
    public void sendMessage(View view) {
        Intent intent = new Intent(WHERE_MY_CAT_ACTION);
        intent.putExtra("Message", ALARM_MESSAGE);
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }

    public void registerBroadcastReceiver(View view) {
        this.registerReceiver(mTimeBroadCastReceiver, new IntentFilter(
                "android.intent.action.TIME_TICK"));
        Toast.makeText(getApplicationContext(), "Приёмник включен",
                Toast.LENGTH_SHORT).show();
    }

    public void unregisterBroadcastReceiver(View view) {
        this.unregisterReceiver(mTimeBroadCastReceiver);

        Toast.makeText(getApplicationContext(), "Приёмник выключён", Toast.LENGTH_SHORT)
                .show();
    }
}