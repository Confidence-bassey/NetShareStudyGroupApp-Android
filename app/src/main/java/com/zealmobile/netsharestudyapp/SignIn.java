package com.zealmobile.netsharestudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignIn extends AppCompatActivity {

    private EditText txtPhoneNumber;
    private EditText txtpassword;
    private EditText txtconfirmpass;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        txtPhoneNumber = findViewById(R.id.txt_Username);
        txtpassword = findViewById(R.id.txt_signIn_password);
        txtconfirmpass = findViewById(R.id.txt_confirm_password);
        loginBtn = findViewById(R.id.btnLogin);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this, ActivitiesNavDrawer.class);
                startActivity(intent);
            }
        });
    }
}