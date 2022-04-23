package com.backend.bandtito.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bandPositions", schema = "public")
public class BandPosition {

    //Columns 

    @Id
    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "occupied", nullable = true)
    private boolean occupied;

    @OneToOne
    @JoinColumn(name = "musician", nullable = true)
    private Musician musician;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "instument", nullable = false)
    private Instument instument;

    //Constructors

    public BandPosition() {
        this.occupied = false;
    }

    public BandPosition(String name, Instument instument) {
        this.name = name;
        this.occupied = false;
        this.instument = instument;
    }

    //Getters

    public String getName(){
        return this.name;
    }

    public boolean getOccupied(){
        return this.occupied;
    }

    //Setters

    public void settName(String name){
        this.name = name;
    }

    public void setOccupied(boolean occupied){
        this.occupied = occupied;
    }

    public void fillPossition(Musician musician){
        this.occupied = true;
        this.musician = musician;
    }

    //toString

    public String toString(){
        return this.name;
    }
    
}
