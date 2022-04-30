package com.backend.bandtito.utils;

import java.util.List;

public class CreateMusicianRequestBody{
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String address;
    private int age;
    private List<String> listOfInstuments;
    private List<Integer> listOfYears;
    private List<String> listOfMusicGenres;
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

    public List<Integer> getListOfYears(){
        return this.listOfYears;
    }

    public int getAge(){
        return this.age;
    }

    public String getAddress(){
        return this.address;
    }

    public List<String> getMusicGenres(){
        return this.listOfMusicGenres;
    }

    public List<String> getListOfInstuments(){
        return this.listOfInstuments;
    }
}