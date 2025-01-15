package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        TextView textView = findViewById(R.id.textView);

        button.setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button){
            showPopupMenu(view);
        }
        else if(view.getId() == R.id.textView){
            showPopupIconMenu(view);
        }
    }

    private void showPopupIconMenu(View view){
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.inflate(R.menu.popup_icon_menu);

        popupMenu
                .setOnMenuItemClickListener(item -> {
                    switch (item.getItemId()) {
                        case R.id.red:
                            Toast.makeText(getApplicationContext(),
                                    "Вы выбрали красную лапку",
                                    Toast.LENGTH_SHORT).show();
                            return true;
                        case R.id.green:
                            Toast.makeText(getApplicationContext(),
                                    "Вы выбрали зеленую лапку",
                                    Toast.LENGTH_SHORT).show();
                            return true;
                        case R.id.yellow:
                            Toast.makeText(getApplicationContext(),
                                    "Вы выбрали жёлтую лапку",
                                    Toast.LENGTH_SHORT).show();
                            return true;
                        default:
                            return false;
                    }
                });

        popupMenu.setOnDismissListener(menu -> Toast.makeText(getApplicationContext(), "onDismiss",
                Toast.LENGTH_SHORT).show());
        popupMenu.show();
    }


        private void showPopupMenu(View view){
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.inflate(R.menu.popup_menu_main);

        popupMenu
                .setOnMenuItemClickListener(item -> {
                    switch (item.getItemId()) {
                        case R.id.menu1:
                            Toast.makeText(getApplicationContext(),
                                    "Вы выбрали PopupMenu 1",
                                    Toast.LENGTH_SHORT).show();
                            return true;
                        case R.id.menu2:
                            Toast.makeText(getApplicationContext(),
                                    "Вы выбрали PopupMenu 2",
                                    Toast.LENGTH_SHORT).show();
                            return true;
                        case R.id.menu3:
                            Toast.makeText(getApplicationContext(),
                                    "Вы выбрали PopupMenu 3",
                                    Toast.LENGTH_SHORT).show();
                            return true;
                        default:
                            return false;
                    }
                });

        popupMenu.setOnDismissListener(menu -> Toast.makeText(getApplicationContext(), "onDismiss",
                Toast.LENGTH_SHORT).show());
        popupMenu.show();
    }
}