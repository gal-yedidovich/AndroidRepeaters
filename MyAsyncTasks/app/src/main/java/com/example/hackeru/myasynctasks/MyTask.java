package com.example.hackeru.myasynctasks;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class MyTask extends AsyncTask<Void, Void, Void> {

    private Context context; //only in this example

    public MyTask(Context context) {
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... voids) { // runs in background
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) { //run in UI after doInBackground method
        super.onPostExecute(aVoid);
        Toast.makeText(context, "async task done", Toast.LENGTH_SHORT).show();
        context = null; //to avoid memory leak, only for this example
    }
}
