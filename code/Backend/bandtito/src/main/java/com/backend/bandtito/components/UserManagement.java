package com.backend.bandtito.components;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.backend.bandtito.models.Employer;
import com.backend.bandtito.models.MusicGenre;
import com.backend.bandtito.models.Musician;
import com.backend.bandtito.models.YearsOfExperience;
import com.backend.bandtito.repositories.InstrumentRepository;
import com.backend.bandtito.repositories.MusicGenreRepository;
import com.backend.bandtito.repositories.UserRepository;
import com.backend.bandtito.repositories.YearsOfExperienceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserManagement {

    @Autowired
    private UserRepository UserRepo;
	@Autowired
    private InstrumentRepository InstrumentRepo;
	@Autowired
    private MusicGenreRepository MusicGenreRepo;
    @Autowired
    private YearsOfExperienceRepository YearsOfExperienceRepo;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    //Create musician
    public Musician createMusician(String username, String firstname, String lastname, String password, String address, int age, List<String> listOfInstuments, List<Integer> listOfYears, List<String> listOfMusicGenres){

        List<MusicGenre> musicGenresList = new ArrayList<MusicGenre>();
        for (int i = 0; i < listOfMusicGenres.size(); i++){
            musicGenresList.add(MusicGenreRepo.findByName(listOfMusicGenres.get(i)));
        }
        Set<MusicGenre> musicGenresSet = new HashSet<>(musicGenresList);

        Musician musician = new Musician(username, firstname, lastname,  passwordEncoder.encode(password), address, age, musicGenresSet);
        UserRepo.save(musician);

        for (int i = 0; i < listOfInstuments.size(); i++){
            this.addInstument(listOfYears.get(i), musician.getUsername(), listOfInstuments.get(i));
        }

        return musician;
    }

    //edit musician
    public Musician editMusician(String username, String firstname, String lastname, String password, String address, int age, List<String> listOfInstuments, List<String> listOfMusicGenres){

        List<MusicGenre> musicGenresList = new ArrayList<MusicGenre>();
        for (int i = 0; i < listOfMusicGenres.size(); i++){
            musicGenresList.add(MusicGenreRepo.findByName(listOfMusicGenres.get(i)));
        }
        Set<MusicGenre> musicGenresSet = new HashSet<>(musicGenresList);

        Musician musician = (Musician) UserRepo.findByUsername(username);
        musician.setAddress(address);
        musician.setMusicGenres(musicGenresSet);
        musician.setFirstName(firstname);
        musician.setLastName(lastname);
        musician.setPassword(passwordEncoder.encode(password));
        
        UserRepo.save(musician);
        return musician;
    }

    //add instument
    public YearsOfExperience addInstument(int years, String musician, String instrument){

        YearsOfExperience yearsOfExperience = new YearsOfExperience(years, (Musician) UserRepo.findByUsername(musician), InstrumentRepo.findByName(instrument));
        YearsOfExperienceRepo.save(yearsOfExperience);
        return yearsOfExperience;
    }

    //add music genre
    public void addMusicGenre(String musician, String genre){
        Musician m = (Musician) UserRepo.findByUsername(musician);
        m.addMusicGenre(MusicGenreRepo.findByName(genre));
        UserRepo.save(m);
    }

    //create employer
    public Employer createEmployer(String username, String firstname, String lastname, String password){
        Employer employer = new Employer(username, firstname, lastname, passwordEncoder.encode(password));
        UserRepo.save(employer);
        return employer;
    }

    //edit emplayer
    public Employer editEmployer(String username, String firstname, String lastname, String password){

        Employer employer = (Employer) UserRepo.findByUsername(username);
        employer.setFirstName(firstname);
        employer.setLastName(lastname);
        employer.setPassword(passwordEncoder.encode(password));
        UserRepo.save(employer);
        return employer;
    }
}
