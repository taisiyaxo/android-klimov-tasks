package com.example.hellokitty;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class MyDialogFragmentWithList extends AppCompatDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final String[] catNamesArray = {"Васька", "Рыжик", "Мурзик"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Выберите кота")
                .setItems(catNamesArray, (dialog, which) -> Toast.makeText(getActivity(),
                        "Выбранный кот: " + catNamesArray[which],
                        Toast.LENGTH_SHORT).show());

        return builder.create();
    }
}
