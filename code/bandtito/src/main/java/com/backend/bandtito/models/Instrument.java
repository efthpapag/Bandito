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
@Table(name = "instruments", schema = "public")
public class Instrument {
    
    //Columns

    @Id
    @Column(name = "instrument_name", nullable = true)
    private String name;

    @Column(name = "picture_of_instrument", nullable = true)
    private String pictureOfInstrument;

    @OneToMany(mappedBy = "instrument", fetch = FetchType.EAGER,
    cascade = CascadeType.ALL)
    private Set<BandPosition> bandPositions;

    @OneToMany(mappedBy = "instrument", fetch = FetchType.EAGER,
    cascade = CascadeType.ALL)
    private Set<YearsOfExperience> yearsOfExperience;

    //Constructors

    public Instrument() {
        
    }

    public Instrument(String name, String pictureOfInstrument) {
        this.name = name;
        this.pictureOfInstrument = pictureOfInstrument;
    }

    //Getters

    public String getName(){
        return this.name;
    }

    public Set<BandPosition> getBandPositions(){
        return this.bandPositions;
    }

    public Set<YearsOfExperience> getYearsOfExperience(){
        return this.yearsOfExperience;
    }

    //toString

    public String toString(){
        return this.name;
    }

}