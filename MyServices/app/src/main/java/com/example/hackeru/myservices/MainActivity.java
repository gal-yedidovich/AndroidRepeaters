package com.example.hackeru.myservices;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView feed;
    private SensorManager sMngr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        feed = findViewById(R.id.feed);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //Example 1 - Wifi service
        WifiManager wifi = (WifiManager) this.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (wifi != null && wifi.isWifiEnabled()) { //if wifi enabled -> needs android.permission.ACCESS_WIFI_STATE
            wifi.setWifiEnabled(false); //disable -> needs android.permission.CHANGE_WIFI_STATE
        }

        //Example 2 - play sound
        MediaPlayer mp = MediaPlayer.create(this, R.raw.hello);
        mp.start();

        //Example 3 - Vibrator
        Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        //vibrations -> needs android.permission.VIBRATE
        if (v != null && v.hasVibrator()) v.vibrate(3000);//if has vibrator activate for 3 seconds

        //v.vibrate(VibrationEffect.createOneShot(3000, VibrationEffect.DEFAULT_AMPLITUDE)); //API 26+

        //Example 4 - Sensor - ACCELEROMETER
        sMngr = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor s = sMngr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sMngr.registerListener(myMoveListener, s, SensorManager.SENSOR_DELAY_NORMAL);
    }

    private SensorEventListener myMoveListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent e) {
            float x = e.values[0], y = e.values[1], z = e.values[2];
            feed.setText("Moved to X:" + x + ", Y:" + y + ", Z:" + z);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };
}
