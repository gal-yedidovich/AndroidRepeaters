package com.example.hackeru.fragmentsex;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BackFrag extends Fragment {

    private View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_back, container, false);

        return view;
    }

    public void changeBack(boolean isGreen) {
        view.setBackgroundResource(isGreen ? R.color.green : R.color.red);
    }
}
