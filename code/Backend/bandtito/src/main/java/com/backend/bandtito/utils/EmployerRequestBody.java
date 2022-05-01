package com.backend.bandtito.utils;

public class EmployerRequestBody{
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String profilePic;

    //Getters

    public String getUsername(){
        return this.username;
    }

    public String getFirstName(){
        return this.firstname;
    }

    public String getLastName(){
        return this.lastname;
    }

    public String getPassword(){
        return this.password;
    }

    public String getProfilePic(){
        return this.profilePic;
    }
}