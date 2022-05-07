package com.zealmobile.netsharestudyapp.Models;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReadingSessionAdapter extends RecyclerView.Adapter<ReadingSessionAdapter.ReaadingSessionViewHolder> {


    private int numOfItems;

    public ReadingSessionAdapter(int itemsNumber){
          numOfItems = itemsNumber;
    }

    @NonNull
    @Override
    public ReaadingSessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ReaadingSessionViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return numOfItems;
    }

    class ReaadingSessionViewHolder extends RecyclerView.ViewHolder {

        public ReaadingSessionViewHolder(View readingItemView){
            super(readingItemView);
        }
    }
}
