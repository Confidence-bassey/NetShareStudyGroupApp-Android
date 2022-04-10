package com.zealmobile.netsharestudyapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.zealmobile.netsharestudyapp.Models.UserAccountModel;
import com.zealmobile.netsharestudyapp.dao.UserAccountInterface;

import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppHomeActivity extends AppCompatActivity {

    UserAccountInterface _accountsAPI;
    ListView _accountsListVw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_home);

        _accountsAPI = RetrofitClient.getRetrofitInstance().create(UserAccountInterface.class);
        _accountsListVw =(ListView) findViewById(R.id.lv_accountsList);


        this.initScreen();
    }


    private void initScreen() {
        Call<List<UserAccountModel>> userAccountsApiCall = _accountsAPI.getUsers();
        userAccountsApiCall.enqueue(new Callback<List<UserAccountModel>>(){
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<UserAccountModel>> call, Response<List<UserAccountModel>> response) {
                //flatten the UserAccountModel object into a simple list of account names
                List<String> userAccountNames = response.body().stream().map(u -> u.firstName+" "+u.lastName).collect(Collectors.toList());
                _accountsListVw.setAdapter(new ArrayAdapter(AppHomeActivity.this, android.R.layout.simple_list_item_1,userAccountNames));
            }

            @Override
            public void onFailure(Call<List<UserAccountModel>> call, Throwable t) {
                Log.d("App_Home", String.format("Get user accounts api call failed with error: %s",t.getMessage()), t);
                userAccountsApiCall.cancel();
            }
        });
    }

    public void showUserDashBoard(View view){
        Button myIview = (Button) findViewById(R.id.viewUserdboard);
        myIview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppHomeActivity.this, ActivitiesNavDrawer.class);
                startActivity(intent);
            }
        });
    }
}