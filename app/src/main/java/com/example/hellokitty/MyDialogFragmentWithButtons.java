package com.example.hellokitty;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class MyDialogFragmentWithButtons extends AppCompatDialogFragment {

@NonNull
@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
    String title = "Выбор есть всегда";
    String message = "Выбери пищу";
    String button1String = "Вкусная пища";
    String button2String = "Здоровая пища";
    String button3String = "Не определился";

    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder .setTitle(title)
            .setMessage(message)
            .setIcon(R.drawable.ic_cat)
            .setPositiveButton(button1String, (dialog, id) -> Toast.makeText(getActivity(), "Вы сделали правильный выбор", Toast.LENGTH_LONG).show())
            .setNegativeButton(button2String, (dialog, id) -> Toast.makeText(getActivity(), "Возможно вы правы", Toast.LENGTH_LONG).show())
            .setNeutralButton(button3String, (dialog, id) -> Toast.makeText(getActivity(), "Подумайте хорошенько", Toast.LENGTH_LONG).show());


    builder.setCancelable(true);

    return builder.create();
}
}
