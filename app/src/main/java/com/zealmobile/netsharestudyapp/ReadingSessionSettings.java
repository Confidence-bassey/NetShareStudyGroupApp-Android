package com.zealmobile.netsharestudyapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.io.File;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Environment;
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
    Button startSes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reading_session_settings, container, false);

        spinner = (Spinner) view.findViewById(R.id.spinner);
        startSes = view.findViewById(R.id.startSession);

        String [] readingResouce = {"choose how you want to get your resources from the drop down", "select from phone(pdf)", "browse material"};
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
                        //startSes.setVisibility(View.GONE);
                        //openResbtn.setVisibility(View.VISIBLE);
                        Toast.makeText(getContext(),"select your session resource", Toast.LENGTH_LONG).show();
                    case 1:
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pdfdrive.com/"));
                        startActivity(browserIntent);
                        break;
                    case 2:
                        openMaterial();
                        //Toast.makeText(getContext(),"it finally worked, browse material clicked", Toast.LENGTH_LONG).show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        return view;
    }

    public void implementBtnClick(){
        startSes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startSes.setVisibility(View.GONE);
                openResbtn.setVisibility(View.GONE);
                sesType.setVisibility(View.GONE);
                sesResource.setVisibility(View.GONE);
                FragmentManager fm = getChildFragmentManager();
                SessionTitle readingSecTitle = new SessionTitle();
                fm.beginTransaction().replace(R.id.RsessionSettings, readingSecTitle).commit();
            }
        });
    }

    public void openMaterial(){
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setType("application/pdf");
                        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                        new File(Environment.getExternalStorageDirectory().getAbsolutePath());
                        startActivity(intent);
          //  }
       // });
    }


}