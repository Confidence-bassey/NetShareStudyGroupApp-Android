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
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserListAdapter extends ArrayAdapter<UserAccountModel> {

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


        //
        Log.i("INFO","Calling list items");
        CircleImageView imageView = (CircleImageView)convertView.findViewById(R.id.profile_pic);

        TextView profileName = (TextView) convertView.findViewById(R.id.personName);
        TextView statusMsg = (TextView) convertView.findViewById(R.id.lmessage);
        Log.i("INFO","Done Calling list items");

        profileName.setText(userDetails.getFirstName()+" "+userDetails.getLastName());
        statusMsg.setText(randomStatus());


        return convertView;
    }

    private String randomStatus(){
        String[] status = new String[]{"Comp Sci, Unical", "MicroBiology, Uyo", "Mathematics, Uniben", "Mech Engrn., Delsu"};
        int pos = ((int) Math.random()) * status.length;
        return pos < status.length? status[pos]: status[pos-1];
    }
}
