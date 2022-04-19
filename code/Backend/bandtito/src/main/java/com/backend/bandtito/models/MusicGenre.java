package com.backend.bandtito.models;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "musicGenre", schema = "public")
public class MusicGenre {

    @Id
    @Column(name = "name", nullable = true)
    private String name;

    public MusicGenre() {
        
    }

    public MusicGenre(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    
}