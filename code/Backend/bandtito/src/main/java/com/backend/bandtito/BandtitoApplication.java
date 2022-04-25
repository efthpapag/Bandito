package com.backend.bandtito;

import java.time.LocalDate;
import java.util.ArrayList;
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

        //create instuments
        Instument instument = new Instument("instument a");
        InstumentRepo.save(instument);
        instument = new Instument("instument b");
        InstumentRepo.save(instument);
        List<Instument> instumentsList = Arrays.asList(InstumentRepo.findByName("instument a"), InstumentRepo.findByName("instument b"));
        Set<Instument> instumentsSet = new HashSet<>(instumentsList);

        //create music genres
        MusicGenre musicGenre = new MusicGenre("musicGenre a");
        MusicGenreRepo.save(musicGenre);
        musicGenre = new MusicGenre("musicGenre b");
        MusicGenreRepo.save(musicGenre);
        List<MusicGenre> musicGenresList = Arrays.asList(MusicGenreRepo.findByName("musicGenre a"), MusicGenreRepo.findByName("musicGenre b"));
        Set<MusicGenre> musicGenresSet = new HashSet<>(musicGenresList);
        
        //Create musicians
		Musician musician = new Musician("musician a", "firstname a", "lastname a", "password a", "address a", instumentsSet, musicGenresSet);
        UserRepo.save(musician);
        musician = new Musician("musician b", "firstname b", "lastname b", "password b", "address b", instumentsSet, musicGenresSet);
        UserRepo.save(musician);
        musician = new Musician("musician c", "firstname c", "lastname c", "password c", "address c", instumentsSet, musicGenresSet);
        UserRepo.save(musician);
        musician = new Musician("musician d", "firstname d", "lastname d", "password d", "address d", instumentsSet, musicGenresSet);
        UserRepo.save(musician);

        //create band
        Band band = new Band("band a", "a", (Musician) UserRepo.findByUsername("Musician a"), musicGenresSet);
        BandRepo.save(band);

        //create band positions
		BandPosition bandPosition = new BandPosition(InstumentRepo.findByName("instument a"), BandRepo.findByName("band a"));
        BandPositionRepo.save(bandPosition);
        String bandUuid = bandPosition.getUuid();
        bandPosition = new BandPosition(InstumentRepo.findByName("instument b"), BandRepo.findByName("band a"));
        BandPositionRepo.save(bandPosition);

        //fill band position
        BandPositionRepo.findByUuid(bandUuid).fillPossition((Musician) UserRepo.findByUsername("Musician a"));
        BandPositionRepo.save(bandPosition);

        //create employers
        Employer employer = new Employer("employer a", "a", "a", "a");
        UserRepo.save(employer);
        employer = new Employer("employer b", "b", "b", "b");
        UserRepo.save(employer);

        //create job
        Job job = new Job("job a", "a", (Employer) UserRepo.findByUsername("employer a"));
        JobRepo.save(job);
        job = new Job("job b", "b", (Employer) UserRepo.findByUsername("employer a"));
        JobRepo.save(job);

        //Create conserts
		Concert concert = new Concert(LocalDate.now(), JobRepo.findByName("job a"), musicGenresSet);
        Concertepo.save(concert);
        concert = new Concert(LocalDate.now().plusDays(10), JobRepo.findByName("job a"), musicGenresSet);
        Concertepo.save(concert);
        concert = new Concert(LocalDate.now().plusDays(10), JobRepo.findByName("job b"), musicGenresSet);
        Concertepo.save(concert);
        String concersUuid = concert.getUuid();

        //not all results tested only run time errors
        System.out.println("--------------------------------------------");

        System.out.println(UserRepo.findByUsername("musician a").getFirstName());//firstname a
        System.out.println(UserRepo.findByUsername("musician a").getLastName());//lastname a
        System.out.println(UserRepo.findByUsername("musician a").getPassword());//password a
        System.out.println(UserRepo.findByUsername("musician a").getUsername());//musician a

        System.out.println(((Musician) UserRepo.findByUsername("musician a")).getAddress());//address a
        System.out.println(((Musician) UserRepo.findByUsername("musician a")).getIsBandMember());//false
        System.out.println(((Musician) UserRepo.findByUsername("musician a")).getAdminOfBand());//null
        System.out.println(((Musician) UserRepo.findByUsername("musician a")).getInstuments().iterator().next().getName());//instument b
        System.out.println(((Musician) UserRepo.findByUsername("musician a")).getMusicGenres().iterator().next().getName());//musicGenre a


        System.out.println(InstumentRepo.findByName("instument a").getName());//instument a
        System.out.println(InstumentRepo.findByName("instument a").getBandPositions().iterator().next().getUuid());//DNKGhOSld0
        System.out.println(InstumentRepo.findByName("instument a").getMusicians().iterator().next().getUsername());//musician c

        System.out.println(MusicGenreRepo.findByName("musicGenre a").getName());//musicGenre a
        System.out.println(MusicGenreRepo.findByName("musicGenre a").getBands().iterator().next().getName());//band a
        System.out.println(MusicGenreRepo.findByName("musicGenre a").getConcerts().iterator().next().getUuid());//OcIUX77U2e
        System.out.println(MusicGenreRepo.findByName("musicGenre a").getMusicians().iterator().next().getUsername());//musician d

        System.out.println(BandRepo.findByName("band a").getAddress());//a
        System.out.println(BandRepo.findByName("band a").getName());//band a
        System.out.println(BandRepo.findByName("band a").getAdmin());//null
        System.out.println(BandRepo.findByName("band a").getBandPositions().iterator().next().getInstument());//instument b
        System.out.println(BandRepo.findByName("band a").getMusicGenres().iterator().next().getName());//musicGenre b

        System.out.println(BandPositionRepo.findByUuid(bandUuid).getOccupied());//false
        System.out.println(BandPositionRepo.findByUuid(bandUuid).getUuid());//lf5LDoPGyH
        System.out.println(BandPositionRepo.findByUuid(bandUuid).getBand());//band a
        System.out.println(BandPositionRepo.findByUuid(bandUuid).getInstument());//instument a

        System.out.println(((Employer) UserRepo.findByUsername("employer a")).getJobs().iterator().next().getName());//job a

        System.out.println(Concertepo.findByUuid(concersUuid).getUuid());//N5IFSWYVoZ
        System.out.println(Concertepo.findByUuid(concersUuid).getDate());//2022-05-05
        System.out.println(Concertepo.findByUuid(concersUuid).getJob());//job b
        System.out.println(Concertepo.findByUuid(concersUuid).getMusicGenres().iterator().next().getName());//musicGenre a
		
		System.out.println("--------------------------------------------");
    }

    //create instument
    public Instument createInstument(String name){
        Instument instument = new Instument(name);
        InstumentRepo.save(instument);
        return instument;
    }

    //create music genre
    public MusicGenre createMusicGenre(String name){
        MusicGenre musicGenre = new MusicGenre(name);
        MusicGenreRepo.save(musicGenre);
        return musicGenre;
    }

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

    //create employer
    public Employer creatEmployer(String username, String firstname, String lastname, String password){
        Employer employer = new Employer(username, firstname, lastname, password);
        UserRepo.save(employer);
        return employer;
    }

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
