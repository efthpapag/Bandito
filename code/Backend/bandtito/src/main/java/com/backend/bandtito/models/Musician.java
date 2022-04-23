package com.backend.bandtito.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "musicians", schema = "public")
public class Musician extends User{

    //Columns

    @Column(name = "isBandMember", nullable = true)
    private boolean isBandMember;

    @Column(name = "address", nullable = true)
    private String address;

    @OneToOne(mappedBy = "admin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_of_band", nullable = true)
    private Band adminOfBand;

    //Constructors

    public Musician() {
        
    }

    public Musician(String username, String firstname, String lastname, String password, String address) {
        super(username, firstname, lastname, password);
        this.address = address;
        this.isBandMember = false;
    }

    //Getters

    public String getAddress(){
        return this.address;
    }
    
    public boolean getIsBandMember(){
        return this.isBandMember;
    }

    public Band getAdminOfBand(){
        return this.adminOfBand;
    }
    
    //Setters

    public void setAddress(String address){
        this.address = address;
    }
    
    public void setIsBandMember(boolean isBandMember){
        this.isBandMember = isBandMember;
    }

}