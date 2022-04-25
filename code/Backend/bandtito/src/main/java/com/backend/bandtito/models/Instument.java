package com.backend.bandtito.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

@Entity
@Table(name = "instuments", schema = "public")
public class Instument {
    
    //Columns

    @Id
    @Column(name = "instument_name", nullable = true)
    private String name;

    @OneToMany(mappedBy = "instument", fetch = FetchType.EAGER,
    cascade = CascadeType.ALL)
    private Set<BandPosition> bandPositions;

    @ManyToMany(mappedBy = "instuments", fetch = FetchType.EAGER)
    Set<Musician> musicians = new HashSet<>();

    //Constructors

    public Instument() {
        
    }

    public Instument(String name) {
        this.name = name;
    }

    //Getters

    public String getName(){
        return this.name;
    }

    public Set<BandPosition> getBandPositions(){
        return this.bandPositions;
    }

    public Set<Musician> getMusicians(){
        return this.musicians;
    }

    //toString

    public String toString(){
        return this.name;
    }

}