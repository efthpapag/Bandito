package com.backend.bandtito.models;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "users", schema = "public")
public class User {

    @Id
    @Column(name = "uuid", nullable = true)
    private String uuid;

    @Column(name = "firstname", nullable = true)
    private String firstname;

    @Column(name = "lastname", nullable = true)
    private String lastname;

    @Column(name = "password", nullable = true)
    private String password;

    public User() {
        
    }

    public User(String firstname, String lastname, String password) {

        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();

        this.firstname = firstname;
        this.lastname = lastname;
        this.uuid = random.ints(leftLimit, rightLimit + 1)
        .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
        .limit(targetStringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
        this.password = password;
    }

    public String getFirstName(){
        return this.firstname;
    }

    public String getLastName(){
        return this.lastname;
    }

    public String getuuid(){
        return this.uuid;
    }

    public String getPassword(){
        return this.password;
    }
    
}