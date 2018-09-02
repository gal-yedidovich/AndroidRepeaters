package com.example.hackeru.asynctaskex;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    RecyclerView itemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemsList = findViewById(R.id.itemsList);
        itemsList.setLayoutManager(new LinearLayoutManager(this));

        getItems();
    }

    @SuppressLint("StaticFieldLeak") //just for me
    private void getItems() {
        new AsyncTask<Void, Void, String[]>() {

            @Override
            protected String[] doInBackground(Void... voids) {
                try {
                    JSONObject json = new HttpRequest("http://10.0.29.49:8181/items.json").prepare().sendAndReadJSON();
                    JSONArray hits = json.getJSONArray("hits");
                    String[] items = new String[hits.length()];
                    for (int i = 0; i < hits.length(); i++) {
                        items[i] = hits.getJSONObject(i).getJSONObject("_source").getJSONObject("info").getString("fullName");
                    }

                    return items;

                } catch (JSONException | IOException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(String[] items) {
                if (items != null) {
                    itemsList.setAdapter(new ItemsAdapter(items));
                }
            }
        }.execute();
    }
}
