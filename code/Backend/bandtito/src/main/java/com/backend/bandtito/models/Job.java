package com.backend.bandtito.models;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "jobs", schema = "public")
public class Job {

    @Id
    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "address", nullable = true)
    private String address;

    public Job() {
        
    }

    public Job(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public void getName(String name){
        this.name = name;
    }

    public void getAddress(String address){
        this.address = address;
    }
    
}