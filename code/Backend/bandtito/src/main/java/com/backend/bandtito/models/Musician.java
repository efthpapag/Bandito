package com.backend.bandtito.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "musitians", schema = "public")
public class Musician extends User{

    @Column(name = "isBandMember", nullable = true)
    private boolean isBandMember;

    @Column(name = "address", nullable = true)
    private String address;

    public Musician() {
        
    }

    public Musician(String address, boolean isBandMember) {
        this.address = address;
        this.isBandMember = isBandMember;
    }

    public String getAddress(){
        return this.address;
    }
    
    public boolean getIsBandMember(){
        return this.isBandMember;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public void setIsBandMember(boolean isBandMember){
        this.isBandMember = isBandMember;
    }
}