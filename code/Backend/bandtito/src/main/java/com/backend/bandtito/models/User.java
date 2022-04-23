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

    //Constructors

    public User() {
        
    }

    public User(String username,String firstname, String lastname, String password) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    //Getters

    public String getFirstName(){
        return this.firstname;
    }

    public String getLastName(){
        return this.lastname;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    //toString

    public String toString(){
        return this.username;
    }
    
}