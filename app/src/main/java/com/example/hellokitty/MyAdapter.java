package com.example.hellokitty;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter  extends RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder> {

    private List<String> names;

    public MyAdapter(List<String> names) {
        this.names = names;
    }

    @NonNull
    @Override
    public CustomRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.recycleview_item, parent, false);
        return new CustomRecyclerAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRecyclerAdapter.MyViewHolder holder, int position) {
        holder.getLargeTextView().setText(names.get(position));
        holder.getSmallTextView().setText("cat");
    }

    @Override
    public int getItemCount() {
        return names.size();
    }
}
