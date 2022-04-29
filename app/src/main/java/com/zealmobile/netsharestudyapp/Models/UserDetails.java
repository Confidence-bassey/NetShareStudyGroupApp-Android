package com.zealmobile.netsharestudyapp.Models;

public class UserDetails {
    String firstName, lastName, email, phoneNumber;
    int imageId;

    public UserDetails(String firstName, String lastName, String email, String phoneNumber, int imageId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.imageId = imageId;
    }
}
