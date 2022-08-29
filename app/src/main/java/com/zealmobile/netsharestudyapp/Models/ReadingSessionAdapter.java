package com.zealmobile.netsharestudyapp.Models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zealmobile.netsharestudyapp.R;

public class ReadingSessionAdapter extends RecyclerView.Adapter<ReadingSessionAdapter.ReadingSessionViewHolder> {


    private int numOfItems;

    public ReadingSessionAdapter(int itemsNumber){
          numOfItems = itemsNumber;
    }

    @NonNull
    @Override
    public ReadingSessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int listLayoutId = R.layout.list_item_design;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        boolean attach = false;

        View view = layoutInflater.inflate(listLayoutId,parent,attach);
        ReadingSessionViewHolder viewHolder = new ReadingSessionViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReadingSessionViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return numOfItems;
    }

    class ReadingSessionViewHolder extends RecyclerView.ViewHolder {
        TextView readingListItemtV;
        EditText enteredTitle;

        public ReadingSessionViewHolder(View readingItemView){
            super(readingItemView);
         //   readingListItemtV = (TextView) readingItemView.findViewById(R.id.tvTitle);
         //   enteredTitle = (EditText) readingItemView.findViewById(R.id.sessionSettings);
        }

        void bind(int listItemIdex){
           // readingListItemtV.setText(enteredTitle.getText().toString());
        }
    }

}
