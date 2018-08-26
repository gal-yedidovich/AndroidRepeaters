package com.example.hackeru.fragmentsex;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BackFrag backFrag = new BackFrag();
        final TextFrag textFrag = new TextFrag();

        replaceFragment(R.id.topContainer, backFrag);
        replaceFragment(R.id.bottomContainer, textFrag);

        //set on click listeners
        findViewById(R.id.checkBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backFrag.changeBack(true);
                textFrag.changeText(true);
            }
        });

        findViewById(R.id.BtnX).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backFrag.changeBack(false);
                textFrag.changeText(false);
            }
        });
    }

    private void replaceFragment(int id, Fragment newFrag){
        getSupportFragmentManager() //get fragment manager
                .beginTransaction() //start new transaction
                .replace(id, newFrag) //change fragment
                .commit(); //done

    }
}
