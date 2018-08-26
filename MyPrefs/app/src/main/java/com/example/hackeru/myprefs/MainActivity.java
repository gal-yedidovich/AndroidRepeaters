package com.example.hackeru.myprefs;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    SharedPreferences prefs;
    TextView input, feed;
    Button saveBtn, loadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = this.getSharedPreferences("dugma", MODE_PRIVATE);
        input = findViewById(R.id.input);
        feed = findViewById(R.id.feed);

        //save button clicked
        saveBtn = findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //save
                String msg = input.getText().toString(); //get message from user
                //get Editor object - builder pattern based object -
                Editor edit = prefs.edit();
                edit.putString("msg", msg); //put String data for key "msg"
                edit.commit(); //commit all changes
            }
        });

        //load button clicked
        loadBtn = findViewById(R.id.loadBtn);
        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get s
                String msg = prefs.getString("msg", "No Message Yet");
                feed.setText(msg);
            }
        });
    }
}
