package com.backend.bandtito.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.backend.bandtito.models.Employer;
import com.backend.bandtito.models.Instument;
import com.backend.bandtito.models.MusicGenre;
import com.backend.bandtito.models.Musician;
import com.backend.bandtito.repositories.InstumentRepository;
import com.backend.bandtito.repositories.MusicGenreRepository;
import com.backend.bandtito.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class UserManagement {

    @Autowired
    private UserRepository UserRepo;
	@Autowired
    private InstumentRepository InstumentRepo;
	@Autowired
    private MusicGenreRepository MusicGenreRepo;

    //Create musician
    public Musician createMusician(String username, String firstname, String lastname, String password, String address, List<String> listOfInstuments, List<String> listOfMusicGenres){
        List<Instument> instumentsList = new ArrayList<Instument>();
        for (int i = 0; i <= listOfInstuments.size(); i++){
            instumentsList.add(InstumentRepo.findByName(listOfInstuments.get(i)));
        }
        Set<Instument> instumentsSet = new HashSet<>(instumentsList);

        List<MusicGenre> musicGenresList = new ArrayList<MusicGenre>();
        for (int i = 0; i <= listOfMusicGenres.size(); i++){
            musicGenresList.add(MusicGenreRepo.findByName(listOfMusicGenres.get(i)));
        }
        Set<MusicGenre> musicGenresSet = new HashSet<>(musicGenresList);

        Musician musician = new Musician(username, firstname, lastname, password, address, instumentsSet, musicGenresSet);
        UserRepo.save(musician);
        return musician;
    }

    //create employer
    public Employer creatEmployer(String username, String firstname, String lastname, String password){
        Employer employer = new Employer(username, firstname, lastname, password);
        UserRepo.save(employer);
        return employer;
    }
}
