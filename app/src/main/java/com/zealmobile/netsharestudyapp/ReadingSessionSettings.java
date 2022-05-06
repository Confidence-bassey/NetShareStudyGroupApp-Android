package com.zealmobile.netsharestudyapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReadingSessionSettings#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReadingSessionSettings extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reading_session_settings, container, false);
        Button startSes = view.findViewById(R.id.startSession);
        startSes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getChildFragmentManager();
                SessionTitle readingSecTitle = new SessionTitle();
                fm.beginTransaction().replace(R.id.RsessionSettings, readingSecTitle).commit();
            }
        });
        return view;
    }
}