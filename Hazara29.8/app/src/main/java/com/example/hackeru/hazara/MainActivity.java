package com.example.hackeru.hazara;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    LinearLayout root;
    RecyclerView colorsRcv;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        root = findViewById(R.id.root);
        colorsRcv = findViewById(R.id.myColorsRcv);
        prefs = getSharedPreferences("colors", MODE_PRIVATE);

        ColorsAdapter adapter = new ColorsAdapter();
        adapter.setCallback(new ColorsAdapter.OnColorSelected() {
            @Override
            public void onSelect(int color) {
                prefs.edit().putInt("btnColor", color).apply();
                root.setBackgroundColor(color);
            }
        });
        colorsRcv.setAdapter(adapter);
        colorsRcv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        root.setBackgroundColor(prefs.getInt("btnColor", Color.WHITE));
    }

    public void changeColor(View btn) {
        int color;
        switch (btn.getId()) {
            case R.id.redBtn:
                color = Color.RED;
                break;
            case R.id.greenBtn:
                color = Color.GREEN;
                break;
            case R.id.blueBtn:
                color = Color.BLUE;
                break;
            default:
                color = Color.WHITE;
        }

        root.setBackgroundColor(color);
        prefs.edit().putInt("btnColor", color).apply();
    }
}
