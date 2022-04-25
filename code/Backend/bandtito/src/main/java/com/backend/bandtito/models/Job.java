package com.backend.bandtito.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

@Entity
@Table(name = "jobs", schema = "public")
public class Job {

    //Columns

    @Id
    @Column(name = "job_name", nullable = true)
    private String name;

    @Column(name = "address", nullable = true)
    private String address;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "username", nullable = false)
    private Employer employer;

    @OneToMany(mappedBy = "job", fetch = FetchType.EAGER,
    cascade = CascadeType.ALL)
    private Set<Concert> concerts;

    //Constructors

    public Job() {
        
    }

    public Job(String name, String address, Employer employer) {
        this.name = name;
        this.address = address;
        this.employer = employer;
    }

    //Getters

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

    public Set<Concert> getConcerts(){
        return this.concerts;
    }

    //toString

    public String toString(){
        return this.name;
    }
    
}