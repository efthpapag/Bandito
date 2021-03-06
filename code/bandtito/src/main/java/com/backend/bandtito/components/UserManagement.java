package com.backend.bandtito.components;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.backend.bandtito.models.Employer;
import com.backend.bandtito.models.MusicGenre;
import com.backend.bandtito.models.Musician;
import com.backend.bandtito.models.User;
import com.backend.bandtito.models.YearsOfExperience;
import com.backend.bandtito.repositories.InstrumentRepository;
import com.backend.bandtito.repositories.MusicGenreRepository;
import com.backend.bandtito.repositories.UserRepository;
import com.backend.bandtito.repositories.YearsOfExperienceRepository;

import org.springframework.beans.factory.annotation.Autowired;
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

    //Find if user exists
    public Boolean findUser(String username){
        if(UserRepo.findByUsername(username) == null){
            return false;
        }
        return true;
    }

    //Log in user
    public User logInUser(String username, String password){

        User user = UserRepo.findByUsername(username);
        if(user != null){
            if(user.getPassword().equals(/*passwordEncoder.encode(*/password/*)*/)){
                return user;
            }
        }
        return null;
    }

    //Create musician
    public Musician createMusician(String username, String firstname, String lastname, String password, String address, int age, List<String> listOfInstuments, List<Integer> listOfYears, List<String> listOfMusicGenres, String profilePic){

        List<MusicGenre> musicGenresList = new ArrayList<MusicGenre>();
        for (int i = 0; i < listOfMusicGenres.size(); i++){
            musicGenresList.add(MusicGenreRepo.findByName(listOfMusicGenres.get(i)));
        }
        Set<MusicGenre> musicGenresSet = new HashSet<>(musicGenresList);

        Musician musician = new Musician(username, firstname, lastname,  /*passwordEncoder.encode(*/password/*)*/, address, age, musicGenresSet, profilePic);
        UserRepo.save(musician);

        for (int i = 0; i < listOfInstuments.size(); i++){
            this.addInstument(listOfYears.get(i), musician.getUsername(), listOfInstuments.get(i));
        }

        return musician;
    }

    //edit musician
    public Musician editMusician(String username, String firstname, String lastname, String password, String address, int age /*, List<String> listOfInstuments, List<Integer> listOfYears, List<String> listOfMusicGenres*/, String profilePic){

        /*List<MusicGenre> musicGenresList = new ArrayList<MusicGenre>();
        for (int i = 0; i < listOfMusicGenres.size(); i++){
            musicGenresList.add(MusicGenreRepo.findByName(listOfMusicGenres.get(i)));
        }
        Set<MusicGenre> musicGenresSet = new HashSet<>(musicGenresList);
        */

        Musician musician = (Musician) UserRepo.findByUsername(username);
        musician.setAddress(address);
        //musician.setMusicGenres(musicGenresSet);
        musician.setFirstName(firstname);
        musician.setLastName(lastname);
        musician.setPassword(/*passwordEncoder.encode(*/password/*)*/);
        musician.setProfilePic(profilePic);

        /*for (int i = 0; i < listOfInstuments.size(); i++){
            this.addInstument(listOfYears.get(i), musician.getUsername(), listOfInstuments.get(i));
        }*/
        
        UserRepo.save(musician);
        return musician;
    }

    //add instument
    public YearsOfExperience addInstument(int years, String musician, String instrument){

        YearsOfExperience yearsOfExperience = new YearsOfExperience(years, (Musician) UserRepo.findByUsername(musician), InstrumentRepo.findByName(instrument));
        YearsOfExperienceRepo.save(yearsOfExperience);
        return yearsOfExperience;
    }

    //remove instument
    public void removeInstument(String uuid){

        YearsOfExperience yearsOfExperience = YearsOfExperienceRepo.findByUuid(uuid);
        YearsOfExperienceRepo.delete(yearsOfExperience);
    }

    //add music genre
    public void addMusicGenre(String musician, String genre){
        Musician m = (Musician) UserRepo.findByUsername(musician);
        m.addMusicGenre(MusicGenreRepo.findByName(genre));
        UserRepo.save(m);
    }

    //remove music genre
    public void removeMusicGenre(String musician, String genre){
        Musician m = (Musician) UserRepo.findByUsername(musician);
        m.removeMusicGenre(MusicGenreRepo.findByName(genre));
        UserRepo.save(m);
    }

    //create employer
    public Employer createEmployer(String username, String firstname, String lastname, String password, String profilePic){
        //System.out.println("created");
        Employer employer = new Employer(username, firstname, lastname, /*passwordEncoder.encode(*/password/*)*/, profilePic);
        UserRepo.save(employer);
        return employer;
    }

    //edit emplayer
    public Employer editEmployer(String username, String firstname, String lastname, String password){

        Employer employer = (Employer) UserRepo.findByUsername(username);
        employer.setFirstName(firstname);
        employer.setLastName(lastname);
        employer.setPassword(/*passwordEncoder.encode(*/password/*)*/);
        UserRepo.save(employer);
        return employer;
    }
}