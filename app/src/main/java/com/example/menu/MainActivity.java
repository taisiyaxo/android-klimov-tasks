package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener {

    private EditText editSearch;
    private EditText editGo;
    private EditText editDone;
    private EditText editSend;
    private EditText editNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //меняю клавиатуру
        EditText ipt = findViewById(R.id.editText);
        ipt.setInputType(InputType.TYPE_CLASS_PHONE);

        //принудительно вызвать клавиатуру программно
//        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

        EditText editSearch = findViewById(R.id.editSearch);
        EditText editGo     = findViewById(R.id.editGo);
        EditText editDone   = findViewById(R.id.editDone);
        EditText editSend   = findViewById(R.id.editSend);
        EditText editNext   = findViewById(R.id.editNext);

        editSearch.setOnEditorActionListener(this);
        editGo    .setOnEditorActionListener(this);
        editDone  .setOnEditorActionListener(this);
        editSend  .setOnEditorActionListener(this);
        editNext  .setOnEditorActionListener(this);

        //установить программно Action
        //editDone.setImeActionLabel("Мяу", EditorInfo.IME_ACTION_SEARCH);
    }

    private static long back_pressed;
    //выход при двойном нажатии
    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis())
            super.onBackPressed();
        else
            Toast.makeText(getBaseContext(), "Press once again to exit!",
                    Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }
    //нажатие кнопки HOME
//    @Override
//    protected void onUserLeaveHint() {
//        Toast toast = Toast.makeText(getApplicationContext(), "Нажата кнопка HOME", Toast.LENGTH_SHORT);
//        toast.show();
//        super.onUserLeaveHint();
//    }


    //    @Override
//    public void onBackPressed() {
//        // super.onBackPressed();
//        openQuitDialog();
//    }

    //отслежевание нажатие кнопок
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            //отследить кнопку меню
            case KeyEvent.KEYCODE_MENU:
                Toast.makeText(this, "Нажата кнопка Меню", Toast.LENGTH_SHORT)
                        .show();
                return true;
                //отследить кнопку поиска (раньше на старых устройствах было)
            case KeyEvent.KEYCODE_SEARCH:
                Toast.makeText(this, "Нажата кнопка Поиск", Toast.LENGTH_SHORT)
                        .show();
                return true;
                //отследить кнопку назад
            case KeyEvent.KEYCODE_BACK:
                onBackPressed();
                return true;
                //отследить нажатие кнопки громкости
            case KeyEvent.KEYCODE_VOLUME_UP:
                event.startTracking();
                return true;
                //отследить нажатие кнопки громкости
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                Toast.makeText(this, "Нажата кнопка громкости", Toast.LENGTH_SHORT)
                        .show();
                return false;
        }
        return super.onKeyDown(keyCode, event);
    }


    //выводить окно перед выходом
    private void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                MainActivity.this);
        quitDialog.setTitle("Выход: Вы уверены?");

        quitDialog.setPositiveButton("Таки да!", (dialog, which) -> finish());

        quitDialog.setNegativeButton("Нет", (dialog, which) -> {
            // TODO Auto-generated method stub
        });

        quitDialog.show();
    }

    @Override
    //обработка клавиши ентер
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            // обрабатываем нажатие кнопки поиска
            Toast.makeText(this, "Не буду ничего искать!", Toast.LENGTH_LONG).show();
            return true;
        }
        if (actionId == EditorInfo.IME_ACTION_GO) {
            Toast.makeText(this, "Go!!!", Toast.LENGTH_LONG).show();
            return true;
        }

        if (actionId == EditorInfo.IME_ACTION_NEXT) {
            Toast.makeText(this, "Next!!!", Toast.LENGTH_LONG).show();
            return true;
        }

        if (actionId == EditorInfo.IME_ACTION_DONE) {
            Toast.makeText(this, "Done!!!", Toast.LENGTH_LONG).show();

            return true;
        }

        if (actionId == EditorInfo.IME_ACTION_SEND) {
            Toast.makeText(this, "Send!!!", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }
}