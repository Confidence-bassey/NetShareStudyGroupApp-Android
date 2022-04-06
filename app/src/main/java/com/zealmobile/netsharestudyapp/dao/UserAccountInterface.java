package com.zealmobile.netsharestudyapp.dao;

import com.zealmobile.netsharestudyapp.Models.UserAccountModel;
import com.zealmobile.netsharestudyapp.RetrofitClient;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserAccountInterface {
    @GET("account")
    Call<UserAccountModel> getUsers();
}
