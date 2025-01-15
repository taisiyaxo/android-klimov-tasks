package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Получим ссылку на солнце
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startAnimation();
    }

    public void onClick(View view) {
        startAnimation();
    }

    private void startAnimation(){
        ImageView sunImageView = findViewById(R.id.sun);
        // Анимация для восхода солнца
        Animation sunRiseAnimation = AnimationUtils.loadAnimation(this, R.anim.sun_rise);
        // Подключаем анимацию к нужному View
        sunImageView.startAnimation(sunRiseAnimation);

        ImageView clockImageView = findViewById(R.id.clock);
        // анимация для вращения часов
        Animation clockTurnAnimation = AnimationUtils.loadAnimation(this, R.anim.clock_turn);
        clockImageView.startAnimation(clockTurnAnimation);

        // получим ссылку на часовую стрелку
        ImageView hourImageView = findViewById(R.id.hour_hand);
        // анимация для стрелки
        Animation hourTurnAnimation = AnimationUtils.loadAnimation(this, R.anim.hour_turn);
        // присоединяем анимацию
        hourImageView.startAnimation(hourTurnAnimation);
    }


}