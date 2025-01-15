package com.example.hellokitty;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickShowDialogWithButtons(View view) {
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragmentWithButtons myDialogFragment = new MyDialogFragmentWithButtons();
        myDialogFragment.show(manager, "myDialog");
    }

    public void onClickShowDialogWithSingleChoice(View v){
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragmentWithSingleChoice myDialogFragment = new MyDialogFragmentWithSingleChoice();
        myDialogFragment.show(manager, "myDialog");
    }

    public void onClickShowDialogWithMultiChoice(View v){
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragmentWithMultiChoice myDialogFragment = new MyDialogFragmentWithMultiChoice();
        myDialogFragment.show(manager, "myDialog");
    }

    public void onClickShowDialogWithRating(View v){
        showRatingDialog();
    }


    public void onClickShowDialogWithList(View v){
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragmentWithList myDialogFragment = new MyDialogFragmentWithList();
        myDialogFragment.show(manager, "myDialog");
    }

    //диалоговое окно закроется через какое то время
    public void onClickTimerButton(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setTitle("Автоматическое закрытие окна");
        builder.setMessage("Через пять секунд это окно закроется автоматически!");
        builder.setCancelable(true);

        final AlertDialog dlg = builder.create();

        dlg.show();

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                dlg.dismiss();
                timer.cancel();
            }
        }, 5000);
    }

    //открыть окно с передачей данных
    public void onClickWithTransfer(View view){
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragmentWithTransfer myDialogFragment = new MyDialogFragmentWithTransfer();
        myDialogFragment.show(manager, "myDialog");
    }

    //методы которые будут вызываться из диалогового окна
    public void okClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку OK!",
                Toast.LENGTH_LONG).show();
    }

    public void cancelClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку отмены!",
                Toast.LENGTH_LONG).show();
    }

    //создать диалоговое окно с рейтингом
    private void showRatingDialog() {

        final AlertDialog.Builder ratingdialog = new AlertDialog.Builder(this);

        ratingdialog.setIcon(android.R.drawable.btn_star_big_on);
        ratingdialog.setTitle("Голосуем за любимого кота!");

        View linearlayout = getLayoutInflater().inflate(R.layout.ratingdialog, null);
        ratingdialog.setView(linearlayout);

        final RatingBar rating = linearlayout.findViewById(R.id.ratingbar);

        TextView textView = findViewById(R.id.textView);

        ratingdialog.setPositiveButton("Готово",
                        (dialog, which) -> {
                            textView.setText(String.valueOf(rating.getRating()));
                            dialog.dismiss();
                        })

                .setNegativeButton("Отмена",
                        (dialog, id) -> dialog.cancel());

        ratingdialog.create();
        ratingdialog.show();
    }
}