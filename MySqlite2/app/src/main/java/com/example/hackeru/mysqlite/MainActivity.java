package com.example.hackeru.mysqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get database connection object
        db = new ADBC(this).getReadableDatabase(); //connection with read privileges
        //db = new ADBC(this).getWritableDatabase(); //connection with write privileges
    }

    @Override
    protected void onStart() {
        super.onStart();

        example1();
        example2();
        TextView ttl = findViewById(R.id.ttl);
        //ttl.setText(queryName("2"));
        ttl.setText(queryName("-1 OR 1=1")); //SQL Injection
    }

    private void example1() {
        String sql = "SELECT name FROM users";
        Cursor results = db.rawQuery(sql, null);

        for (results.moveToFirst(); !results.isAfterLast(); results.moveToNext()) { //iterate results - row is changing
            String name = results.getString(0);
            System.out.println(name);
        }
        results.close(); //cleanups
    }

    private void example2() {
        String sql = "SELECT * FROM properties";
        Cursor prop = db.rawQuery(sql, null);

        System.out.println("******************************");
        for (prop.moveToFirst(); !prop.isAfterLast(); prop.moveToNext()) {
            int id = prop.getInt(0); //property ID
            String name = prop.getString(1); //property name
            int userId = prop.getInt(2); //property user_id

            System.out.println("propery: " + id + ", " + name + ", user id: " + userId);
        }
        prop.close();
    }

    private String queryName(String id) {
        String sql = "SELECT name FROM users WHERE id=" + id; //NOT TODO DANGEROUS - SQL INJECTION HACK
        Cursor results = db.rawQuery(sql, null);
        String name = null; //default value
        if (results.moveToFirst())  //if results is not empty
            name = results.getString(0); //return first result (can only be one - id is unique)

        results.close(); //cleanup
        return name;
    }
}