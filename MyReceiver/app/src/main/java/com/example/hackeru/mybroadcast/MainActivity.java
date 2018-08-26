package com.example.hackeru.mybroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyReceiver myReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //listen to broadcast of action 'myAction' (could be an action from android OS)
        myReceiver = new MyReceiver();
        registerReceiver(myReceiver, new IntentFilter("myAction")); //start listening
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myReceiver); //stop listening to broadcast
    }

    public void sendBroadcast(View view) {
        Intent i = new Intent("myAction");
        i.putExtra("msg", "hello world");
        sendBroadcast(i);
    }


}
