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

    //Constructors
    
    public Employer(){
        
    }

    public Employer(String username,String firstname, String lastname, String password){
        super(username, firstname, lastname, password);
    }

    //Other

    public void addJob(Job job){
        jobs.add(job);
    }
    
}
