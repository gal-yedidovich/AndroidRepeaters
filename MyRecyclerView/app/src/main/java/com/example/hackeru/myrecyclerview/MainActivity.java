package com.example.hackeru.myrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rcv = findViewById(R.id.myRecyclerView);
        rcv.setLayoutManager(new LinearLayoutManager(this)); //what layout to use

        HashMap<String, Integer> cars = new HashMap<>();
        cars.put("Bugatti", R.mipmap.bugatti);
        cars.put("Maserati", R.mipmap.maserati);
        cars.put("Ferrari", R.mipmap.ferrari);
        cars.put("Porche", R.mipmap.porche);
        cars.put("Lamborghini", R.mipmap.lamborghini);
        cars.put("Bently", R.mipmap.bently);

        rcv.setAdapter(new MyAdapter(cars));

    }
}
