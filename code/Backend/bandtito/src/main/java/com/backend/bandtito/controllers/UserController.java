package com.backend.bandtito.controllers;

import com.backend.bandtito.components.UserManagement;
import com.backend.bandtito.utils.CreateMusicianRequestBody;

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

    @PostMapping(path = "/register-user")
    public ResponseEntity<String> registerUser(@RequestBody CreateMusicianRequestBody data) {

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
}