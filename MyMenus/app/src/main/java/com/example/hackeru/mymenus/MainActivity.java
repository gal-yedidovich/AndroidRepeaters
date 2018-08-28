package com.example.hackeru.mymenus;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private LinearLayout section;
    private TextView ttl;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ttl = findViewById(R.id.ttl);
        section = findViewById(R.id.section);

        prefs = getSharedPreferences("stuff", MODE_PRIVATE);

        //Assign ContextMenu to given views -> open onLongClick
        registerForContextMenu(ttl);
        registerForContextMenu(section);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //get saved color
        int color = prefs.getInt("myColor", Color.WHITE); //get color or default WHITE
        section.setBackgroundColor(color); //set chosen color to background of section
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.colors, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int color = Color.WHITE; //default color is White
        switch (item.getItemId()) {
            case R.id.red:
                color = getResources().getColor(R.color.red);
                break;
            case R.id.green:
                color = getResources().getColor(R.color.green);
                break;
            case R.id.blue:
                color = getResources().getColor(R.color.blue);
                break;
        }
        //Save chosen color in preferences (asynchronously)
        prefs.edit().putInt("myColor", color).apply();

        //set chosen color to background of section
        section.setBackgroundColor(color);

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //v -> is the registered view
        if (v.getId() == R.id.section) {
            getMenuInflater().inflate(R.menu.section_menu, menu);
        } else {
            getMenuInflater().inflate(R.menu.bubu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.bubu1){
            Toast.makeText(this, "Bubu one has won", Toast.LENGTH_SHORT).show();
        } else {
            new AlertDialog.Builder(this).setTitle("Bubu two will win too").show();
        }
        return super.onContextItemSelected(item);
    }
}
