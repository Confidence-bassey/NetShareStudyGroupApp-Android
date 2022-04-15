package com.zealmobile.netsharestudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;

public class User_Dashboard extends AppCompatActivity {

    public void showNavigationDrawer(View view){
        ImageView myIview = (ImageView)findViewById(R.id.hamburgIcon);
        myIview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(User_Dashboard.this, ActivitiesNavDrawer.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__dashboard);
        Log.i("INFO","calling toolbar");
        Toolbar toolbar =(Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        Log.i("INFO","toolbar called");

       /* ImageView myIview = (ImageView)findViewById(R.id.hamburgIcon);
        myIview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(User_Dashboard.this, ActivitiesNavDrawer.class);
                startActivity(intent);
            }
        });*/

    }
}