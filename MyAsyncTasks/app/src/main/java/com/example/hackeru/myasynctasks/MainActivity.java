package com.example.hackeru.myasynctasks;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.myImage);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //wrongThread(); //cant touch UI in other thread
        example1(); //example 1 - with handlers

        //example 2 - with async task
        new MyTask(this).execute();


        //Example 3 - async task with result
        String url = "https://m.media-amazon.com/images/M/MV5BYzE5MjY1ZDgtMTkyNC00MTMyLThhMjAtZGI5OTE1NzFlZGJjXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_UX182_CR0,0,182,268_AL_.jpg";
        new AsyncTask<String, Void, Bitmap>() {

            @Override
            protected void onPreExecute() { //on UI before doInBackground
                img.setBackgroundColor(Color.GREEN);
            }

            @Override
            protected Bitmap doInBackground(String... strings) { //in background
                try (InputStream is = new URL(strings[0]).openConnection().getInputStream()) {
                    return BitmapFactory.decodeStream(is);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) { //on UI after doInBackground
                img.setImageBitmap(bitmap);
            }
        }.execute(url);
    }

    private void wrongThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //kills App, CallFromWrongThreadException
                TextView ttl = findViewById(R.id.ttl);
                ttl.setText("Test me");
            }
        }).start();
    }

    private void example1() {
        final Handler myHandler = new Handler(Looper.getMainLooper()); //attach handler to main thread

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000); //long operations

                    myHandler.post(new Runnable() { //run code in attach thread (ui main thread)
                        @Override
                        public void run() {
                            TextView ttl = findViewById(R.id.ttl);
                            ttl.setText("Done");
                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start(); //
    }


}
