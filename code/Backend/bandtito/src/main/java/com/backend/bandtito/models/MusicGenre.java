package com.backend.bandtito.models;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "musicGenre", schema = "public")
public class MusicGenre {

    //Columns

    @Id
    @Column(name = "name", nullable = true)
    private String name;

    //Constructors

    public MusicGenre() {
        
    }

    public MusicGenre(String name) {
        this.name = name;
    }

    //Getters

    public String getName(){
        return this.name;
    }

    //toString

    public String toString(){
        return this.name;
    }
    
}