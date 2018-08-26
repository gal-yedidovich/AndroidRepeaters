package com.example.hackeru.recyclerex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvc = findViewById(R.id.myContacts);
        rvc.setLayoutManager(new LinearLayoutManager(this));

        String[] contacts = {
                "Bubu, 055-555-5555",
                "Deadpool, 055-444-1234",
                "Eve, 055-022-9877",
                "Ninja, 055-855-9597",
        };
        rvc.setAdapter(new ContactAdapter(contacts));
    }
}
