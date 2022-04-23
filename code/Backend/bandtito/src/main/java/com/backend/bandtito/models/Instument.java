package com.backend.bandtito.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

@Entity
@Table(name = "instuments", schema = "public")
public class Instument {
    
    //Columns

    @Id
    @Column(name = "name", nullable = true)
    private String name;

    @OneToMany(mappedBy = "instument", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private Set<BandPosition> bandPositions;

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

    //toString

    public String toString(){
        return this.name;
    }

}