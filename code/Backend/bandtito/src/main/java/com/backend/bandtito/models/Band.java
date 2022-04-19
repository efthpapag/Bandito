package com.backend.bandtito.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "bands", schema = "public")
public class Band {
    
    @Id
    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "address", nullable = true)
    private String address;

    public Band() {
        
    }

    public Band(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String address){
        this.address = address;
    }

}
