package com.example.hackeru.mynotifications;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class NtfService extends Service implements Runnable {

    private static final int times = 10;
    public static final String MY_DATA = "myData";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(this).start();//activate this service in background thread

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void run() {
        //some long operation
        for (int i = 0; i < times; i++) {
            try {
                Thread.sleep(1000); //one second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i("Ntf Service", "Step " + i);
        }
        Log.i("Ntf Service", "Sending Broadcast");
        sendBroadcast(dataIntent()); //when ready - send broadcast with data
        stopSelf(); //and stop
    }

    private Intent dataIntent(){
        String action = "MyBGAction";
        Intent i = new Intent(action);
        i.putExtra(MY_DATA, "Android Repeaters know implicit intents");

        return i;
    }

    //not used in this example
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
