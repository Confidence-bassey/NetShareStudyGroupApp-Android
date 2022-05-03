package com.zealmobile.netsharestudyapp;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.zealmobile.netsharestudyapp.Models.NewUserAccountModel;
import com.zealmobile.netsharestudyapp.Models.UserAccountModel;
import com.zealmobile.netsharestudyapp.Models.UserListAdapter;
import com.zealmobile.netsharestudyapp.dao.UserAccountInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppHomeActivity extends AppCompatActivity {

    List<UserAccountModel> userAccountNames;
    CircleImageView viewImage;
    int Image_Code = 1;
    UserAccountInterface _accountsAPI;
    ListView _accountsListVw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_home);

        _accountsAPI = RetrofitClient.getRetrofitInstance().create(UserAccountInterface.class);
        _accountsListVw =(ListView) findViewById(R.id.lv_accountsList);

        //_accountsListVw.setOnItemClickListener(new);
        this.initScreen();
        this.viewDetails();
    }


    private void initScreen() {
        Call<List<UserAccountModel>> userAccountsApiCall = _accountsAPI.getUsers();
        userAccountsApiCall.enqueue(new Callback<List<UserAccountModel>>(){
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<UserAccountModel>> call, Response<List<UserAccountModel>> response) {
                //flatten the UserAccountModel object into a simple list of account names
                userAccountNames = response.body().stream().map(u -> {return new UserAccountModel(u.getImageId(),u.getFirstName(),u.getLastName());}).collect(Collectors.toList());
                _accountsListVw.setAdapter(new UserListAdapter(AppHomeActivity.this, new ArrayList<>(userAccountNames)));
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

  /*  public void deleteUserAccount(View view){
        Button deletebtn = (Button)findViewById(R.id.deleteAccount);
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AppHomeActivity.this);
                builder.setTitle("Are you sure you want to delete this account?");
                builder.setMessage("This action is irreversible...");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Call<UserAccountModel> deleteAccount = RetrofitClient.getUAccountInterface().deleteUser(UserAccountModel.getId());
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

    }  */

    public void viewDetails(){
        //= new UserAccountModel();

        _accountsListVw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Log.i("INFO","calling intent1");
                UserAccountModel user = userAccountNames.get(position);
                Intent intent1 = new Intent(AppHomeActivity.this, UserDetailsView.class);
                intent1.putExtra("image_id", user.getImageId());
                intent1.putExtra("fullname", (user.getFirstName()+" " +user.getLastName()));
                intent1.putExtra("email", user.getEmail());
                intent1.putExtra("phonenumber", user.getPhoneNumber());
                startActivity(intent1);
                Log.i("INFO","Done calling intent1");
            }
        });
    }

}