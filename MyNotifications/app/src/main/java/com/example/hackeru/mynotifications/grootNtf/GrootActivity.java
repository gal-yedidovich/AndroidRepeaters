package com.example.hackeru.mynotifications.grootNtf;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hackeru.mynotifications.R;

import org.jetbrains.annotations.Nullable;

public class GrootActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groot);
    }

    @Override
    protected void onStart() {
        super.onStart();
        String data = getIntent().getStringExtra(GrootService.DATA);
        if(data != null){
            ((TextView)findViewById(R.id.grootTtl)).setText(data);
        }
    }
}
