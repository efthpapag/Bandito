package com.backend.bandtito.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicGenresInitializer {

    @Autowired
    private MusicGenreManagement musicGenreManagement;

    public void init(){
        musicGenreManagement.createMusicGenre("Rock");
        musicGenreManagement.createMusicGenre("Jazz");
        musicGenreManagement.createMusicGenre("Country");
        musicGenreManagement.createMusicGenre("Pop");
        musicGenreManagement.createMusicGenre("Blues");
        musicGenreManagement.createMusicGenre("Soul");
        musicGenreManagement.createMusicGenre("Metal");
        musicGenreManagement.createMusicGenre("Classical");
        musicGenreManagement.createMusicGenre("Folk");
        musicGenreManagement.createMusicGenre("R&B");
        musicGenreManagement.createMusicGenre("Punk");
        musicGenreManagement.createMusicGenre("Disco");

        System.out.println("musicgenre");

    }
    
}
