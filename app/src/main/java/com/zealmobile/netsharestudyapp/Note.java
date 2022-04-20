package com.zealmobile.netsharestudyapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Note#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Note extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_note, container, false);
        FloatingActionButton fab = view.findViewById(R.id.newNotefab);
        fab.setBackgroundColor(R.drawable.custombtnbg);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddNewNote newNoteFrag = new AddNewNote();
                FragmentManager manager = getChildFragmentManager();
                manager.beginTransaction().replace(R.id.noteFrag, newNoteFrag).commit();
            }
        });
        return view;
    }

}