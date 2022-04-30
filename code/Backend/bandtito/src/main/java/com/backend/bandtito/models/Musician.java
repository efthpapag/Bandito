package com.backend.bandtito.models;

import java.time.Period;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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

    @Column(name = "years_in_band", nullable = true)
    private Period yearsInBand;

    @Column(name = "age", nullable = true)
    private int age;

    @OneToOne(mappedBy = "admin", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_of_band", nullable = true)
    private Band adminOfBand;

    @OneToOne(mappedBy = "musician", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "position", nullable = true)
    private BandPosition bandPosition;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(name = "music_genres_of_musicians", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "music_genre_name"))
    private Set<MusicGenre> musicGenres = new HashSet<>();

    @OneToMany(mappedBy = "musician", fetch = FetchType.EAGER,
    cascade = CascadeType.ALL)
    private Set<YearsOfExperience> yearsOfExperience;
    

    //Constructors

    public Musician() {
        
    }

    public Musician(String username, String firstname, String lastname, String password, String address, int age, Set<MusicGenre> musicGenres) {
        super(username, firstname, lastname, password);
        this.address = address;
        this.isBandMember = false;
        this.age = age;
        this.musicGenres = musicGenres;
        this.yearsInBand = Period.ofDays(0);
    }

    //Getters

    public int getAge(){
        return this.age;
    }

    public String getAddress(){
        return this.address;
    }
    
    public boolean getIsBandMember(){
        return this.isBandMember;
    }

    public Band getAdminOfBand(){
        return this.adminOfBand;
    }

    public Period getYearsInBand(){
        return this.yearsInBand;
    }

    public Set<MusicGenre> getMusicGenres(){
        return this.musicGenres;
    }

    public Set<YearsOfExperience> getYearsOfExperience(){
        return this.yearsOfExperience;
    }
    
    //Setters

    public void setAddress(String address){
        this.address = address;
    }
    
    public void setIsBandMember(boolean isBandMember){
        this.isBandMember = isBandMember;
    }

    public void setMusicGenres(Set<MusicGenre> musicGenres){
        this.musicGenres = musicGenres;
    }

    public void setYearsInBand(Period yearsInBand){
        this.yearsInBand = yearsInBand;
    }

    //Other

    public void addMusicGenre(MusicGenre musicGenre){
        this.musicGenres.add(musicGenre);
    }

    public void removeMusicGenre(MusicGenre musicGenre){
        this.musicGenres.remove(musicGenre);
    }
}