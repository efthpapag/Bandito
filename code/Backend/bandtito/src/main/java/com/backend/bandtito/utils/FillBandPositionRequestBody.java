package com.backend.bandtito.utils;

public class FillBandPositionRequestBody {

    private String bandPositionUuid;
    private String musician;
    
    //Getters

    public String getBandPositionUuid(){
        return this.bandPositionUuid;
    }

    public String getMusician(){
        return this.musician;
    }
}
