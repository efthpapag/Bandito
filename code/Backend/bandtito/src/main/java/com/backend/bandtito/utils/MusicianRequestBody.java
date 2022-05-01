package com.backend.bandtito.utils;

import java.util.Collections;
import java.util.List;

public class MusicianRequestBody{
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String address;
    private String age;
    private List<String> listOfInstuments;
    private List<String> listOfYears;
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
        List<Integer> years = Collections.<Integer>emptyList();  
        for(int i = 0; i < this.listOfYears.size(); i++){
            years.add(Integer.parseInt(this.listOfYears.get(i)));
        }
        return years;
    }

    public int getAge(){
        return Integer.parseInt(this.age);
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