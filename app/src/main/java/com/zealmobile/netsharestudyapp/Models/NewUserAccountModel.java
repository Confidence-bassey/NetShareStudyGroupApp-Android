package com.zealmobile.netsharestudyapp.Models;

import com.google.gson.annotations.SerializedName;

public class NewUserAccountModel {

    @SerializedName("firstName")
    public String firstName;

    @SerializedName("lastName")
    public String lastName;

    @SerializedName("email")
    public String email;

    @SerializedName("phoneNumber")
    public String phoneNumber;


    public NewUserAccountModel(String fistName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phone;
    }

}
