package com.example.hackeru.myyoutube;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.queryTxt);

        /*

        https://www.googleapis.com/youtube/v3/search
        ?part=snippet
        &q=YouTube+Data+API
        &key={YOUR_API_KEY}

        */
    }

    public void searchYoutube(View view) {
        String query = txt.getText().toString();
        if (!query.isEmpty()) {
            getDataFromAPI(query);
        }
    }

    @SuppressLint("StaticFieldLeak")
    public void getDataFromAPI(final String q) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    String url = "https://www.googleapis.com/youtube/v3/search?part=snippet&q=" + q + "&key=" + getString(R.string.apiKey);

                    JSONObject data = new HttpRequest(url).prepare().sendAndReadJSON();

                    System.out.println("*************************************************");
                    System.out.println(data);
                    System.out.println("*************************************************");
                } catch (JSONException | IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }
}
