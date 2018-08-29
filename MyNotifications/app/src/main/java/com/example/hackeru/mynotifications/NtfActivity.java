package com.example.hackeru.mynotifications;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class NtfActivity extends Activity {

    private TextView ttl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ntf);

        ttl = findViewById(R.id.ttl);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //when Activity opens - check try to show
        String data = getIntent().getStringExtra(NtfService.MY_DATA);
        if (data != null) ttl.setText(data);
    }
}
