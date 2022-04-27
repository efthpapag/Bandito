package com.backend.bandtito.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@Table(name = "bands", schema = "public")
public class Band {

    //Columns
    
    @Id
    @Column(name = "band_name", nullable = true)
    private String name;

    @Column(name = "address", nullable = true)
    private String address;

    @OneToOne
    @JoinColumn(name = "admin", nullable = true)
    private Musician admin;

    @OneToMany(mappedBy = "band", fetch = FetchType.EAGER,
    cascade = CascadeType.ALL)
    private Set<BandPosition> bandPositions;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(name = "music_genres_bands", joinColumns = @JoinColumn(name = "band_name"), inverseJoinColumns = @JoinColumn(name = "music_genre_name"))
    private Set<MusicGenre> musicGenres = new HashSet<>();

    @OneToMany(mappedBy = "band", fetch = FetchType.EAGER,
    cascade = CascadeType.ALL)
    private Set<Rating> ratings;

    //Constructors 

    public Band() {
        
    }

    public Band(String name, String address, Musician admin, Set<MusicGenre> musicGenres) {
        this.name = name;
        this.address = address;
        this.admin = admin;
        this.musicGenres = musicGenres;
    }

    //Getters

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public Musician getAdmin(){
        return this.admin;
    }

    public Set<BandPosition> getBandPositions(){
        return this.bandPositions;
    }

    public Set<MusicGenre> getMusicGenres(){
        return this.musicGenres;
    }

    public Set<Rating> getRating(){
        return this.ratings;
    }

    //Setters

    public void setAddress(String address){
        this.address = address;
    }

    public void setAdmin(Musician admin){
        this.admin = admin;
    }

    //toString

    public String toString(){
        return this.name;
    }

    //Other

    public void addMusicGenre(MusicGenre musicGenre){
        this.musicGenres.add(musicGenre);
    }

    public void removeMusicGenre(MusicGenre musicGenre){
        this.musicGenres.remove(musicGenre);
    }
}
