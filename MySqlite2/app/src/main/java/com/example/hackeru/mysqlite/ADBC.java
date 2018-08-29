package com.example.hackeru.mysqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ADBC extends SQLiteOpenHelper {

    private static final String DB_NAME = "repeaters";

    //dependency injection for context
    public ADBC(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override //Called when database created for the first time
    public void onCreate(SQLiteDatabase db) {
        //Initial Structure
        String[] sqls = {
                "CREATE TABLE IF NOT EXISTS properties (id INTEGER PRIMARY KEY, name VARCHAR(10), user_id INTEGER NOT NULL)",
                "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name VARCHAR(10))",
                "INSERT INTO users (name) VALUES ('Mahmud'), ('Ofir'), ('Barak')",
                "INSERT INTO properties (name, user_id) VALUES ('Bait', 1), ('Mehonit', 2), ('Gitara', 2), ('Ohel', 3)"
        };

        for (String sql : sqls) db.execSQL(sql);
    }

    @Override //Called each time when version updated
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
