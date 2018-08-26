package com.example.hackeru.mycon;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private static final int REQUEST_CODE = 1;

    RecyclerView contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contacts = findViewById(R.id.myContacts);
        if (check(Manifest.permission.READ_CONTACTS)) { //request permissions
            displayContacts();
        } else {
            Toast.makeText(this, "No Permission Yet..", Toast.LENGTH_SHORT).show();
            System.out.println("no permission yet..");
        }
    }

    private boolean check(String permission) {
        if (ActivityCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
            //no permission - request the permission
            ActivityCompat.requestPermissions(this, new String[]{permission}, REQUEST_CODE);
            return false;
        }
        return true;
    }

    private void displayContacts() {
        //get contacts
        Cursor c = this.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        ArrayList<User> result = getContacts(c);

        //instantiate adapter - show contacts
        contacts.setLayoutManager(new LinearLayoutManager(this));
        contacts.setAdapter(new ContactAdapter(result));
    }

    public ArrayList<User> getContacts(Cursor cursor) {
        ArrayList<User> contacts = new ArrayList<>();

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phone = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            User u = new User(name, phone);
            contacts.add(u);
        }

        return contacts;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            displayContacts();
        }
    }
}
