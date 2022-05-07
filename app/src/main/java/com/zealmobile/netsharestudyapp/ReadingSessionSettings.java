package com.zealmobile.netsharestudyapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReadingSessionSettings} factory method to
 * create an instance of this fragment.
 */
public class ReadingSessionSettings extends Fragment {

    TextInputLayout readingsecType;
    TextInputLayout readingResource;
    AutoCompleteTextView sesType;
    AutoCompleteTextView sesResource;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reading_session_settings, container, false);

        Log.i("INFO","Calling resources");
        Button startSes = view.findViewById(R.id.startSession);
        readingsecType = view.findViewById(R.id.fDD);
        readingResource = view.findViewById(R.id.readingResource);
        sesType = view.findViewById(R.id.fDDAuto);
        sesResource = view.findViewById(R.id.resourceAuto);

        String [] readingResouce = {"select from phone(pdf)", "browse material"};
        String [] sessionType = {"Personal Study", "group study"};

        Log.i("INFO","Calling bindings");
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(getContext(),R.layout.dropdownitems,readingResouce);
        sesType.setAdapter(itemsAdapter);
        ArrayAdapter<String> itemsAdapter1 = new ArrayAdapter<>(getContext(),R.layout.dropdownitems,sessionType);
        sesResource.setAdapter(itemsAdapter1);

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