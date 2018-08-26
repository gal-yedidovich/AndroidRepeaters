package com.example.hackeru.imagelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

class PicAdapter extends BaseAdapter {
    private Context context;

    public PicAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() { //count of items in the list
        return 20;
    }

    @Override
    public Object getItem(int i) { //an item fetched by the list
        return null;
    }

    @Override
    public long getItemId(int i) { //an unique id number for each item
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) { //a View object that is rendered on screen
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.pic_item, viewGroup, false);
        }

        ImageView img = view.findViewById(R.id.itemPic);
        img.setImageResource(i % 2 == 0 ? R.mipmap.bar : R.mipmap.gal);

        Button btn = view.findViewById(R.id.nameBtn);
        btn.setText(i % 2 == 0 ? "Bar" : "Gal");

        return view;
    }
}
