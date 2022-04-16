package com.zealmobile.netsharestudyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class ActivitiesNavDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities_nav_drawer);

        Toolbar toolbar =(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_hamburg);


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.open_drawer, R.string.Close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

     /*   if (savedInstanceState == null) {
            Intent intent = new Intent(ActivitiesNavDrawer.this, ReadingSession.class);
            startActivity(intent);
            navigationView.setCheckedItem(R.id.createSession);
        }*/

        Button testbtn = (Button)findViewById(R.id.testing);
        testbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivitiesNavDrawer.this, LogOut.class);
                startActivity(intent);
            }
        });

        Button notesbtn = (Button)findViewById(R.id.GoToNotes);
        notesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ActivitiesNavDrawer.this, Note.class);
                startActivity(intent1);
            }
        });
    }


    @Override
    public void onBackPressed () {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.createSession:
                Log.i("INFO","ReadingSession called");
                Intent intent = new Intent(ActivitiesNavDrawer.this, ReadingSession.class);
                startActivity(intent);
                break;

            case R.id.TutorialSession:
                Intent intent1 = new Intent(ActivitiesNavDrawer.this, Group.class);
                startActivity(intent1);
                break;

            case R.id.Notes:
                Intent intent2 = new Intent(ActivitiesNavDrawer.this, Note.class);
                startActivity(intent2);
                break;

            case R.id.NoteShare:
                Toast.makeText(this, "Share Note", Toast.LENGTH_SHORT);
                break;

            case R.id.Logout:
                Button lougoutbtn = (Button)findViewById(R.id.testLogout);
                lougoutbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final AlertDialog.Builder builder = new AlertDialog.Builder(ActivitiesNavDrawer.this);
                        builder.setMessage("Do you want to log out?");
                        builder.setCancelable(true);
                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });

                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                });
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    /*      */
}