package com.backend.bandtito.utils;

import com.backend.bandtito.models.MusicGenre;

import com.backend.bandtito.repositories.MusicGenreRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class MusicGenreManagement {

	@Autowired
    private MusicGenreRepository MusicGenreRepo;

    //create music genre
    public MusicGenre createMusicGenre(String name){
        MusicGenre musicGenre = new MusicGenre(name);
        MusicGenreRepo.save(musicGenre);
        return musicGenre;
    }

}
