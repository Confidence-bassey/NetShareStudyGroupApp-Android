package com.zealmobile.netsharestudyapp.Models;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zealmobile.netsharestudyapp.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserListAdapter extends ArrayAdapter<UserAccountModel> {

  //  private CircleImageView imageView;
  //  private EditText txtFirstName;
  //  private EditText txtLastName;

    public UserListAdapter(Context context, ArrayList<UserAccountModel> userDetails){
        super(context, R.layout.list_item_design, userDetails);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        UserAccountModel userDetails = getItem(position);
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_design,parent,false);
        }

        Log.i("INFO","Calling list items");
        CircleImageView imageView = (CircleImageView)convertView.findViewById(R.id.profile_pic);
        EditText txtFirstName = (EditText) convertView.findViewById(R.id.txt_signup_firstName);
        EditText txtLastName = (EditText) convertView.findViewById(R.id.txt_signup_lastName);
        Log.i("INFO","Done Calling list items");

      userDetails.setImageId(imageView.getId());
     //   userDetails.setFirstName(txtFirstName.getText().toString());
       //  userDetails.setLastName(txtLastName.getText().toString());

        return super.getView(position, convertView, parent);
    }
}
