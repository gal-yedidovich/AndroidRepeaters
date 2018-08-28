package com.example.hackeru.myservices2.targil;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;

public class BubuActivity extends Activity {

    private BubuService service;

    @Override
    protected void onStart() {
        super.onStart();

        bindService(new Intent(this, BubuService.class), sc, BIND_AUTO_CREATE);
    }

    private void sendMsgToService(){
        service.printMsg("Sent From Activity");
    }

    private ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            service = ((BubuBinder) iBinder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };
}
