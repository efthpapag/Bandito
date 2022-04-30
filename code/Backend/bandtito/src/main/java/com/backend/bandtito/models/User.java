package com.backend.bandtito.models;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "users", schema = "public")
public class User {

    //Columns

    @Id
    @Column(name = "username", nullable = true)
    private String username;

    @Column(name = "firstname", nullable = true)
    private String firstname;

    @Column(name = "lastname", nullable = true)
    private String lastname;

    @Column(name = "password", nullable = true)
    private String password;

    @Column(name = "profile_pic", nullable = true)
    private String profilePic;

    //Constructors

    public User() {
        
    }

    public User(String username,String firstname, String lastname, String password, String profilePic) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.profilePic = profilePic;
    }

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

    //Setters

    public void setFirstName(String firstname){
        this.firstname = firstname;
    }

    public void setLastName(String lastname){
        this.lastname = lastname;
    }

    public void setPassword(String password){
        this.password = password;
    }

    //toString

    public String toString(){
        return this.username;
    }
    
}