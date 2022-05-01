package com.backend.bandtito.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

public class JobRequestBody {
    
    private String name;
    private String address;
    private String employer;
    private List<String> dates;
    private List<List<String>> genres;

    //Getters

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public String getEmployer(){
        return this.employer;
    }

    public List<LocalDate> getDates(){
        List<LocalDate> d = Collections.<LocalDate>emptyList();  
        for(int i = 0; i < this.dates.size(); i++){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            d.add(LocalDate.parse(this.dates.get(i), formatter));
        }
        return d;
    }

    public List<List<String>> getGenres(){
        return this.genres;
    }
}
