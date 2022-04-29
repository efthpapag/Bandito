package com.backend.bandtito.components;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.backend.bandtito.models.Band;
import com.backend.bandtito.models.BandPosition;
import com.backend.bandtito.models.Employer;
import com.backend.bandtito.models.MusicGenre;
import com.backend.bandtito.models.Musician;
import com.backend.bandtito.models.Rating;
import com.backend.bandtito.repositories.BandPositionRepository;
import com.backend.bandtito.repositories.BandRepository;
import com.backend.bandtito.repositories.InstrumentRepository;
import com.backend.bandtito.repositories.MusicGenreRepository;
import com.backend.bandtito.repositories.RatingRepository;
import com.backend.bandtito.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BandManagement{

    @Autowired
    private UserRepository UserRepo;
	@Autowired
    private BandPositionRepository BandPositionRepo;
	@Autowired
    private InstrumentRepository InstrumentRepo;
	@Autowired
    private MusicGenreRepository MusicGenreRepo;
	@Autowired
    private BandRepository BandRepo;
    @Autowired
    private RatingRepository RatingRepo;

    //create band
    public Band createBand(String name, String address, String musician, List<String> listOfMusicGenres, boolean forHire){

        List<MusicGenre> musicGenresList = new ArrayList<MusicGenre>();
        for (int i = 0; i < listOfMusicGenres.size(); i++){
            musicGenresList.add(MusicGenreRepo.findByName(listOfMusicGenres.get(i)));
        }
        Set<MusicGenre> musicGenresSet = new HashSet<>(musicGenresList);

        Band band = new Band(name, address, (Musician) UserRepo.findByUsername(musician), musicGenresSet, forHire);
        BandRepo.save(band);
        return band;
    }

    //edit band
    public Band editBand(String name, String address, String musician, List<String> listOfMusicGenres, boolean forHire){

        List<MusicGenre> musicGenresList = new ArrayList<MusicGenre>();
        for (int i = 0; i < listOfMusicGenres.size(); i++){
            musicGenresList.add(MusicGenreRepo.findByName(listOfMusicGenres.get(i)));
        }
        Set<MusicGenre> musicGenresSet = new HashSet<>(musicGenresList);

        Band band = BandRepo.findByName(name);
        band.setAddress(address);
        band.setMusicGenres(musicGenresSet);
        band.setForHire(forHire);
        
        BandRepo.save(band);
        return band;
    }
    
    //create band position
    public BandPosition createBandPosition(String instrument, String band){
        BandPosition bandPosition = new BandPosition(InstrumentRepo.findByName(instrument), BandRepo.findByName(band));
        BandPositionRepo.save(bandPosition);
        Band b = BandRepo.findByName(bandPosition.getBand().getName());
        b.updateNumberOfPositions();
        b.updateFull();
        BandRepo.save(b);
        return bandPosition;
    }

    //fill band position
    public BandPosition fillBandPosition(String bandPositionUuid, String musician){
        BandPosition bandPosition = BandPositionRepo.findByUuid(bandPositionUuid);
        bandPosition.fillPossition((Musician) UserRepo.findByUsername(musician));
        BandPositionRepo.save(bandPosition);
        Band band = BandRepo.findByName(bandPosition.getBand().getName());
        band.updateFull();
        BandRepo.save(band);
        return bandPosition;
    }

    //rate band
    public Rating rateBand(String employer, String band, int rating){

        Rating r = new Rating(rating, BandRepo.findByName(band), (Employer) UserRepo.findByUsername(employer));
        RatingRepo.save(r);
        return r;
    }

    //delete band possition
    public void deleteBandPossition(String uuid){
        Band band = BandRepo.findByName(BandPositionRepo.findByUuid(uuid).getBand().getName());
        BandPositionRepo.delete(BandPositionRepo.findByUuid(uuid));
        band.updateNumberOfPositions();
        band.updateFull();
        BandRepo.save(band);
    }

    //delete band
    public void deleteBand(String name){

        Iterator<BandPosition> bandPositionsIterator = BandRepo.findByName(name).getBandPositions().iterator();

        while(bandPositionsIterator.hasNext()) {
            BandPositionRepo.delete(bandPositionsIterator.next());
        }

        BandRepo.delete(BandRepo.findByName(name));
    }
}