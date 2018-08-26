
package com.example.hackeru.myrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private HashMap<String, Integer> data;
    private String[] keys;

    public MyAdapter(HashMap<String, Integer> data) {
        this.data = data;
        this.keys = data.keySet().toArray(new String[0]);
    }

    //creating view holder
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext()); //get inflater
        View item = inflater.inflate(R.layout.car_item, viewGroup, false); //inflate car_item.xml

        return new MyViewHolder(item);
    }

    //displaying item with viewHolder
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
        String key = keys[position];
        viewHolder.txt.setText(key);
        viewHolder.img.setImageResource(data.get(key));
    }

    @Override
    public int getItemCount() {
        return keys.length;
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    public final TextView txt;
    public final ImageView img;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        txt = itemView.findViewById(R.id.carTxt);
        img = itemView.findViewById(R.id.carImg);
    }
}
