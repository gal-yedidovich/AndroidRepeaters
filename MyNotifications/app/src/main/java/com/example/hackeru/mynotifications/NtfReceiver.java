package com.example.hackeru.mynotifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;

public class NtfReceiver extends BroadcastReceiver {
    private Context context;
    private NotificationManager ntfMngr;
    private static final int NTF_TWO = 2;

    @Override
    public void onReceive(Context context, Intent intent) {
        String data = intent.getStringExtra(NtfService.MY_DATA); //data from broadcast
        if (data != null) {
            this.context = context;
            this.ntfMngr = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            this.sendNotif(data);
        }
    }

    private void sendNotif(String data) {
        Notification.Builder ntfBuilder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { //API 26+
            ntfBuilder = new Notification.Builder(context, MainActivity.NTF_CHANNEL); //reusing main activity channel
        } else {
            ntfBuilder = new Notification.Builder(context);
        }

        Notification ntf = ntfBuilder.setContentTitle("New Data")
                .setContentText(data)
                .setSmallIcon(R.mipmap.dollar)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.dollar2))
                .setAutoCancel(true)
                .setContentIntent(contentIntent(data))
                .build();
        
        ntfMngr.notify(NTF_TWO, ntf);
    }

    private PendingIntent contentIntent(String data) {
        Intent i = new Intent(context, NtfActivity.class); //explicit intent
        i.putExtra(NtfService.MY_DATA, data);

        return PendingIntent.getActivity(context, NTF_TWO, i, PendingIntent.FLAG_UPDATE_CURRENT);
    }


}
