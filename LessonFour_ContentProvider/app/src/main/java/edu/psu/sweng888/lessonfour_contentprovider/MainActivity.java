package edu.psu.sweng888.lessonfour_contentprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ContactAdapter mAdapter;

    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;

    private ArrayList<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.contacts_list);

        // Check for permission to access contacts
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted, request it
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_CONTACTS},
                    PERMISSIONS_REQUEST_READ_CONTACTS);
            contacts = getContacts();
        } else {
            // Permission is already granted, proceed with app logic
            contacts = getContacts();
        }

        mAdapter = new ContactAdapter(this, getContacts());
        mListView.setAdapter(mAdapter);

    }

    @SuppressLint("Range")
    private ArrayList<Contact> getContacts() {
        ArrayList<Contact> contacts = new ArrayList<>();
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndex(
                        ContactsContract.Contacts._ID));
                String name = cursor.getString(cursor.getColumnIndex(
                        ContactsContract.Contacts.DISPLAY_NAME));
                String phoneNumber = "";

                Cursor phoneCursor = contentResolver.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                        new String[]{id}, null);

                if (phoneCursor.moveToFirst()) {
                    phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.NUMBER));
                }
                phoneCursor.close();
                contacts.add(new Contact(name, phoneNumber));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return contacts;
    }
}


//public class MainActivity extends AppCompatActivity {
//
//    private ListView mListViewContacts;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        mListViewContacts = findViewById(R.id.contacts_list);
//
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
//            //ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_CODE_READ_CONTACTS);
//
//        String [] projection = {
//                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
//                ContactsContract.CommonDataKinds.Phone.NUMBER
//        };
//
//        Cursor cursor = getContentResolver().query(
//                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
//                projection,
//                null,
//                null,
//                null
//        );
//
//        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(
//                this,
//                android.R.layout.simple_expandable_list_item_2,
//                cursor,
//                new String[] {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER},
//                new int [] {android.R.id.text1, android.R.id.text2}
//        );
//
//        mListViewContacts.setAdapter(simpleCursorAdapter);
//    }
//    }
//}