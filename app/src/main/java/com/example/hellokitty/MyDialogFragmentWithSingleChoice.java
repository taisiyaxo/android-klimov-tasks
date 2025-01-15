package com.example.hellokitty;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class MyDialogFragmentWithSingleChoice extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final String[] catNamesArray = {"Васька", "Рыжик", "Мурзик"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Выберите любимое имя кота")
                // добавляем переключатели
                .setSingleChoiceItems(catNamesArray, -1,
                        (dialog, item) -> Toast.makeText(
                                getActivity(),
                                "Любимое имя кота: "
                                        + catNamesArray[item],
                                Toast.LENGTH_SHORT).show())
                .setPositiveButton("OK", (dialog, id) -> {

                })
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        return builder.create();
    }
}
