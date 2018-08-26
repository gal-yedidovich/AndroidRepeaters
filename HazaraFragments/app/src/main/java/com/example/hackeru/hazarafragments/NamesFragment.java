package com.example.hackeru.hazarafragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hackeru.hazarafragments.adapters.NamesAdapter;

public class NamesFragment extends Fragment {

    private OnNameSelected onNameSelected;

    public void setOnNameSelected(OnNameSelected onNameSelected) {
        this.onNameSelected = onNameSelected;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_names, container, false);

        final NamesAdapter adapter = new NamesAdapter(getContext());
        ListView nameList = view.findViewById(R.id.namesList);
        nameList.setAdapter(adapter);

        nameList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (onNameSelected != null)
                    onNameSelected.onNameSelected(adapter.getItem(position));
            }
        });

        return view;
    }

    public interface OnNameSelected {
        void onNameSelected(String name);
    }
}
