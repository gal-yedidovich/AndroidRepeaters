package com.example.hackeru.hazara;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ColorsAdapter extends RecyclerView.Adapter<ColorViewHolder> {

    private MyColor[] colors = {
            new MyColor("red", Color.RED),
            new MyColor("yellow", Color.YELLOW),
            new MyColor("magenta", Color.MAGENTA),
            new MyColor("cyan", Color.CYAN),
            new MyColor("gray", Color.GRAY),
            new MyColor("white", Color.WHITE),
            new MyColor("blue", Color.BLUE),
            new MyColor("green", Color.GREEN),
    };

    private OnColorSelected callback;

    public void setCallback(OnColorSelected callback){
        this.callback = callback;
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.color_item, viewGroup, false);
        return new ColorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {
        final MyColor current = colors[position]; //get item
        holder.btn.setText(current.name);
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //change background in activity
                if(callback !=null) callback.onSelect(current.color);
            }
        });
    }

    @Override
    public int getItemCount() {
        return colors.length;
    }

    public interface OnColorSelected{
        void onSelect(int color);
    }
}

class ColorViewHolder extends RecyclerView.ViewHolder {
    public final Button btn;

    public ColorViewHolder(@NonNull View itemView) {
        super(itemView);
        btn = (Button) itemView;
    }
}

class MyColor {
    public final String name;
    public final int color;

    public MyColor(String name, int color) {
        this.name = name;
        this.color = color;
    }
}
