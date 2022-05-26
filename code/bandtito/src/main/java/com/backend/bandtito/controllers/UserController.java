package com.backend.bandtito.controllers;

import com.backend.bandtito.components.UserManagement;
import com.backend.bandtito.models.User;
import com.backend.bandtito.utils.EmployerRequestBody;
import com.backend.bandtito.utils.LogInRequestBody;
import com.backend.bandtito.utils.MusicGenreRequestBody;
import com.backend.bandtito.utils.MusicianRequestBody;
import com.backend.bandtito.utils.UuidRequestBody;
import com.backend.bandtito.utils.YearsOfExperienceRequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserManagement userManagement;

    @PostMapping(path = "/log-in")
    public ResponseEntity<String> lo9gInUser(@RequestBody LogInRequestBody data) {

        User user = userManagement.logInUser(data.getUsername(), data.getPassword());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("Log In");
        System.out.println(data.getUsername());
        System.out.println(data.getPassword());

        if(user != null){
            user.getUsername();
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        System.out.println("no such user");
        return new ResponseEntity<>(HttpStatus.OK);
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

        return new ResponseEntity<>(HttpStatus.CREATED);
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

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/register-employer")
    public ResponseEntity<String> registerEmployerr(@RequestBody EmployerRequestBody data) {


        if(userManagement.findUser(data.getUsername())){
            System.out.println("exists");        
            return new ResponseEntity<>(HttpStatus.OK);
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
        return new ResponseEntity<>(HttpStatus.CREATED);

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

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/add-instrument")
    public ResponseEntity<String> addInstrument(@RequestBody YearsOfExperienceRequestBody data) {

        userManagement.addInstument(data.getNumberOfYears(), data.getMusician(), data.getInstument());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("instrument added");
        System.out.println(data.getNumberOfYears());
        System.out.println(data.getMusician());
        System.out.println(data.getInstument());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(path = "/remove-instrument")
    public ResponseEntity<String> removeInstrument(@RequestBody UuidRequestBody data) {

        userManagement.removeInstument(data.getUuid());;

        System.out.println("----------------------------------------------------------------------");
        System.out.println("instrument removed");
        System.out.println(data.getUuid());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/add-music-genre")
    public ResponseEntity<String> addMusicGenre(@RequestBody MusicGenreRequestBody data) {

        userManagement.addMusicGenre(data.getMusician(), data.getMusicGenre());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("music genre added");
        System.out.println(data.getMusician());
        System.out.println(data.getMusicGenre());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(path = "/remove-music-genre")
    public ResponseEntity<String> removeMusicGenre(@RequestBody MusicGenreRequestBody data) {

        userManagement.removeMusicGenre(data.getMusician(), data.getMusicGenre());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("music genre removed");
        System.out.println(data.getMusician());
        System.out.println(data.getMusicGenre());
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
}