package com.backend.bandtito;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import com.backend.bandtito.models.Band;
import com.backend.bandtito.models.BandPosition;
import com.backend.bandtito.models.Concert;
import com.backend.bandtito.models.Employer;
import com.backend.bandtito.models.Instument;
import com.backend.bandtito.models.Job;
import com.backend.bandtito.models.MusicGenre;
import com.backend.bandtito.models.Musician;
import com.backend.bandtito.repositories.BandPositionRepository;
import com.backend.bandtito.repositories.BandRepository;
import com.backend.bandtito.repositories.ConcertRepository;
import com.backend.bandtito.repositories.InstumentRepository;
import com.backend.bandtito.repositories.JobRepository;
import com.backend.bandtito.repositories.MusicGenreRepository;
import com.backend.bandtito.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BandtitoApplication {

	@Autowired
    private UserRepository UserRepo;
	@Autowired
    private BandPositionRepository BandPositionRepo;
	@Autowired
    private ConcertRepository Concertepo;
	@Autowired
    private InstumentRepository InstumentRepo;
	@Autowired
    private JobRepository JobRepo;
	@Autowired
    private MusicGenreRepository MusicGenreRepo;
	@Autowired
    private BandRepository BandRepo;
	public static void main(String[] args) {
		SpringApplication.run(BandtitoApplication.class, args);
	}

	@PostConstruct
    public void init(){

        //test

        //Create musicians
		/*Musician musician = new Musician("musician a", "firstname a", "lastname a", "password a", "address a");
        UserRepo.save(musician);
        musician = new Musician("musician b", "firstname b", "lastname b", "password b", "address b");
        UserRepo.save(musician);
        musician = new Musician("musician c", "firstname c", "lastname c", "password c", "address c");
        UserRepo.save(musician);
        musician = new Musician("musician d", "firstname d", "lastname d", "password d", "address d");
        UserRepo.save(musician);*/

        //create instuments
        /*Instument instument = new Instument("instument a");
        InstumentRepo.save(instument);
        instument = new Instument("instument b");
        InstumentRepo.save(instument);*/
    
        //create music genres
        /*MusicGenre musicGenre = new MusicGenre("musicGenre a");
        MusicGenreRepo.save(musicGenre);
        musicGenre = new MusicGenre("musicGenre b");
        MusicGenreRepo.save(musicGenre);
        List<MusicGenre> musicGenresList = Arrays.asList(MusicGenreRepo.findByName("musicGenre a"), MusicGenreRepo.findByName("musicGenre b"));
        Set<MusicGenre> musicGenresSet = new HashSet<>(musicGenresList);*/

        //create band
        /*Band band = new Band("band a", "a", (Musician) UserRepo.findByUsername("Musician a"), musicGenresSet);
        BandRepo.save(band);*/

        //create band positions
		/*BandPosition bandPosition = new BandPosition(InstumentRepo.findByName("instument a"), BandRepo.findByName("band a"));
        BandPositionRepo.save(bandPosition);
        String bandUuid = bandPosition.getUuid();
        bandPosition = new BandPosition(InstumentRepo.findByName("instument b"), BandRepo.findByName("band a"));
        BandPositionRepo.save(bandPosition);*/

        //fill band position
        /*BandPositionRepo.findByUuid(bandUuid).fillPossition((Musician) UserRepo.findByUsername("Musician a"));
        BandPositionRepo.save(bandPosition);*/

        //create employers
        /*Employer employer = new Employer("employer a", "a", "a", "a");
        UserRepo.save(employer);
        employer = new Employer("employer b", "b", "b", "b");
        UserRepo.save(employer);*/

        //create job
        /*Job job = new Job("job a", "a", (Employer) UserRepo.findByUsername("employer a"));
        JobRepo.save(job);
        job = new Job("job b", "b", (Employer) UserRepo.findByUsername("employer a"));
        JobRepo.save(job);*/

        //Create conserts
		/*Concert concert = new Concert(LocalDate.now(), JobRepo.findByName("job a"), musicGenresSet);
        Concertepo.save(concert);
        concert = new Concert(LocalDate.now().plusDays(10), JobRepo.findByName("job a"), musicGenresSet);
        Concertepo.save(concert);
        concert = new Concert(LocalDate.now().plusDays(10), JobRepo.findByName("job b"), musicGenresSet);
        Concertepo.save(concert);*/

        /*System.out.println("--------------------------------------------");

        System.out.println(JobRepo.findByName("Job a").toString());
        System.out.println(JobRepo.findByName("Job a").getConcerts().iterator().next().toString());
        System.out.println(Concertepo.findByUuid(JobRepo.findByName("Job a").getConcerts().iterator().next().toString()).getMusicGenres().iterator().next());
		
		System.out.println("--------------------------------------------");
        */
        //System.out.println(((Musician) UserRepo.findByUsername("Musician a")).getAdminOfBand().toString());

		
    }

}
