package com.example.hackeru.mydialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Example 1 - using only built in AlertDialog.Builder
    public void dialog1(View view) {
        //Create & build Dialog using AlertDialog.Builder
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        //chaining calls (build with): title, message & 2 buttons "OK" & "Cancel"
        dialog.setTitle("Attention")
                .setMessage("If you are using iOS 8 and below, we pity your RAM")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) { //when OK is clicked
                        Toast.makeText(MainActivity.this, "OK clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", null)
                .show(); //present the dialog
    }

    //Example 2
    public void dialog2(View view) {
        //Create AlertDialog instance
        AlertDialog dialog = new AlertDialog.Builder(this).create();
        //inflate predefined View from dialog.xml
        View dialogView = getLayoutInflater().inflate(R.layout.dialog, null, false);
        dialog.setView(dialogView); //set as dialog's view

        //set button Listeners
        dialogView.findViewById(R.id.loginBtn).setOnClickListener(new Dialog2Listener(dialog));
        dialogView.findViewById(R.id.registerBtn).setOnClickListener(new Dialog2Listener(dialog));
        //

        dialog.show();
    }

    //Encapsulated Composition (Has a) Listener
    private class Dialog2Listener implements View.OnClickListener{
        private AlertDialog dialog;

        public Dialog2Listener(AlertDialog dialog) {
            this.dialog = dialog;
        }

        @Override
        public void onClick(View view) { //when login/register button is clicked
            String msg = view.getId() == R.id.loginBtn ? "Login" : "Register";

            Toast.makeText(MainActivity.this, msg + " Clicked", Toast.LENGTH_SHORT).show();
            dialog.dismiss(); //dismiss alert dialog
        }
    }
}
