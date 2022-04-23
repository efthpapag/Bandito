package com.backend.bandtito;

import java.time.LocalDate;

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
		Musician musician = new Musician("Musician a", "a", "a", "a", "a");
        UserRepo.save(musician);
        musician = new Musician("Musician b", "b", "b", "b", "b");
        UserRepo.save(musician);
        musician = new Musician("Musician c", "c", "c", "c", "c");
        UserRepo.save(musician);
        musician = new Musician("Musician d", "d", "d", "d", "d");
        UserRepo.save(musician);

        //Create instuments
        Instument instument = new Instument("Instument a");
        InstumentRepo.save(instument);
        instument = new Instument("Instument b");
        InstumentRepo.save(instument);

		//create band
        Band band = new Band("band a", "a", (Musician) UserRepo.findByUsername("Musician a"));
        BandRepo.save(band);

        //create band positions
		BandPosition bandPosition = new BandPosition("bandPosition a", instument);
        BandPositionRepo.save(bandPosition);
        bandPosition = new BandPosition("bandPosition b", instument);
        BandPositionRepo.save(bandPosition);

        //fill band position
        Musician musician2 = (Musician) UserRepo.findByUsername("Musician b");
        bandPosition.fillPossition(musician2);
        BandPositionRepo.save(bandPosition);

        //create employers
        Employer employer = new Employer("Employer a", "a", "a", "a");
        UserRepo.save(employer);
        employer = new Employer("Employer b", "b", "b", "b");
        UserRepo.save(employer);

        //create job
        Job job = new Job("Job a", "a", employer);
        JobRepo.save(job);
        job = new Job("Job b", "b", employer);
        JobRepo.save(job);

        //Create conserts
		Concert concert = new Concert(LocalDate.now(), job);
        Concertepo.save(concert);
        concert = new Concert(LocalDate.now().plusDays(10), job);
        Concertepo.save(concert);

		
		
		//MusicGenre musicGenre = new MusicGenre("musicGenre a");
        //MusicGenreRepo.save(musicGenre);

        //System.out.println(((Musician) UserRepo.findByUsername("Musician a")).getAdminOfBand().toString());

		
    }

}
