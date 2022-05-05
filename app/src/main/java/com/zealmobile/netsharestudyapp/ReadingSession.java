package com.zealmobile.netsharestudyapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ReadingSession extends Fragment {

    FloatingActionButton fbtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reading_session, container, false);
        fbtn = view.findViewById(R.id.NewReadingSession);
        fbtn.setBackgroundColor(R.drawable.custombtnbg);
        fbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getChildFragmentManager();
                ReadingSessionSettings readingSecSetting = new ReadingSessionSettings();
                fm.beginTransaction().replace(R.id.readingSession, readingSecSetting).commit();
            }
        });
        return view;
    }
}