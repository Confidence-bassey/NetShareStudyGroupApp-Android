package com.zealmobile.netsharestudyapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.util.ArrayList;

public class CreateNewGroup extends AppCompatActivity {

    private static final int PICK_CONTACT = 1;
    Button addMembers, createGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_group);

        addMembers = findViewById(R.id.add_members);
        createGroup = findViewById(R.id.createG_btn);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_PHONE_STATE}, 1);
        }
    }

    public void addGroupMembers(View view){
        final AlertDialog.Builder builder = new AlertDialog.Builder(CreateNewGroup.this);
        builder.setMessage("Do you want to add members from phone contacts?");
        builder.setCancelable(true);
        builder.setNegativeButton("FROM PHONE CONTACTS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                addContact();
            }
        });
        builder.setPositiveButton("INVITE ON SOCIAL MEDIA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                sendInvitation();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    public void addContact(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setType("application/phone");
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        new File(Environment.getExternalStorageDirectory().getAbsolutePath());
        startActivity(intent);
    }

    public void sendInvitation(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        intent.setType("text/plain");
        String text = "Hello friend, kindly click on this link to join my group on GOMYCODE NetShare collaboration App";
        intent.putExtra(Intent.EXTRA_TEXT, text);
        startActivity(intent);
    }

    public void checkPermission(View view){
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);

        if(permissionCheck==PackageManager.PERMISSION_GRANTED){
            readContacts();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 0);
        }
    }

    private void readContacts() {
        ContentResolver contentResolver=getContentResolver();
        Cursor cursor=contentResolver.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
        if (cursor.moveToFirst()){
            do {
                Intent intent= new Intent(Intent.ACTION_PICK,  ContactsContract.Contacts.CONTENT_URI);

                startActivityForResult(intent, PICK_CONTACT);
                
            }while (cursor.moveToNext());

        }
    }
}