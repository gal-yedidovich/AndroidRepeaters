package com.example.hackeru.myasynctask2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView myTxt;
    ProgressBar myProgress;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTxt = findViewById(R.id.feed);
        myProgress = findViewById(R.id.myProgress);
        img = findViewById(R.id.myImg);

        myTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                example1();
                example2();
            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadImg();
            }
        });
    }

    //with handlers
    private void example1() {
        final Handler myHandler = new Handler(Looper.getMainLooper()); //instantiate handler for main looper(thread)
        myTxt.setText("Loading");
        myProgress.setVisibility(View.VISIBLE);
        new Thread() { //run in background
            @Override
            public void run() {
                try {
                    sleep(1500);

                    //run in UI
                    myHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            //in UI main thread
                            myTxt.setText("Operation Done - I am Groot");
                            myProgress.setVisibility(View.INVISIBLE);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    //with AsyncTask
    private void example2() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPreExecute() { //before background operation (doInBackground method)
                myTxt.setText("Loading");
                myProgress.setVisibility(View.VISIBLE);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) { //run in UI
                //in UI main thread
                myTxt.setText("Operation Done - I am Groot");
                myProgress.setVisibility(View.INVISIBLE);
            }
        }.execute();
    }

    //exercise load image with progress bar
    private void loadImg() {
        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected void onPreExecute() {
                myProgress.setVisibility(View.VISIBLE);
                img.setImageBitmap(null);
            }

            @Override
            protected Bitmap doInBackground(Void... voids) {
                String url = "http://energy106.ca/wp-content/uploads/2018/02/maxresdefault.jpg";
                try (InputStream is = new URL(url).openConnection().getInputStream()) {
                    return BitmapFactory.decodeStream(is);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if (bitmap != null) {
                    img.setImageBitmap(bitmap);
                }
                myProgress.setVisibility(View.INVISIBLE);
            }
        }.execute();
    }
}
