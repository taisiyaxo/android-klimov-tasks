package com.example.hellokitty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    private String[] titles = {
            "00. Начало",
            "01. Чем кормить кота",
            "02. Как гладить кота",
            "03. Как спит кот",
            "04. Как играть с котом",
            "05. Как разговаривать с котом",
            "06. Интересные факты из жизни котов",
            "07. Как назвать кота"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        //устанавливаем массив в ListView
        listView.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles));
        listView.setTextFilterEnabled(true);

        //Обрабатываем щелчки на элементах ListView:
        listView.setOnItemClickListener((a, v, position, id) -> {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, SecondActivity.class);

            intent.putExtra("title", position);

            //запускаем вторую активность
            startActivity(intent);
        });

    }
}