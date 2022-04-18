package com.backend.bandtito.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Band {
    
    @Id
    @Column(name = "firstname", nullable = true)
    private String firstname;

    @Column(name = "lastname", nullable = true)
    private String lastname;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "uuid", nullable = true)
    private String uuid;

    @Column(name = "password", nullable = true)
    private String password;

    public Band() {
        
    }

    public Band(String firstname, String lastname, String address, String uuid, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.uuid = uuid;
        this.password = password;
    }

    public String getFirstName(){
        return this.firstname;
    }

    public String getLastName(){
        return this.lastname;
    }

    public String getAddress(){
        return this.address;
    }

    public String getuuid(){
        return this.uuid;
    }

    public String getPassword(){
        return this.password;
    }

}
