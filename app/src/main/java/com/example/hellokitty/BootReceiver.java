package com.example.hellokitty;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {
    Context mContext;
    private final String BOOT_ACTION = "android.intent.action.BOOT_COMPLETED";

    //чтобы приложение запускалось при включении, для этого нужно зарегестрировать в манифесте
    @Override
    public void onReceive(Context context, Intent intent) {
        mContext = context;
        String action = intent.getAction();
        if (action.equalsIgnoreCase(BOOT_ACTION)) {

            Intent activivtyIntent = new Intent(context, MainActivity.class);
            activivtyIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(activivtyIntent);

        }
    }
}