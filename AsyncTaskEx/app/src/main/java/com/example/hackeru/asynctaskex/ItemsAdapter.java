package com.example.hackeru.asynctaskex;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ItemsAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private String[] itemNames;

    public ItemsAdapter(String[] itemNames) {
        this.itemNames = itemNames;
    }

    @NonNull @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.itemTxt.setText(itemNames[i]);
    }

    @Override
    public int getItemCount() {
        return itemNames.length;
    }
}

class ItemViewHolder extends RecyclerView.ViewHolder {
    TextView itemTxt;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        itemTxt = itemView.findViewById(R.id.itemTxt);
    }
}