package com.example.hackeru.mynotifications;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    NotificationManager ntfMngr; //Notification manager - system service - used for managing notifications
    public static final int NTF_ONE = 1; //Our custom notification ID
    public static final String NTF_CHANNEL = "Repeaters Channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ntfMngr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //in API 26 and above - create channel for Notification
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String name = "repeaters channel";// The user-visible name of the channel.
            NotificationChannel mChannel =
                    new NotificationChannel(NTF_CHANNEL, name, NotificationManager.IMPORTANCE_HIGH);
            ntfMngr.createNotificationChannel(mChannel);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        startService(new Intent(this, NtfService.class));
        registerReceiver(new NtfReceiver(), new IntentFilter("MyBGAction")); //register to broadcast receiver
    }

    public void myNotify(View view) {
        //handle different API levels, since level 26 uses channels
        Notification.Builder ntfBuilder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { //API 26+
            ntfBuilder = new Notification.Builder(this, NTF_CHANNEL);
        } else { //below API 26
            ntfBuilder = new Notification.Builder(this);
        }

        Notification ntf = ntfBuilder
                .setContentTitle("My Notification")
                .setSmallIcon(R.mipmap.dollar)
                .setContentText("Repeaters are awesome")
                .build();
        ntfMngr.notify(NTF_ONE, ntf);
    }
}
