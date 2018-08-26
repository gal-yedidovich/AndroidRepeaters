package com.example.hackeru.listex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NumAdapter extends BaseAdapter {
    private Context context;

    public NumAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View previousView, ViewGroup viewGroup) {
//        TextView txt = new TextView(context);
//        txt.setText("" + position);
//        return txt;

        View item = previousView;
        if(item == null){
            item = LayoutInflater.from(context).inflate(R.layout.num_item, viewGroup, false); //create View from XML
        }

        ((TextView) item.findViewById(R.id.itemTxt)).setText(position + ""); //change text on text View
        return item; //return View item
    }
}
