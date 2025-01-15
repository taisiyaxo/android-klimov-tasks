package com.example.hellokitty;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class MyDialogFragmentWithTransfer extends AppCompatDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Вы жертвуете миллион коту")
                .setIcon(R.drawable.ic_cat)
                .setTitle("Важно! Максимальный перепост")
                .setPositiveButton("OK", (dialog, id) -> ((MainActivity) getActivity()).okClicked())
                .setNegativeButton("Отмена", (dialog, id) -> ((MainActivity) getActivity()).cancelClicked());

        return builder.create();
    }

}
