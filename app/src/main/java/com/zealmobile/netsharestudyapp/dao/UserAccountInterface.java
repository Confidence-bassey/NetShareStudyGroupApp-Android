package com.zealmobile.netsharestudyapp.dao;

import com.zealmobile.netsharestudyapp.Models.CreateAccountResponse;
import com.zealmobile.netsharestudyapp.Models.NewUserAccountModel;
import com.zealmobile.netsharestudyapp.Models.UserAccountModel;
import com.zealmobile.netsharestudyapp.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserAccountInterface {
    @GET("accounts")
    Call<List<UserAccountModel>> getUsers();

    @POST("accounts/create")
    Call<CreateAccountResponse> creaxteUserAccount(@Body NewUserAccountModel userAccount);

    @DELETE()
    Call<UserAccountModel> deleteUser(@Path("id") int id);
}
