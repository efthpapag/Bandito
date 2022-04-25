package com.backend.bandtito.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "musicians", schema = "public")
public class Musician extends User{

    //Columns

    @Column(name = "is_band_member", nullable = true)
    private boolean isBandMember;

    @Column(name = "address", nullable = true)
    private String address;

    @OneToOne(mappedBy = "admin", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_of_band", nullable = true)
    private Band adminOfBand;

    @OneToOne(mappedBy = "musician", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "position", nullable = true)
    private BandPosition bandPosition;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(name = "music_genres_of_musicians", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "music_genre_name"))
    private Set<MusicGenre> musicGenres = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(name = "musician_instuments", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "instument_name"))
    private Set<Instument> instuments = new HashSet<>();
    

    //Constructors

    public Musician() {
        
    }

    public Musician(String username, String firstname, String lastname, String password, String address, Set<Instument> instuments, Set<MusicGenre> musicGenres) {
        super(username, firstname, lastname, password);
        this.address = address;
        this.isBandMember = false;
        this.instuments = instuments;
        this.musicGenres = musicGenres;
    }

    //Getters

    public String getAddress(){
        return this.address;
    }
    
    public boolean getIsBandMember(){
        return this.isBandMember;
    }

    public Band getAdminOfBand(){
        return this.adminOfBand;
    }

    public Set<Instument> getInstuments(){
        return this.instuments;
    }

    public Set<MusicGenre> getMusicGenres(){
        return this.musicGenres;
    }
    
    //Setters

    public void setAddress(String address){
        this.address = address;
    }
    
    public void setIsBandMember(boolean isBandMember){
        this.isBandMember = isBandMember;
    }

    //Other

    public void addInstument(Instument instument){
        this.instuments.add(instument);
    }

    public void addMusicGenre(MusicGenre musicGenre){
        this.musicGenres.add(musicGenre);
    }

    public void removeMusicGenre(MusicGenre musicGenre){
        this.musicGenres.remove(musicGenre);
    }
}