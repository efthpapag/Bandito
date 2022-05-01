package com.backend.bandtito.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ConcertRequestBody {

    private String date;
    private String job;
    private List<String> listOfMusicGenres;

    //Getters

    public LocalDate getDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        return LocalDate.parse(this.date, formatter);
    }

    public String getJob(){
        return this.job;
    }

    public List<String> getListOfMusicGenres(){
        return this.listOfMusicGenres;
    }
    
}
