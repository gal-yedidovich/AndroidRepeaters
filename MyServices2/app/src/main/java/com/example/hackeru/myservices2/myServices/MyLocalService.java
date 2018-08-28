package com.example.hackeru.myservices2.myServices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyLocalService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "MyLocalService - started", Toast.LENGTH_SHORT).show();

        try{
            //sleep in current Thread for 10 seconds
            Thread.sleep(1000);
            //Since MyLocalService runs on UI main thread -> main thread will stuck
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"MyLocalService - dies", Toast.LENGTH_SHORT).show();
    }

    //not used in this example
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
