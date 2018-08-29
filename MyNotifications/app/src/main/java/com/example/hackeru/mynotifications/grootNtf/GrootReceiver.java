package com.example.hackeru.mynotifications.grootNtf;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;

import com.example.hackeru.mynotifications.MainActivity;
import com.example.hackeru.mynotifications.R;

public class GrootReceiver extends BroadcastReceiver {
    private static final int NTF_THREE = 3;

    @Override
    public void onReceive(Context context, Intent intent) {
        String data = intent.getStringExtra(GrootService.DATA);
        if (data != null) {
            sendNotif(context, data);
        }
    }

    private void sendNotif(Context context, String data) {
        Notification.Builder builder = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O //check API 26+
                ? new Notification.Builder(context, MainActivity.NTF_CHANNEL) //notification with channel
                : new Notification.Builder(context); //notification

        Notification ntf = builder.setContentTitle("Groot Notification")
                .setContentText(data)
                .setSmallIcon(R.mipmap.dollar)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.dollar2))
                .setAutoCancel(true)
                .setContentIntent(pendingIntent(context, data))
                .build();

        NotificationManager ntfMngr = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        ntfMngr.notify(NTF_THREE, ntf);
    }

    private PendingIntent pendingIntent(Context context, String data) {
        Intent i = new Intent(context, GrootActivity.class);
        i.putExtra(GrootService.DATA, data);
        return PendingIntent.getActivity(context, NTF_THREE, i, PendingIntent.FLAG_UPDATE_CURRENT);
    }
}
