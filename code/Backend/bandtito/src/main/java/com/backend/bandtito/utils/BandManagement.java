package com.backend.bandtito.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.backend.bandtito.models.Band;
import com.backend.bandtito.models.BandPosition;
import com.backend.bandtito.models.MusicGenre;
import com.backend.bandtito.models.Musician;
import com.backend.bandtito.repositories.BandPositionRepository;
import com.backend.bandtito.repositories.BandRepository;
import com.backend.bandtito.repositories.InstumentRepository;
import com.backend.bandtito.repositories.MusicGenreRepository;
import com.backend.bandtito.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class BandManagement{

    @Autowired
    private UserRepository UserRepo;
	@Autowired
    private BandPositionRepository BandPositionRepo;
	@Autowired
    private InstumentRepository InstumentRepo;
	@Autowired
    private MusicGenreRepository MusicGenreRepo;
	@Autowired
    private BandRepository BandRepo;

    //create band
    public Band createBand(String name, String address, String musician, List<String> listOfMusicGenres){

        List<MusicGenre> musicGenresList = new ArrayList<MusicGenre>();
        for (int i = 0; i <= listOfMusicGenres.size(); i++){
            musicGenresList.add(MusicGenreRepo.findByName(listOfMusicGenres.get(i)));
        }
        Set<MusicGenre> musicGenresSet = new HashSet<>(musicGenresList);

        Band band = new Band("band a", "a", (Musician) UserRepo.findByUsername(musician), musicGenresSet);
        BandRepo.save(band);
        return band;
    }
    

    //create band position
    public BandPosition createBandPosition(String instument, String band){
        BandPosition bandPosition = new BandPosition(InstumentRepo.findByName(instument), BandRepo.findByName(band));
        BandPositionRepo.save(bandPosition);
        return bandPosition;
    }

    //fill band position
    public BandPosition fillBandPosition(String bandUuid, String musician){
        BandPosition bandPosition = BandPositionRepo.findByUuid(bandUuid);
        bandPosition.fillPossition((Musician) UserRepo.findByUsername(musician));
        BandPositionRepo.save(bandPosition);
        return bandPosition;
    }
}