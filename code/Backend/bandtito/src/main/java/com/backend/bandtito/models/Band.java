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
import java.util.Iterator;
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

    @Column(name = "for_hire", nullable = true)
    private boolean forHire;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "number_of_positions", nullable = true)
    private int numberOfPositions;

    @Column(name = "is_full", nullable = false)
    private boolean isFull;

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

    public Band(String name, String address, Musician admin, Set<MusicGenre> musicGenres, Boolean forHire) {
        this.name = name;
        this.address = address;
        this.admin = admin;
        this.musicGenres = musicGenres;
        this.isFull = false;
        this.forHire = forHire;
        this.numberOfPositions = 0;
    }

    //Getters

    public String getName(){
        return this.name;
    }

    public boolean getForHire(){
        return this.forHire;
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

    public void setForHire(Boolean forHire){
        this.forHire = forHire;
    }

    public void setMusicGenres(Set<MusicGenre> musicGenres){
        this.musicGenres = musicGenres;
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

    public void updateNumberOfPositions(){
        this.numberOfPositions = bandPositions.size();
    }

    public void updateFull(){

        Iterator<BandPosition> bandPositionsIterator = bandPositions.iterator();
        boolean isFull = true;

        while(bandPositionsIterator.hasNext()) {
            if(!bandPositionsIterator.next().getOccupied()){
                isFull = false;
            }
         }

        if(isFull){
           this.isFull = true;
        }
    }
}