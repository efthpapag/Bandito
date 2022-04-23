package com.backend.bandtito.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.Column;

@Entity
@Table(name = "bands", schema = "public")
public class Band {

    //Columns
    
    @Id
    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "address", nullable = true)
    private String address;

    @OneToOne
    @JoinColumn(name = "admin", nullable = true)
    private Musician admin;

   // @OneToMany(mappedBy="name")
    //private Set<BandPosition> bandPositions;

    //Constructors 

    public Band() {
        
    }

    public Band(String name, String address, Musician admin) {
        this.name = name;
        this.address = address;
        this.admin = admin;
    }

    //Getters

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    //Setters

    public void setAddress(String address){
        this.address = address;
    }

    public void setAdmin(Musician admin){
        this.admin = admin;
    }

    //toString

    public String toString(){
        return this.name;
    }

}
