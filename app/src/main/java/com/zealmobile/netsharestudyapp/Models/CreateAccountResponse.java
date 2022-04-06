package com.zealmobile.netsharestudyapp.Models;

import com.google.gson.annotations.SerializedName;

public class CreateAccountResponse {

    @SerializedName("succeeded")
    public boolean succeeded;

    @SerializedName("error")
    public String error;

    @SerializedName("userAccount")
    public UserAccountModel userAccount;


    public CreateAccountResponse() {}
    public CreateAccountResponse(boolean succeeded, String error, UserAccountModel account) {
        this.succeeded = succeeded;
        this.error = error;
        this.userAccount = account;
    }

}
