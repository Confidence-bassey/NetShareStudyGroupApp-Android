package com.zealmobile.netsharestudyapp.dao;

import com.zealmobile.netsharestudyapp.Models.UserAccountModel;
import com.zealmobile.netsharestudyapp.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserAccountInterface {
    @GET("accounts")
    Call<List<UserAccountModel>> getUsers();


}
