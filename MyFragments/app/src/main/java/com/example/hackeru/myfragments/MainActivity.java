package com.example.hackeru.myfragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyFirstFrag first = new MyFirstFrag();
        first.setOnMyClick(new Runnable() {
            @Override
            public void run() {
                replaceFragment(new SecondFragment());
                //Toast.makeText(MainActivity.this, "written in activity main", Toast.LENGTH_SHORT).show();
            }
        });

        replaceFragment(first);
    }

    private void replaceFragment(Fragment newFrag){
        getSupportFragmentManager() //get fragment manager
                .beginTransaction() //start new transaction
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right) //slide animation
                .replace(R.id.myContainer, newFrag) //change fragment
                .commit(); //done

    }
}
