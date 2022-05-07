package com.backend.bandtito.utils;

import java.util.List;

public class BandRequestBody {
    
    private String name;
    private String address;
    private String musician; 
    private List<String> listOfMusicGenres;
    private String forHire; 
    private String bandPicture;

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public String getMusician(){
        return this.musician;
    }

    public List<String> getListOfMusicGenres(){
        return this.listOfMusicGenres;
    }

    public boolean getForHire(){
        return Boolean.valueOf(this.forHire);
    }

    public String getBandPicture(){
        return this.bandPicture;
    }
}
