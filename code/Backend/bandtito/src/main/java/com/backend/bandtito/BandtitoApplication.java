package com.backend.bandtito;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import com.backend.bandtito.components.BandManagement;
import com.backend.bandtito.components.InstrumentManagement;
import com.backend.bandtito.components.JobManagement;
import com.backend.bandtito.components.MusicGenreManagement;
import com.backend.bandtito.components.UserManagement;
import com.backend.bandtito.models.Band;
import com.backend.bandtito.models.BandPosition;
import com.backend.bandtito.models.Concert;
import com.backend.bandtito.models.Employer;
import com.backend.bandtito.models.Instrument;
import com.backend.bandtito.models.Job;
import com.backend.bandtito.models.MusicGenre;
import com.backend.bandtito.models.Musician;
import com.backend.bandtito.models.Rating;
import com.backend.bandtito.models.YearsOfExperience;
import com.backend.bandtito.repositories.BandPositionRepository;
import com.backend.bandtito.repositories.BandRepository;
import com.backend.bandtito.repositories.ConcertRepository;
import com.backend.bandtito.repositories.InstrumentRepository;
import com.backend.bandtito.repositories.JobRepository;
import com.backend.bandtito.repositories.MusicGenreRepository;
import com.backend.bandtito.repositories.RatingRepository;
import com.backend.bandtito.repositories.UserRepository;
import com.backend.bandtito.repositories.YearsOfExperienceRepository;

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
    private InstrumentRepository InstrumentRepo;
	@Autowired
    private JobRepository JobRepo;
	@Autowired
    private MusicGenreRepository MusicGenreRepo;
	@Autowired
    private BandRepository BandRepo;
    @Autowired
    private YearsOfExperienceRepository YearsOfExperienceRepo;
    @Autowired
    private RatingRepository RatingRepo;
    @Autowired
    InstrumentManagement instrumentManagement;
    @Autowired
    private BandManagement bandManagement;
    @Autowired
    private JobManagement jobManagement;
    @Autowired
    private MusicGenreManagement musicGenreManagement;
    @Autowired
    private UserManagement userManagement;

	public static void main(String[] args) {
		SpringApplication.run(BandtitoApplication.class, args);
	}

	@PostConstruct
    public void init() throws InterruptedException{

        //test

        //create instuments
        
        //Instrument instument = new Instrument("instument a");
        //InstrumentRepo.save(instument);
        //instument = new Instrument("instument b");
        //InstrumentRepo.save(instument);

        instrumentManagement.createInstument("instument a", "a");
        instrumentManagement.createInstument("instument b", "b");

        System.out.println("create instuments");

        //create music genres
        
        //MusicGenre musicGenre = new MusicGenre("musicGenre a");
        //MusicGenreRepo.save(musicGenre);
        //musicGenre = new MusicGenre("musicGenre b");
        //MusicGenreRepo.save(musicGenre);
        //List<MusicGenre> musicGenresList = Arrays.asList(MusicGenreRepo.findByName("musicGenre a"), MusicGenreRepo.findByName("musicGenre b"));
        //Set<MusicGenre> musicGenresSet = new HashSet<>(musicGenresList);

        musicGenreManagement.createMusicGenre("musicGenre a");
        musicGenreManagement.createMusicGenre("musicGenre b");

        System.out.println("create music genres");

        //Create musicians
		
        //Musician musician = new Musician("musician a", "firstname a", "lastname a", "password a", "address a", 20, musicGenresSet);
        //UserRepo.save(musician);
        //musician = new Musician("musician b", "firstname b", "lastname b", "password b", "address b", 30, musicGenresSet);
        //UserRepo.save(musician);
        //musician = new Musician("musician c", "firstname c", "lastname c", "password c", "address c", 40, musicGenresSet);
        //UserRepo.save(musician);
        //musician = new Musician("musician d", "firstname d", "lastname d", "password d", "address d", 50, musicGenresSet);
        //UserRepo.save(musician);

        userManagement.createMusician("musician a", "firstname a", "lastname a", "password a", "address a", 20, 
        Arrays.asList("instument a"), Arrays.asList(2), Arrays.asList("musicGenre a", "musicGenre b"));
        userManagement.createMusician("musician b", "firstname b", "lastname b", "password b", "address b", 30, 
        Arrays.asList("instument a"), Arrays.asList(2), Arrays.asList("musicGenre a", "musicGenre b"));
        userManagement.createMusician("musician c", "firstname c", "lastname c", "password c", "address c", 40, 
        Arrays.asList("instument a"), Arrays.asList(2), Arrays.asList("musicGenre a", "musicGenre b"));
        userManagement.createMusician("musician d", "firstname d", "lastname d", "password d", "address d", 50, 
        Arrays.asList("instument a"), Arrays.asList(2), Arrays.asList("musicGenre a", "musicGenre b"));

        System.out.println("create musicians");

        //Add instuments to musician
        
        //YearsOfExperience yearsOfExperience = new YearsOfExperience(2, (Musician) UserRepo.findByUsername("musician a"), InstrumentRepo.findByName("instument a"));
        //YearsOfExperienceRepo.save(yearsOfExperience);
        //yearsOfExperience = new YearsOfExperience(6, (Musician) UserRepo.findByUsername("musician a"), InstrumentRepo.findByName("instument b"));
        //YearsOfExperienceRepo.save(yearsOfExperience);

        userManagement.addInstument(6, "musician a", "instrument b");
        
        System.out.println("add instuments");

        //create band
        
        //Band band = new Band("band a", "a", (Musician) UserRepo.findByUsername("musician a"), musicGenresSet, true);
        //BandRepo.save(band);

        bandManagement.createBand("band a", "a", "musician a", Arrays.asList("musicGenre a", "musicGenre b"), true, "a");

        System.out.println("create band");

        //create band positions
		
        //BandPosition bandPosition = new BandPosition(InstrumentRepo.findByName("instument a"), BandRepo.findByName("band a"));
        //BandPositionRepo.save(bandPosition);
        //String bandUuid = bandPosition.getUuid();
        //bandPosition = new BandPosition(InstrumentRepo.findByName("instument b"), BandRepo.findByName("band a"));
        //BandPositionRepo.save(bandPosition);
        
        BandPosition b = bandManagement.createBandPosition("instument a", "band a");
        String bandUuid = b.getUuid();
        bandManagement.createBandPosition("instument b", "band a");
        
        System.out.println("create band positions");
        
        //fill band position
        
        //BandPositionRepo.findByUuid(bandUuid).fillPossition((Musician) UserRepo.findByUsername("musician a"));
        //BandPositionRepo.save(bandPosition);

        bandManagement.fillBandPosition(bandUuid, "musician a");

        System.out.println("fill band position");

        //create employers
        
        //Employer employer = new Employer("employer a", "a", "a", "a");
        //UserRepo.save(employer);
        //employer = new Employer("employer b", "b", "b", "b");
        //UserRepo.save(employer);

        userManagement.createEmployer("employer a", "a", "a", "a");
        userManagement.createEmployer("employer b", "b", "b", "b");

        System.out.println("create employers");

        //create job
        
        //Job job = new Job("job a", "a", (Employer) UserRepo.findByUsername("employer a"));
        //JobRepo.save(job);
        //job = new Job("job b", "b", (Employer) UserRepo.findByUsername("employer a"));
        //JobRepo.save(job);
        
        jobManagement.createJob("job a", "a", "employer a", Arrays.asList(LocalDate.now()), Arrays.asList(Arrays.asList("musicGenre a", "musicGenre b")));
        jobManagement.createJob("job b", "b", "employer a", Arrays.asList(LocalDate.now().plusDays(10)), Arrays.asList(Arrays.asList("musicGenre a", "musicGenre b")));
        
        System.out.println("create job");

        //Create conserts
		
        //Concert concert = new Concert(LocalDate.now(), JobRepo.findByName("job a"), musicGenresSet);
        //Concertepo.save(concert);
        //concert = new Concert(LocalDate.now().plusDays(10), JobRepo.findByName("job a"), musicGenresSet);
        //Concertepo.save(concert);
        //concert = new Concert(LocalDate.now().plusDays(10), JobRepo.findByName("job b"), musicGenresSet);
        //Concertepo.save(concert);
        //String concertUuid = concert.getUuid();

        Concert c = jobManagement.addConsert(LocalDate.now().plusDays(10), "job a", Arrays.asList("musicGenre a", "musicGenre b"));
        String concertUuid = c.getUuid();

        System.out.println("create conserts");
        
        //rate band
        
        //Rating rating = new Rating(5, BandRepo.findByName("band a"), (Employer) UserRepo.findByUsername("employer a"));
        //RatingRepo.save(rating);

        bandManagement.rateBand("employer a", "band a", 5);

        System.out.println("rate band");


        
        //not all results tested only run time errors
        System.out.println("--------------------------------------------");

        System.out.println(UserRepo.findByUsername("musician a").getFirstName());//firstname a
        System.out.println(UserRepo.findByUsername("musician a").getLastName());//lastname a
        System.out.println(UserRepo.findByUsername("musician a").getPassword());//password a
        System.out.println(UserRepo.findByUsername("musician a").getUsername());//musician a

        System.out.println(((Musician) UserRepo.findByUsername("musician a")).getAddress());//address a
        System.out.println(((Musician) UserRepo.findByUsername("musician a")).getIsBandMember());//false
        System.out.println(((Musician) UserRepo.findByUsername("musician a")).getAdminOfBand());//band a
        System.out.println(((Musician) UserRepo.findByUsername("musician a")).getMusicGenres().iterator().next().getName());//musicGenre a


        System.out.println(InstrumentRepo.findByName("instument a").getName());//instument a
        System.out.println(InstrumentRepo.findByName("instument a").getBandPositions().iterator().next().getUuid());//DNKGhOSld0

        System.out.println(MusicGenreRepo.findByName("musicGenre a").getName());//musicGenre a
        System.out.println(MusicGenreRepo.findByName("musicGenre a").getBands().iterator().next().getName());//band a
        System.out.println(MusicGenreRepo.findByName("musicGenre a").getConcerts().iterator().next().getUuid());//OcIUX77U2e
        System.out.println(MusicGenreRepo.findByName("musicGenre a").getMusicians().iterator().next().getUsername());//musician d

        System.out.println(BandRepo.findByName("band a").getAddress());//a
        System.out.println(BandRepo.findByName("band a").getName());//band a
        System.out.println(BandRepo.findByName("band a").getAdmin());//musician a
        System.out.println(BandRepo.findByName("band a").getBandPositions().iterator().next().getInstument());//instument b
        System.out.println(BandRepo.findByName("band a").getMusicGenres().iterator().next().getName());//musicGenre a

        System.out.println(BandPositionRepo.findByUuid(bandUuid).getOccupied());//false
        System.out.println(BandPositionRepo.findByUuid(bandUuid).getUuid());//lf5LDoPGyH
        System.out.println(BandPositionRepo.findByUuid(bandUuid).getBand());//band a
        System.out.println(BandPositionRepo.findByUuid(bandUuid).getInstument());//instument a

        System.out.println(((Employer) UserRepo.findByUsername("employer a")).getJobs().iterator().next().getName());//job a

        System.out.println(Concertepo.findByUuid(concertUuid).getUuid());//N5IFSWYVoZ
        System.out.println(Concertepo.findByUuid(concertUuid).getDate());//2022-05-05
        System.out.println(Concertepo.findByUuid(concertUuid).getJob());//job b
        System.out.println(Concertepo.findByUuid(concertUuid).getMusicGenres().iterator().next().getName());//musicGenre a

        System.out.println(YearsOfExperienceRepo.findByUuid(((Musician) UserRepo.findByUsername("musician a")).getYearsOfExperience().iterator().next().getUuid()).getUuid());//3gYZXkcco3
        System.out.println(YearsOfExperienceRepo.findByUuid(((Musician) UserRepo.findByUsername("musician a")).getYearsOfExperience().iterator().next().getUuid()).getNumberOfYears());//6
        System.out.println(YearsOfExperienceRepo.findByUuid(((Musician) UserRepo.findByUsername("musician a")).getYearsOfExperience().iterator().next().getUuid()).getInstument());//instument a
        System.out.println(YearsOfExperienceRepo.findByUuid(((Musician) UserRepo.findByUsername("musician a")).getYearsOfExperience().iterator().next().getUuid()).getMusician());//musician a
		
        
        System.out.println(RatingRepo.findByUuid(((Employer) UserRepo.findByUsername("employer a")).getRatings().iterator().next().getUuid()).getUuid());//EBW4Ogpd6F
        System.out.println(RatingRepo.findByUuid(((Employer) UserRepo.findByUsername("employer a")).getRatings().iterator().next().getUuid()).getEmployer());//employer a
        System.out.println(RatingRepo.findByUuid(((Employer) UserRepo.findByUsername("employer a")).getRatings().iterator().next().getUuid()).getBand());//band a

		System.out.println("--------------------------------------------");

        BandPosition bandPosition = BandPositionRepo.findByUuid(bandUuid);
        bandPosition.setJoined(LocalDate.now().plusDays(40));
        BandPositionRepo.save(bandPosition);

        bandManagement.emptyPosition(bandUuid);

        System.out.println(((Musician) UserRepo.findByUsername("musician a")).getYearsInBand().toString());

    }
}
