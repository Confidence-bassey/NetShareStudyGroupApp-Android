package com.zealmobile.netsharestudyapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

public class UserAccountModel {


    @SerializedName("id")
    public int id;

    @SerializedName("userId")
    public String userId;

    @SerializedName("firstName")
    public String firstName;

    @SerializedName("lastName")
    public String lastName;

    @SerializedName("email")
    private String email;

    @SerializedName("passwordHash")
    private String passwordHash;

    @SerializedName("createdDate")
    private Date createdDate;

    @SerializedName("accountType")
    private String accountType;

    @SerializedName("status")
    private String status;

    @SerializedName("phoneNumber")
    private String phoneNumber;




}
