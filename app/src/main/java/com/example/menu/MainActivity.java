package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        Display display = getWindowManager().getDefaultDisplay();
//        Point   point   = new Point();
//        display.getSize(point);
//
//        TextView textView = findViewById(R.id.textView);
//        textView.setText("Width: " + point.x + "\n" +"Height: " + point.y);

        //другой способ

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        String strScreen = "";
        strScreen += "Width: " + metrics.widthPixels + " pixels"
                + "\n";
        strScreen += "Height: " + metrics.heightPixels + " pixels"
                + "\n";
        strScreen += "The Logical Density: " + metrics.density
                + "\n";
        strScreen += "X Dimension: " + metrics.xdpi + " dot/inch"
                + "\n";
        strScreen += "Y Dimension: " + metrics.ydpi + " dot/inch"
                + "\n";
        strScreen += "The screen density expressed as dots-per-inch: "
                + metrics.densityDpi + "\n";
        strScreen += "A scaling factor for fonts displayed on the display: "
                + metrics.scaledDensity + "\n";

        TextView infoTextView = findViewById(R.id.textView);


        //получение яркости
        try {
            int curBrightnessValue = android.provider.Settings.System.getInt(
                    getContentResolver(),
                    android.provider.Settings.System.SCREEN_BRIGHTNESS);
            strScreen += "\nТекущая яркость экрана: " + curBrightnessValue;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        infoTextView.setText(strScreen);
    }


}