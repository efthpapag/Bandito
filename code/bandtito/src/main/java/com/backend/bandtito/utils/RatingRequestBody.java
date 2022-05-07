package com.backend.bandtito.utils;

public class RatingRequestBody {
    
    private String employer;
    private String band;
    private String rating;

    //Getters

    public String getEmployer(){
        return this.employer;
    }
    
    public String getBand(){
        return this.band;
    }

    public int getRating(){
        return Integer.parseInt(this.rating);
    }
}