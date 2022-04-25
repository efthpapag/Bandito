package com.backend.bandtito.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

@Entity
@Table(name = "music_genres", schema = "public")
public class MusicGenre {

    //Columns

    @Id
    @Column(name = "music_genre_name", nullable = true)
    private String name;

    @ManyToMany(mappedBy = "musicGenres", fetch = FetchType.EAGER)
    Set<Concert> concerts = new HashSet<>();

    @ManyToMany(mappedBy = "musicGenres", fetch = FetchType.EAGER)
    Set<Band> bands = new HashSet<>();

    @ManyToMany(mappedBy = "musicGenres", fetch = FetchType.EAGER)
    Set<Musician> musicians = new HashSet<>();

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