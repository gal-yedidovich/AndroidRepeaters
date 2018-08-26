package com.example.hackeru.fragmentsex;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextFrag extends Fragment {

    private TextView txt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_text, container, false);
        txt = v.findViewById(R.id.txt);
        return v;
    }

    public void changeText(boolean isGreen) {
        txt.setTextColor(getActivity().getResources().getColor(isGreen ? R.color.green : R.color.red));
    }
}
