package com.zealmobile.netsharestudyapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Group#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Group extends Fragment {

    Button viewGroup, createGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_group, container, false);

        viewGroup = view.findViewById(R.id.viewEGroups);
        createGroup = view.findViewById(R.id.newGroup);

        createGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CreateNewGroup.class);
                startActivity(intent);
            }
        });

        return view;
    }
}