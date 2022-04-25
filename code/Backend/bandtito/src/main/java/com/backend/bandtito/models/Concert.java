package com.backend.bandtito.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "concerts", schema = "public")
public class Concert {

    //Columns

    @Id
    @Column(name = "concert_uuid", nullable = true)
    private String uuid;

    @Column(name = "date", nullable = true)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "job_name", nullable = false)
    private Job job;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(name = "music_genres_concerts", joinColumns = @JoinColumn(name = "concert_uuid"), inverseJoinColumns = @JoinColumn(name = "music_genre_name"))
    private Set<MusicGenre> musicGenres = new HashSet<>();

    //Constructors

    public Concert() {
        
    }

    public Concert(LocalDate date, Job job, Set<MusicGenre> musicGenres) {

        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();

        this.date = date;
        this.job = job;
        this.musicGenres = musicGenres;
        this.uuid = random.ints(leftLimit, rightLimit + 1)
        .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
        .limit(targetStringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
    }

    //Getters

    public LocalDate getDate(){
        return this.date;
    }

    public Job getJob(){
        return this.job;
    }

    public Set<MusicGenre> getMusicGenres(){
        return this.musicGenres;
    }

    public String getUuid(){
        return this.uuid;
    }

    //toString

    public String toString(){
        return this.uuid;
    }
}
