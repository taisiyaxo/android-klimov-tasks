package com.example.hellokitty;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Обнаружено сообщение: " +
                        intent.getStringExtra("Message"),
                Toast.LENGTH_LONG).show();
//        это нужно проверять на реальном устройстве, приложение оповещает об отключении заряда
//        if (intent.getAction().equalsIgnoreCase("android.intent.action.ACTION_POWER_DISCONNECTED")) {
//            String message = "Обнаружено сообщение "
//                    + intent.getAction();
//
//            Toast.makeText(context, message,
//                    Toast.LENGTH_LONG).show();
//        }
    }
}