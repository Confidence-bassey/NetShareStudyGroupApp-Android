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


        this.initScreen();
    }


    private void initScreen() {
        Call<List<UserAccountModel>> userAccountsApiCall = _accountsAPI.getUsers();
        userAccountsApiCall.enqueue(new Callback<List<UserAccountModel>>(){
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<UserAccountModel>> call, Response<List<UserAccountModel>> response) {
                //flatten the UserAccountModel object into a simple list of account names
                List<UserAccountModel> userAccountNames = response.body().stream().map(u -> {return new UserAccountModel(u.getImageId(),u.getFirstName(),u.getLastName());}).collect(Collectors.toList());
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

    public void imageViewItem(){
        viewImage = (CircleImageView)findViewById(R.id.profile_pic);
        viewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                Log.i("INFO","upload pic in progress");
                startActivityForResult(Intent.createChooser(intent,"title"),Image_Code);
                Log.i("INFO","upload pic in called");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("INFO","calling onActivity Result");
        if(requestCode==1) {
            Uri uri = data.getData();
            viewImage.setImageURI(uri);
        }
    }

}