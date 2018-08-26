package com.example.hackeru.hazarafragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.hackeru.hazarafragments.adapters.NamesAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NamesFragment namesFragment = new NamesFragment();


        namesFragment.setOnNameSelected(new NamesFragment.OnNameSelected() {
            @Override
            public void onNameSelected(String name) {
                DisplayFragment displayFragment = new DisplayFragment();
                displayFragment.setSelectedName(name);

                getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container, displayFragment)
                        .commit();
            }
        });

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, namesFragment)
                .commit();
    }
}
