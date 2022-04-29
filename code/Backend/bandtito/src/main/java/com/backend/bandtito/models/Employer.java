package com.backend.bandtito.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employers", schema = "public")
public class Employer extends User{

    //Columns

    @OneToMany(mappedBy = "employer", fetch = FetchType.EAGER,
    cascade = CascadeType.ALL)
    private Set<Job> jobs;

    @OneToMany(mappedBy = "employer", fetch = FetchType.EAGER,
    cascade = CascadeType.ALL)
    private Set<Rating> ratings;

    //Constructors
    
    public Employer(){
        
    }

    public Employer(String username,String firstname, String lastname, String password){
        super(username, firstname, lastname, password);
    }

    //Getters

    public Set<Job> getJobs(){
        return this.jobs;
    }

    public Set<Rating> getRatings(){
        return this.ratings;
    }

}
