package com.example.hackeru.myservices2.myServices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyBGTService extends Service implements Runnable{

    private static Thread t;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(t == null){
            t = new Thread(this); //target Runnable -> who implements .run();
            t.start();//activate current .run() in background thread
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.println("*****************MYBGTService - alive " + i + "*****************");
            }
            //Since -> BGTService runs in background thread -> main thread will not stuck
            t = null;
            stopSelf(); // and then -> stop itself
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //not used in this example
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
