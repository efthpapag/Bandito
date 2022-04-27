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
@Table(name = "ratings", schema = "public")
public class Rating {

    //Columns

    @Id
    @Column(name = "uuid", nullable = true)
    private String uuid;

    @Column(name = "rating", nullable = true)
    private Integer rating;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "band_name", nullable = false)
    private Band band;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "username", nullable = false)
    private Employer employer;

    //Constructors

    public Rating() {
        
    }

    public Rating(int rating, Band band, Employer employer) {

        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();

        this.uuid = random.ints(leftLimit, rightLimit + 1)
        .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
        .limit(targetStringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
        this.rating = rating;
        this.employer = employer;
        this.band = band;
    }

    //Getters

    public int getRating(){
        return this.rating;
    }

    public String getUuid(){
        return this.uuid;
    }

    public Employer getEmployer(){
        return this.employer;
    }

    public Band getBand(){
        return this.band;
    }

    //Setters

    public void setNumberOfYears(int rating){
        this.rating = rating;
    }
    
}