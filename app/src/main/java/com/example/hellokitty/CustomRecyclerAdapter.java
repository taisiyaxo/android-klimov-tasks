package com.example.hellokitty;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomRecyclerAdapter {

    private List<String> names;

    public CustomRecyclerAdapter(List<String> names) {
        this.names = names;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView largeTextView;
        private TextView smallTextView;

        public MyViewHolder(@NonNull View itemView) {


            super(itemView);

            largeTextView = itemView.findViewById(R.id.textViewLarge);
            smallTextView = itemView.findViewById(R.id.textViewSmall);

        }

        public TextView getLargeTextView() {
            return largeTextView;
        }

        public void setLargeTextView(TextView largeTextView) {
            this.largeTextView = largeTextView;
        }

        public TextView getSmallTextView() {
            return smallTextView;
        }

        public void setSmallTextView(TextView smallTextView) {
            this.smallTextView = smallTextView;
        }
    }
}
