package com.zealmobile.netsharestudyapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
//import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.zealmobile.netsharestudyapp.Models.UserAccountModel;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserDetailsView extends AppCompatActivity {

    int Image_Code = 1;
    private CircleImageView image_pic;
    TextView names, email, phoneNo;
    Uri uri;
    String unames, uemail, uphoneNumber;
    //private int uimage;
    UserAccountModel userDetails = new UserAccountModel();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("INFO", "calling onActivity Result");
        if (requestCode == 1) {
            uri = data.getData();
            image_pic.setImageURI(uri);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details_view);

        image_pic = findViewById(R.id.user_profile_pic);
        names = findViewById(R.id.fullName);
        email = findViewById(R.id.u_email);
        phoneNo = findViewById(R.id.u_phoneNumber);

        int uimage = getIntent().getIntExtra("image_id",0);
        unames = getIntent().getStringExtra("fullname");
        uemail = getIntent().getStringExtra("email");
        uphoneNumber = getIntent().getStringExtra("phonenumber");

        Log.i("INFO","calling getIntent image_pic");
        image_pic.setImageURI(uri);
        image_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
               // Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               // intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                //This is supposed to be written in Apphomeactivty while we get the intent using onActivityResult method here
                //     todo: after church today
                //intent.setAction(Intent.ACTION_GET_CONTENT);
                Log.i("INFO","upload pic in progress");
                startActivityForResult(Intent.createChooser(intent,"title"),Image_Code);
                Log.i("INFO","upload pic in called");
            }
        });
        Log.i("INFO","Done calling getIntent image_pic");
        Log.i("INFO","calling remaining getIntents");
        names.setText(unames);
        //names.setText(userDetails.getFirstName()+" "+userDetails.getLastName());
        email.setText(uemail);
        phoneNo.setText(uphoneNumber);
        Log.i("INFO","Done calling getIntent");
    }
}