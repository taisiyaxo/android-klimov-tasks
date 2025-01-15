package com.example.hellokitty;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class MyDialogFragmentWithMultiChoice extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final String[] catNamesArray = {"Васька", "Рыжик", "Мурзик"};
        final boolean[] checkedItemsArray = {false, true, false};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Выберите котов")
                .setMultiChoiceItems(catNamesArray, checkedItemsArray,
                        (dialog, which, isChecked) -> checkedItemsArray[which] = isChecked)
                .setPositiveButton("Готово",
                        (dialog, id) -> {
                            StringBuilder state = new StringBuilder();
                            for (int i = 0; i < catNamesArray.length; i++) {
                                state.append(catNamesArray[i]);
                                if (checkedItemsArray[i])
                                    state.append(" выбран\n");
                                else
                                    state.append(" не выбран\n");
                            }
                            Toast.makeText(getActivity(),
                                            state.toString(), Toast.LENGTH_LONG)
                                    .show();
                        })

                .setNegativeButton("Отмена",
                        (dialog, id) -> dialog.cancel());

        return builder.create();
    }
}
