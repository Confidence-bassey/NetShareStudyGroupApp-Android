package com.zealmobile.netsharestudyapp;

import android.util.Log;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    private static String BASE_URL = "https://netshare-study-group-api.azurewebsites.net/";

    public static Retrofit getRetrofitInstance(){
        if(retrofit==null){
            Log.d("TAG", "retrofit called");
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
