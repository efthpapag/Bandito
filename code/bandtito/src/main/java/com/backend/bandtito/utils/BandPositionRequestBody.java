package com.backend.bandtito.utils;

public class BandPositionRequestBody {

    private String instrument;
    private String band;

    //Getters

    public String getInstument(){
        return this.instrument;
    }
    
    public String getBand(){
        return this.band;
    }
}
