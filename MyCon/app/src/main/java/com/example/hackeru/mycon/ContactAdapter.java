package com.example.hackeru.mycon;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    private ArrayList<User> users;

    public ContactAdapter(ArrayList<User> users) {
        this.users = users;
    }

    @NonNull@Override public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.contact_item, viewGroup,false);

        return new ContactViewHolder(v);
    }

    @Override public void onBindViewHolder(@NonNull ContactViewHolder viewHolder, int i) {
        User current = users.get(i);
        viewHolder.nameTxt.setText(current.name);
        viewHolder.phoneTxt.setText(current.phone);
    }

    @Override public int getItemCount() { return users.size(); }
}

class ContactViewHolder extends RecyclerView.ViewHolder {
    public final TextView nameTxt, phoneTxt;

    public ContactViewHolder(View itemView) {
        super(itemView);
        nameTxt = itemView.findViewById(R.id.nameTxt);
        phoneTxt = itemView.findViewById(R.id.phoneTxt);
    }
}
