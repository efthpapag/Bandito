package com.backend.bandtito.components;

import com.backend.bandtito.models.MusicGenre;

import com.backend.bandtito.repositories.MusicGenreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
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
