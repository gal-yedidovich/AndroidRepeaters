package com.example.hackeru.myservices2;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import com.example.hackeru.myservices2.myServices.MyBGTService;
import com.example.hackeru.myservices2.myServices.MyBinder;
import com.example.hackeru.myservices2.myServices.MyBoundService;
import com.example.hackeru.myservices2.myServices.MyLocalService;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Example 1
    public void startL(View view) {
        //Explicitly start MyLocalService
        startService(new Intent(this, MyLocalService.class));
    }

    public void stopL(View view) {
        //Explicitly stop MyLocalService
        stopService(new Intent(this, MyLocalService.class));
    }

    //Example 2
    public void startBG(View view) {
        //Explicitly Start Background Service
        startService(new Intent(this, MyBGTService.class));
    }

    //Example 3
    public void bind(View view) {
        bindService(new Intent(this, MyBoundService.class), sc, BIND_AUTO_CREATE);
    }

    public void unbind(View view) {
        unbindService(sc);
    }

    private ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyBoundService service = ((MyBinder) iBinder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}
