package com.backend.bandtito.controllers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.backend.bandtito.components.UserManagement;
import com.backend.bandtito.models.Employer;
import com.backend.bandtito.models.Musician;
import com.backend.bandtito.models.User;
import com.backend.bandtito.models.YearsOfExperience;
import com.backend.bandtito.repositories.UserRepository;
import com.backend.bandtito.utils.EmployerRequestBody;
import com.backend.bandtito.utils.LogInRequestBody;
import com.backend.bandtito.utils.MusicGenreRequestBody;
import com.backend.bandtito.utils.MusicianRequestBody;
import com.backend.bandtito.utils.UuidRequestBody;
import com.backend.bandtito.utils.YearsOfExperienceRequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserManagement userManagement;

    @Autowired
    private UserRepository UserRepo;

    @GetMapping(path = "/get-musician-info/{username}")
    public Map<String, String> sendMusicianInfo(@PathVariable String username) {

        System.out.println("get-musician-info");
        System.out.println(username);

        Musician musician = (Musician) UserRepo.findByUsername(username);
        HashMap<String, String> map = new HashMap<>();
        map.put("firstname", musician.getFirstName());
        map.put("lastname", musician.getLastName());
        map.put("address", musician.getAddress());
        map.put("picture", musician.getProfilePic());
        map.put("age", Integer.toString(musician.getAge()));
        map.put("isbandmember", String.valueOf(musician.getIsBandMember()));
        map.put("yearsinband", Integer.toString(musician.getYearsInBand().getDays()));
        map.put("band", musician.getBandPosition().getBand().getName());
        if(musician.getAdminOfBand() == null){
            map.put("admin", "false");    
        }
        map.put("admin", "true");

        int i = 0;
        //System.out.print(musician.getYearsOfExperience().size());
        Iterator<YearsOfExperience> it = musician.getYearsOfExperience().iterator();
        while(it.hasNext()){
            YearsOfExperience yearsOfExperience = it.next();
            if(yearsOfExperience.getInstument()!=null){
                String s = yearsOfExperience.getInstument().getName();
                String y = Integer.toString(yearsOfExperience.getNumberOfYears());
                String uuid = yearsOfExperience.getUuid();
                map.put("inst" + i, s);
                map.put("years" + i, y);
                map.put("uuid" + i, uuid);
                System.out.println(s);
                System.out.println(i);
                i++;
            }
        }
    
        return map;
    }










    @PostMapping(path = "/log-in")
    public ResponseEntity<?> logInUser(@RequestBody LogInRequestBody data) {

        User user = userManagement.logInUser(data.getUsername(), data.getPassword());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("Log In");
        System.out.println(data.getUsername());
        System.out.println(data.getPassword());

        if(user instanceof Employer){
            System.out.println("Employer");
            user.getUsername();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        }
        else if(user instanceof Musician){
            System.out.println("Musician");
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        else{
            System.out.println("Not found");
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        }
    }

    @PostMapping(path = "/register-musician")
    public ResponseEntity<String> registerUser(@RequestBody MusicianRequestBody data) {

        userManagement.createMusician(data.getUsername(), data.getFirstName(), data.getLastName(), data.getPassword(), data.getAddress(), 
        data.getAge(), data.getListOfInstuments(), data.getListOfYears(), data.getMusicGenres(), data.getProfilePic());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("musician created");
        System.out.println(data.getUsername());
        System.out.println(data.getFirstName());
        System.out.println(data.getLastName());
        System.out.println(data.getPassword());
        System.out.println(data.getAddress()); 
        System.out.println(data.getAge());
        System.out.println(data.getListOfInstuments()); 
        System.out.println(data.getListOfYears());
        System.out.println(data.getMusicGenres());
        System.out.println(data.getProfilePic());

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PostMapping(path = "/edit-musician")
    public ResponseEntity<String> editUser(@RequestBody MusicianRequestBody data) {

        userManagement.editMusician(data.getUsername(), data.getFirstName(), data.getLastName(), data.getPassword(), data.getAddress(), 
        data.getAge(), data.getProfilePic());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("musician edited");
        System.out.println(data.getUsername());
        System.out.println(data.getFirstName());
        System.out.println(data.getLastName());
        System.out.println(data.getPassword());
        System.out.println(data.getAddress()); 
        System.out.println(data.getAge());
        System.out.println(data.getListOfInstuments()); 
        System.out.println(data.getListOfYears());
        System.out.println(data.getMusicGenres());
        System.out.println(data.getProfilePic());

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping(path = "/register-employer")
    public ResponseEntity<String> registerEmployerr(@RequestBody EmployerRequestBody data) {


        if(userManagement.findUser(data.getUsername())){
            System.out.println("exists");        
            return new ResponseEntity<>(null, HttpStatus.OK);
        }

        System.out.println("does not exists");
        userManagement.createEmployer(data.getUsername(), data.getFirstName(), data.getLastName(), data.getPassword(), data.getProfilePic());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("employer created");
        System.out.println(data.getUsername());
        System.out.println(data.getFirstName());
        System.out.println(data.getLastName()); 
        System.out.println(data.getPassword());
        System.out.println(data.getProfilePic());
        return new ResponseEntity<>(null, HttpStatus.CREATED);

    }

    @PostMapping(path = "/edit-employer")
    public ResponseEntity<String> editEmployer(@RequestBody EmployerRequestBody data) {

        userManagement.createEmployer(data.getUsername(), data.getFirstName(), data.getLastName(), data.getPassword(), data.getProfilePic());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("employer edited");
        System.out.println(data.getUsername());
        System.out.println(data.getFirstName());
        System.out.println(data.getLastName());
        System.out.println(data.getPassword());
        System.out.println(data.getProfilePic());

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping(path = "/add-instrument")
    public ResponseEntity<String> addInstrument(@RequestBody YearsOfExperienceRequestBody data) {

        userManagement.addInstument(data.getNumberOfYears(), data.getMusician(), data.getInstument());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("instrument added");
        System.out.println(data.getNumberOfYears());
        System.out.println(data.getMusician());
        System.out.println(data.getInstument());

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PostMapping(path = "/remove-instrument")
    public ResponseEntity<String> removeInstrument(@RequestBody UuidRequestBody data) {

        userManagement.removeInstument(data.getUuid());;

        System.out.println("----------------------------------------------------------------------");
        System.out.println("instrument removed");
        System.out.println(data.getUuid());

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping(path = "/add-music-genre")
    public ResponseEntity<String> addMusicGenre(@RequestBody MusicGenreRequestBody data) {

        userManagement.addMusicGenre(data.getMusician(), data.getMusicGenre());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("music genre added");
        System.out.println(data.getMusician());
        System.out.println(data.getMusicGenre());

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PostMapping(path = "/remove-music-genre")
    public ResponseEntity<String> removeMusicGenre(@RequestBody MusicGenreRequestBody data) {

        userManagement.removeMusicGenre(data.getMusician(), data.getMusicGenre());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("music genre removed");
        System.out.println(data.getMusician());
        System.out.println(data.getMusicGenre());
        
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}