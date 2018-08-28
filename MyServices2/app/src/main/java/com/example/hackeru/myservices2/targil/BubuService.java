package com.example.hackeru.myservices2.targil;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class BubuService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return new BubuBinder(this);
    }

    public void printMsg(String msg){
        System.out.println(msg);
    }
}
