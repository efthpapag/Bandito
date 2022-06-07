package com.backend.bandtito;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.persistence.PostLoad;
import javax.persistence.PostUpdate;

import com.backend.bandtito.components.BandInitializer;
import com.backend.bandtito.components.BandManagement;
import com.backend.bandtito.components.InstrumentInitializer;
import com.backend.bandtito.components.InstrumentManagement;
import com.backend.bandtito.components.JobManagement;
import com.backend.bandtito.components.MusicGenreManagement;
import com.backend.bandtito.components.MusicGenresInitializer;
import com.backend.bandtito.components.MusiciansInitializer;
import com.backend.bandtito.components.SearchBandAsEmployerManagement;
import com.backend.bandtito.components.SearchBandPositionAsMusicianManagement;
import com.backend.bandtito.components.SearchMusicianManagement;
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
import org.springframework.web.bind.annotation.PostMapping;

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
    @Autowired
    private InstrumentInitializer instrumentInitializer;
    @Autowired
    private MusicGenresInitializer musicGenresInitializer;
    @Autowired
    private MusiciansInitializer musiciansInitializer;
    @Autowired
    private BandInitializer bandInitializer;
    @Autowired
    private SearchMusicianManagement searchMusicianManagement;
    @Autowired
    private SearchBandAsEmployerManagement searchBandAsEmployerManagement;
    @Autowired
    private SearchBandPositionAsMusicianManagement searchBandPositionAsMusicianManagement;

	public static void main(String[] args) throws ClassNotFoundException, InterruptedException, IOException {
		SpringApplication.run(BandtitoApplication.class, args);
	}

	@PostConstruct
    public void init() throws InterruptedException, IOException, ClassNotFoundException{

        //userManagement.createEmployer("employer c", "a", "a", "a", "a");
        //userManagement.createEmployer("employer d", "a", "a", "a", "a");
        //userManagement.createEmployer("employer f", "a", "a", "a", "a");
        //userManagement.createEmployer("employer g", "a", "a", "a", "a");


        /*instrumentInitializer.init();
        System.out.println("--------------------------------------------");
        musicGenresInitializer.init();
        System.out.println("--------------------------------------------");
        musiciansInitializer.init();
        System.out.println("--------------------------------------------");
        bandInitializer.init();
        System.out.println("--------------------------------------------");*/
        

        //test

        //create instuments
        
        //Instrument instument = new Instrument("instument a");
        //InstrumentRepo.save(instument);
        //instument = new Instrument("instument b");
        //InstrumentRepo.save(instument);

        //instrumentManagement.createInstument("instument a", "a");
        //instrumentManagement.createInstument("instument b", "b");

        //System.out.println("create instuments");

        //create music genres
        
        //MusicGenre musicGenre = new MusicGenre("musicGenre a");
        //MusicGenreRepo.save(musicGenre);
        //musicGenre = new MusicGenre("musicGenre b");
        //MusicGenreRepo.save(musicGenre);
        //List<MusicGenre> musicGenresList = Arrays.asList(MusicGenreRepo.findByName("musicGenre a"), MusicGenreRepo.findByName("musicGenre b"));
        //Set<MusicGenre> musicGenresSet = new HashSet<>(musicGenresList);

        //musicGenreManagement.createMusicGenre("musicGenre a");
        //musicGenreManagement.createMusicGenre("musicGenre b");

        //System.out.println("create music genres");

        //Create musicians
		
        //Musician musician = new Musician("musician a", "firstname a", "lastname a", "password a", "address a", 20, musicGenresSet);
        //UserRepo.save(musician);
        //musician = new Musician("musician b", "firstname b", "lastname b", "password b", "address b", 30, musicGenresSet);
        //UserRepo.save(musician);
        //musician = new Musician("musician c", "firstname c", "lastname c", "password c", "address c", 40, musicGenresSet);
        //UserRepo.save(musician);
        //musician = new Musician("musician d", "firstname d", "lastname d", "password d", "address d", 50, musicGenresSet);
        //UserRepo.save(musician);

        /*userManagement.createMusician("SteveCook", "Steve", "Cook", "a", "Patision 20", 20, 
        Arrays.asList("Saxophone"), Arrays.asList(2), Arrays.asList("Rock", "Pop"), "profile.jpg");
        userManagement.createMusician("AliceMcCarthy", "Alice", "McCarthy", "password b", "address b", 30, 
        Arrays.asList("Saxophone", "Guitar", "Voice", "Bass", "Piano", "Violin"), Arrays.asList(2,3,6,1,9,7), Arrays.asList("Rock", "Pop", "Jazz", "Country","Classical","Blues"), "b");
        userManagement.createMusician("AlexMason", "Alex", "Mason", "password c", "address c", 40, 
        Arrays.asList("Saxophone"), Arrays.asList(2), Arrays.asList("Rock", "Pop"), "a");
        /*userManagement.createMusician("musician d", "firstname d", "lastname d", "password d", "address d", 50, 
        Arrays.asList("instument a"), Arrays.asList(2), Arrays.asList("musicGenre a", "musicGenre b"), "a");*/

        //System.out.println("create musicians");

        //Add instuments to musician
        
        //YearsOfExperience yearsOfExperience = new YearsOfExperience(2, (Musician) UserRepo.findByUsername("musician a"), InstrumentRepo.findByName("instument a"));
        //YearsOfExperienceRepo.save(yearsOfExperience);
        //yearsOfExperience = new YearsOfExperience(6, (Musician) UserRepo.findByUsername("musician a"), InstrumentRepo.findByName("instument b"));
        //YearsOfExperienceRepo.save(yearsOfExperience);

        /*userManagement.addInstument(6, "SteveCook", "Voice");
        userManagement.addInstument(2, "SteveCook", "Bass");
        userManagement.addInstument(10, "SteveCook", "Guitar");
        
        System.out.println("add instuments");*/

        //create band
        
        //Band band = new Band("band a", "a", (Musician) UserRepo.findByUsername("musician a"), musicGenresSet, true);
        //BandRepo.save(band);

        /*bandManagement.createBand("WonkyGuitars", "Omirou 14", "SteveCook", Arrays.asList("Rock", "Pop"), false, "a");
        bandManagement.createBand("Predicaments", "Akadimias 5", "AlexMason", Arrays.asList("Rock", "Pop"), true, "a");
        System.out.println("create band");*/

        //create band positions
		
        //BandPosition bandPosition = new BandPosition(InstrumentRepo.findByName("instument a"), BandRepo.findByName("band a"));
        //BandPositionRepo.save(bandPosition);
        //String bandUuid = bandPosition.getUuid();
        //bandPosition = new BandPosition(InstrumentRepo.findByName("instument b"), BandRepo.findByName("band a"));
        //BandPositionRepo.save(bandPosition);
        
        /*BandPosition b = bandManagement.createBandPosition("Saxophone", "WonkyGuitars");
        String bandUuid = b.getUuid();
        BandPosition b2 = bandManagement.createBandPosition("Guitar", "WonkyGuitars");
        String uuid2 = b2.getUuid();
        BandPosition b3 = bandManagement.createBandPosition("Saxophone", "Predicaments");
        String uuid3 = b3.getUuid();
        System.out.println("create band positions");*/
        
        //fill band position
        
        //BandPositionRepo.findByUuid(bandUuid).fillPossition((Musician) UserRepo.findByUsername("musician a"));
        //BandPositionRepo.save(bandPosition);

        /*bandManagement.fillBandPosition(bandUuid, "SteveCook");
        bandManagement.fillBandPosition(uuid3, "AlexMason");
        System.out.println("fill band position");*/

        //create employers
        
        //Employer employer = new Employer("employer a", "a", "a", "a");
        //UserRepo.save(employer);
        //employer = new Employer("employer b", "b", "b", "b");
        //UserRepo.save(employer);

        //userManagement.createEmployer("MarkOwen", "Mark", "Owen", "a", "profile.jpg");
        //userManagement.createEmployer("employer b", "b", "b", "b", "a");

        //System.out.println("create employers");

        //create job
        
        //Job job = new Job("job a", "a", (Employer) UserRepo.findByUsername("employer a"));
        //JobRepo.save(job);
        //job = new Job("job b", "b", (Employer) UserRepo.findByUsername("employer a"));
        //JobRepo.save(job);
        
        //jobManagement.createJob("ReleaseFestival", "PlateiaNerou", "MarkOwen", Arrays.asList(LocalDate.now()), Arrays.asList(Arrays.asList("Rock","Pop")));
        //jobManagement.createJob("job b", "b", "employer a", Arrays.asList(LocalDate.now().plusDays(10)), Arrays.asList(Arrays.asList("musicGenre a", "musicGenre b")));
        
        //System.out.println("create job");

        //Create conserts
		
        //Concert concert = new Concert(LocalDate.now(), JobRepo.findByName("job a"), musicGenresSet);
        //Concertepo.save(concert);
        //concert = new Concert(LocalDate.now().plusDays(10), JobRepo.findByName("job a"), musicGenresSet);
        //Concertepo.save(concert);
        //concert = new Concert(LocalDate.now().plusDays(10), JobRepo.findByName("job b"), musicGenresSet);
        //Concertepo.save(concert);
        //String concertUuid = concert.getUuid();

        //Concert c = jobManagement.addConsert(LocalDate.now().plusDays(10), "ReleaseFestival", Arrays.asList("Rock"));
        //String concertUuid = c.getUuid();

        //System.out.println("create conserts");
        
        //rate band
        
        //Rating rating = new Rating(5, BandRepo.findByName("band a"), (Employer) UserRepo.findByUsername("employer a"));
        //RatingRepo.save(rating);

        /*bandManagement.rateBand("MarkOwen", "WonkyGuitars", 5);
        bandManagement.rateBand("MarkOwen", "Predicaments", 4);

        System.out.println("rate band");*/


        
        //not all results tested only run time errors
        /*System.out.println("--------------------------------------------");

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

        System.out.println(((Musician) UserRepo.findByUsername("musician a")).getYearsInBand().toString());*/
        System.out.println("--------------------------------------------");

        List<String> listOfGenres = Arrays.asList("Rock");
        Band band = BandRepo.findByName("WonkyGuitars");
        ArrayList<String> musiciansSorted = searchMusicianManagement.searchForMusician("SteveCook",band.getAddress(), listOfGenres, "Guitar", 60, 4000, 400, 400, -1, -1, -1, -1);
        if(!musiciansSorted.isEmpty()){
            for(int i=0;i<musiciansSorted.size();i++){
                Musician musician = (Musician) UserRepo.findByUsername(musiciansSorted.get(i));
                int years = 0;
                Iterator<YearsOfExperience> it1 = musician.getYearsOfExperience().iterator();
                while(it1.hasNext()){
                    YearsOfExperience yearsOfExperience = it1.next();
                    if (yearsOfExperience.getInstument().getName().equals("Guitar")){
                        years = yearsOfExperience.getNumberOfYears();
                        break;
                    }
                }
                System.out.println("Username: "+ musician.getUsername()+" age: "+ musician.getAge()+" yearsInBand: "+musician.getYearsInBand().getDays()+" yearsOfExperienceWithInstrument: "+ years);
            }
        }
        else{
            System.out.println("No match");
        }
        Employer employer = (Employer) UserRepo.findByUsername("MarkOwen");
        //Job job = JobRepo.findByName("ReleaseFestival");
        System.out.println("--------------------------------------------");
        ArrayList<String> bandsSorted = searchBandAsEmployerManagement.searchForBand(employer.getUsername(), "PlateiaNerou", listOfGenres, 100000, -1, 5, 0, 30, -1);
        if(!bandsSorted.isEmpty()){
            for(int i=0;i<bandsSorted.size();i++){
                band = BandRepo.findByName(bandsSorted.get(i));
                
                int temp = 0;
                int numOfRatings = 0;
                Iterator<Rating> it2 = band.getRating().iterator();
                while(it2.hasNext()){
                    Rating rating = it2.next();
                    numOfRatings++;
                    temp += rating.getRating();
                }

                int avgRating = temp/numOfRatings;
                System.out.println("BandName: "+ band.getName()+" avgRating: "+ avgRating+" numberOfPositions: "+band.getNumberOfPositions());
            }
        }
        else{
            System.out.println("No match");
        }
        System.out.println("--------------------------------------------");
        Musician musician = (Musician) UserRepo.findByUsername("AliceMcCarthy");
        ArrayList<String> bandPositionsSorted =  searchBandPositionAsMusicianManagement.searchForBandPosition(musician.getUsername(), musician.getAddress(), listOfGenres, 100000, -1, 6, 0, 30, 0, -1, 70, 80, -1);
        if(!bandPositionsSorted.isEmpty()){
            for(int i=0;i<bandPositionsSorted.size();i++){
                BandPosition bandPosition = BandPositionRepo.findByUuid(bandPositionsSorted.get(i));
                band = bandPosition.getBand();

                int temp = 0;
                int numOfRatings = 0;
                Iterator<Rating> it2 = band.getRating().iterator();
                while(it2.hasNext()){
                    Rating rating = it2.next();
                    numOfRatings++;
                    temp += rating.getRating();
                }

                int avgRating = temp/numOfRatings;

                temp = 0;
                Iterator<BandPosition> it4 = band.getBandPositions().iterator();
                while(it4.hasNext()){
                    BandPosition bandPosition2 = it4.next();
                    if(bandPosition2.getOccupied()){
                        Iterator<YearsOfExperience> it5 = bandPosition2.getMusician().getYearsOfExperience().iterator();
                        while(it5.hasNext()){
                            YearsOfExperience yearsOfExperience = it5.next();
                            if(yearsOfExperience.getInstument().getName().equals(bandPosition2.getInstument().getName())){
                                temp += yearsOfExperience.getNumberOfYears();
                            }
                        }
                    }
                }

                int avgExperience = temp/band.getNumberOfPositions();

                temp = 0;
                    Iterator<BandPosition> it3 = band.getBandPositions().iterator();
                    while(it3.hasNext()){
                        BandPosition bandPosition2 = it3.next();
                        if(bandPosition.getOccupied()){
                            temp += bandPosition2.getMusician().getAge();
                        }
                    }

                    int avgAge = temp/band.getNumberOfPositions();
                System.out.println("BandUUid: "+bandPosition.getUuid()+" BandName: "+ band.getName()+" AvergaeAge: "+avgAge+" avgRating: "+ avgRating+" averageExperience: "+ avgExperience +" numberOfPositions: "+band.getNumberOfPositions());
            }
        }
        else{
            System.out.println("No match");
        }
        System.out.println("--------------------------------------------");
    }
}