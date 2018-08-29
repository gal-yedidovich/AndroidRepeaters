package com.example.hackeru.mynotifications.grootNtf;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.JsonReader;

import com.example.hackeru.mynotifications.HttpRequest;

import org.json.JSONObject;

public class GrootService extends Service implements Runnable{

    public static final String DATA = "GrootData",
                                ACTION = "grootAction";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(this).start(); //run service in background

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void run() {
        try {
            Intent i = new Intent(ACTION); //explicit intent

            //exercise
            /*Thread.sleep(5000);
            i.putExtra(DATA, "I am Groot"); //pass data
            /*/

            //bonus
            JSONObject json = new HttpRequest("https://api.coinmarketcap.com/v2/listings/").prepare().sendAndReadJSON();
            String name = json.getJSONArray("data").getJSONObject(0).getString("name");
            i.putExtra(DATA, name); //pass data

            sendBroadcast(i); //sending broadcast
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
