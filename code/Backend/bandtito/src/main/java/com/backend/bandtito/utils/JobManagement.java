package com.backend.bandtito.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.backend.bandtito.models.Concert;
import com.backend.bandtito.models.Employer;
import com.backend.bandtito.models.Job;
import com.backend.bandtito.models.MusicGenre;
import com.backend.bandtito.repositories.ConcertRepository;
import com.backend.bandtito.repositories.JobRepository;
import com.backend.bandtito.repositories.MusicGenreRepository;
import com.backend.bandtito.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class JobManagement {

    @Autowired
    private UserRepository UserRepo;
	@Autowired
    private ConcertRepository Concertepo;
	@Autowired
    private JobRepository JobRepo;
	@Autowired
    private MusicGenreRepository MusicGenreRepo;

    //create job
    public Job createJob(String name, String address, String employer){
        Job job = new Job(name, address, (Employer) UserRepo.findByUsername(employer));
        JobRepo.save(job);
        return job;
    }

    //Create consert
    public Concert createConsert(LocalDate date, String job, List<String> listOfMusicGenres){
        List<MusicGenre> musicGenresList = new ArrayList<MusicGenre>();
        for (int i = 0; i <= listOfMusicGenres.size(); i++){
            musicGenresList.add(MusicGenreRepo.findByName(listOfMusicGenres.get(i)));
        }
        Set<MusicGenre> musicGenresSet = new HashSet<>(musicGenresList);
        Concert concert = new Concert(LocalDate.now(), JobRepo.findByName("job a"), musicGenresSet);
        Concertepo.save(concert);
        return concert;
    }

}
