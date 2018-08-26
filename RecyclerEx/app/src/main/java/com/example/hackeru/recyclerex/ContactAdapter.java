package com.example.hackeru.recyclerex;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    private String[] contacts;

    public ContactAdapter(String[] contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.contact_item, viewGroup, false);

        //instantiate new view holder
        return new ContactViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder viewHolder, int i) {
        viewHolder.txt.setText(contacts[i]); //set text on displayed view
    }

    @Override
    public int getItemCount() {
        return contacts.length;
    }
}

class ContactViewHolder extends RecyclerView.ViewHolder {
    public final TextView txt;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        txt = (TextView) itemView; //cast to textView
    }
}