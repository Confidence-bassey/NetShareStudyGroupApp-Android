package com.zealmobile.netsharestudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zealmobile.netsharestudyapp.Models.UserAccountModel;
import com.zealmobile.netsharestudyapp.dao.UserAccountInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.zealmobile.netsharestudyapp.RetrofitClient.getRetrofitInstance;

public class Notification extends AppCompatActivity {

    private Button btnNotice;
    private static String TAG = "Notification";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        btnNotice = (Button) findViewById(R.id.getData);
        btnNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               UserAccountInterface usersInterface = getRetrofitInstance().create(UserAccountInterface.class);
                Call<UserAccountModel> callUsers = usersInterface.getUsers();

                callUsers.enqueue(new Callback<UserAccountModel>() {
                    @Override
                    public void onResponse(Call<UserAccountModel> call, Response<UserAccountModel> response) {
                        Log.i(TAG, "onResponse : called");
                        Log.e(TAG,"onResponse: code: "+response.code());
                    }

                    @Override
                    public void onFailure(Call<UserAccountModel> call, Throwable t) {
                        Log.i(TAG, "onFailure : called");
                    }
                });
            }
        });

    }
}