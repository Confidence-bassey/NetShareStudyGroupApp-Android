package com.zealmobile.netsharestudyapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.zealmobile.netsharestudyapp.Models.UserAccountModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReadingSessionSettings} factory method to
 * create an instance of this fragment.
 */
public class ReadingSessionSettings extends Fragment {

    TextInputLayout readingsecType;
   // TextInputLayout readingResource;
    AutoCompleteTextView sesType;
    AutoCompleteTextView sesResource;
    Button openResbtn;
    int position;

    Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reading_session_settings, container, false);

       /* Log.i("INFO","Calling resources");
        Button startSes = view.findViewById(R.id.startSession);
        readingsecType = view.findViewById(R.id.fDD);
        //readingResource = view.findViewById(R.id.readingResource);
        sesType = view.findViewById(R.id.fDDAuto);
        //sesResource = view.findViewById(R.id.resourceAuto);
        openResbtn = view.findViewById(R.id.openResource);   */

        spinner = (Spinner) view.findViewById(R.id.spinner);

        String [] readingResouce = {"select from phone(pdf)", "browse material"};
        String [] sessionType = {"Personal Study", "group study"};

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.resMethod, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Toast.makeText(getContext(),"it finally worked, select from phone(pdf) clicked", Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Toast.makeText(getContext(),"it finally worked, browse material clicked", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


     /*   Log.i("INFO","Calling bindings");
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(getContext(),R.layout.dropdownitems,readingResouce);
        sesType.setAdapter(itemsAdapter);
        ArrayAdapter<String> itemsAdapter1 = new ArrayAdapter<>(getContext(),R.layout.dropdownitems,sessionType);
        sesResource.setAdapter(itemsAdapter1);

        startSes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSes.setVisibility(View.GONE);
                openResbtn.setVisibility(View.GONE);
                sesType.setVisibility(View.GONE);
                sesResource.setVisibility(View.GONE);
                FragmentManager fm = getChildFragmentManager();
                SessionTitle readingSecTitle = new SessionTitle();
                fm.beginTransaction().replace(R.id.RsessionSettings, readingSecTitle).commit();
            }
        });  */


        return view;
    }

   /* public void listOptions(){
        sesType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
              /* // sesType.setVisibility(View.GONE);
                Log.i("INFO","calling intent1");
                String typeItems;
                if(parent.getItemAtPosition(position).equals("select from phone(pdf)")){
                    Toast.makeText(parent.getContext(),"it finally worked", Toast.LENGTH_LONG).show();
                }
                Log.i("INFO","Done calling intent1");  */
              /*  switch (position){
                    case 0:
                        Toast.makeText(parent.getContext(),"it finally worked, select from phone(pdf) clicked", Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Toast.makeText(parent.getContext(),"it finally worked, browse material clicked", Toast.LENGTH_LONG).show();
                        break;
                }

            }
        });
    }  */

}