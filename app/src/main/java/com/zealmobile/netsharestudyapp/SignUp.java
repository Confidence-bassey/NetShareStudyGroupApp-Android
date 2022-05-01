package com.zealmobile.netsharestudyapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.zealmobile.netsharestudyapp.Models.CreateAccountResponse;
import com.zealmobile.netsharestudyapp.Models.NewUserAccountModel;
import com.zealmobile.netsharestudyapp.Models.UserAccountModel;
import com.zealmobile.netsharestudyapp.dao.UserAccountInterface;

import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.LENGTH_LONG;

public class SignUp extends AppCompatActivity {

    
    private EditText txtFirstName;
    private EditText txtLastName;
    private EditText txtEmail;
    private EditText txtPhoneNumber;

    UserAccountInterface _accountsAPI;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        _accountsAPI = RetrofitClient.getRetrofitInstance().create(UserAccountInterface.class);

        txtFirstName = (EditText) findViewById(R.id.txt_signup_firstName);
        txtLastName = (EditText) findViewById(R.id.txt_signup_lastName);
        txtEmail = (EditText) findViewById(R.id.txt_signup_email);
        txtPhoneNumber = (EditText) findViewById(R.id.txt_signup_phone);


        Button signUpButton = (Button) findViewById(R.id.btnSignUp);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(txtFirstName.getText().toString())) {
                    txtFirstName.setError("*required");
                    txtFirstName.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(txtLastName.getText().toString())) {
                    txtLastName.setError("*required");
                    txtLastName.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(txtEmail.getText().toString())) {
                    txtEmail.setError("*required");
                    txtEmail.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(txtPhoneNumber.getText().toString())) {
                    txtPhoneNumber.setError("*required");
                    txtPhoneNumber.requestFocus();
                    return;
                }
                handleCreateAccountButtonClick();
            }
        });

    }
        protected void handleCreateAccountButtonClick () {
            NewUserAccountModel newUserAccount = new NewUserAccountModel();
            newUserAccount.setFirstName(txtFirstName.getText().toString());
            newUserAccount.setLastName(txtLastName.getText().toString());
            newUserAccount.setEmail(txtEmail.getText().toString());
            newUserAccount.setPhoneNumber(txtPhoneNumber.getText().toString());


            Log.i("StudyGroup", String.format("sending user account payload: \n%s\n", new Gson().toJson(newUserAccount)));
            //Todo: Here validate that every filled has been supplied a value
            Call<CreateAccountResponse> createAccountApiCall = RetrofitClient.getUAccountInterface().creaxteUserAccount(newUserAccount);
            createAccountApiCall.enqueue(
                    new Callback<CreateAccountResponse>() {
                        @Override
                        public void onResponse(Call<CreateAccountResponse> call, Response<CreateAccountResponse> response) {
                            Log.i("StudyGroup", String.format("create user account returned with response: \n%s", new Gson().toJson(response.body())));

                            Toast.makeText(SignUp.this, "Successfully created account", LENGTH_LONG);

                            Intent homeActivityIntent = new Intent(SignUp.this, AppHomeActivity.class);
                            startActivity(homeActivityIntent);
                        }

                        @Override
                        public void onFailure(Call<CreateAccountResponse> call, Throwable t) {
                            Log.e("StudyGroup", String.format("Error occurred while creating new user account: %s", t.getMessage()), t);
                            createAccountApiCall.cancel();
                        }
                    });


        }

}