package com.backend.bandtito.models;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "years_of_experience", schema = "public")
public class YearsOfExperience {

    //Columns

    @Id
    @Column(name = "uuid", nullable = true)
    private String uuid;

    @Column(name = "number_of_years", nullable = true)
    private Integer numberOfYears;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "username", nullable = true)
    private Musician musician;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "instument_name", nullable = true)
    private Instrument instrument;

    //Constructors

    public YearsOfExperience() {
        
    }

    public YearsOfExperience(int numberOfYears, Musician musician, Instrument instrument) {

        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();

        this.uuid = random.ints(leftLimit, rightLimit + 1)
        .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
        .limit(targetStringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
        this.numberOfYears = numberOfYears;
        this.musician = musician;
        this.instrument = instrument;
    }

    //Getters

    public String getUuid(){
        return this.uuid;
    }

    public int getNumberOfYears(){
        return this.numberOfYears;
    }

    public Musician getMusician(){
        return this.musician;
    }

    public Instrument getInstument(){
        return this.instrument;
    }

    //Setting

    public void setNumberOfYears(int numberOfYears){
        this.numberOfYears = numberOfYears;
    }
    
}
