package com.backend.bandtito.models;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "band_positions", schema = "public")
public class BandPosition {

    //Columns 

    @Id
    @Column(name = "band_positions_uuid", nullable = true)
    private String uuid;

    @Column(name = "occupied", nullable = true)
    private boolean occupied;

    @OneToOne
    @JoinColumn(name = "musician", nullable = true)
    private Musician musician;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "band_position_instument", nullable = false)
    private Instument instument;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "band_name", nullable = false)
    private Band band;

    //Constructors

    public BandPosition() {
        this.occupied = false;
    }

    public BandPosition(Instument instument, Band band) {

        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();

        this.uuid = random.ints(leftLimit, rightLimit + 1)
        .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
        .limit(targetStringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
        
        this.occupied = false;
        this.instument = instument;
        this.band = band;
    }

    //Getters

    public String getUuid(){
        return this.uuid;
    }

    public boolean getOccupied(){
        return this.occupied;
    }

    //Setters

    public void setOccupied(boolean occupied){
        this.occupied = occupied;
    }

    public void fillPossition(Musician musician){
        this.occupied = true;
        this.musician = musician;
    }

    //toString

    public String toString(){
        return this.uuid;
    }
    
}
