package com.zealmobile.netsharestudyapp.Models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zealmobile.netsharestudyapp.R;

import java.util.ArrayList;

public class UserListAdapter extends ArrayAdapter<NewUserAccountModel> {

    public UserListAdapter(Context context, ArrayList<NewUserAccountModel> userDetails){
        super(context, R.layout.list_item_design, userDetails);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        NewUserAccountModel userDetails = getItem(position);
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_design,parent,false);
        }
        ImageView imageView = convertView.findViewById(R.id.profile_pic);
        TextView fname = convertView.findViewById(R.id.personName);
        TextView lastName = convertView.findViewById(R.id.lmessage);
        TextView phoneNumber = convertView.findViewById(R.id.ltime);

        return super.getView(position, convertView, parent);
    }
}
