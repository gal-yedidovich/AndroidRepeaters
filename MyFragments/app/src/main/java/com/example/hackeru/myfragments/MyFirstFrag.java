package com.example.hackeru.myfragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyFirstFrag extends Fragment {

    private Runnable onMyClick = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_first, container, false);
        v.findViewById(R.id.CoolBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View btn) {
                if(onMyClick != null) onMyClick.run();
            }
        });
        return v;
    }

    public void setOnMyClick(Runnable onMyClick) {
        this.onMyClick = onMyClick;
    }
}
