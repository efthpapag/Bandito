package com.backend.bandtito.controllers;

import com.backend.bandtito.components.JobManagement;
import com.backend.bandtito.utils.ConcertRequestBody;
import com.backend.bandtito.utils.JobRequestBody;
import com.backend.bandtito.utils.UuidRequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {

    @Autowired
    JobManagement jobManagement;

    @PostMapping(path = "/create-job")
    public ResponseEntity<String> createJob(@RequestBody JobRequestBody data) {

        jobManagement.createJob(data.getName(), data.getAddress(), data.getEmployer(), data.getDates(), data.getGenres());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("job created");
        System.out.println(data.getName());
        System.out.println(data.getAddress());
        System.out.println(data.getEmployer());
        System.out.println(data.getDates());
        System.out.println(data.getAddress()); 
        System.out.println(data.getGenres());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PostMapping(path = "/delete-job")
    public ResponseEntity<String> deleteJob(@RequestBody UuidRequestBody data) {

        jobManagement.deleteJob(data.getUuid());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("job delete");
        System.out.println(data.getUuid());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/add-consert")
    public ResponseEntity<String> addConsert(@RequestBody ConcertRequestBody data) {

        jobManagement.addConsert(data.getDate(), data.getJob(), data.getListOfMusicGenres());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("add consert");
        System.out.println(data.getDate());
        System.out.println(data.getJob());
        System.out.println(data.getListOfMusicGenres());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(path = "/remove-consert")
    public ResponseEntity<String> removeConsert(@RequestBody UuidRequestBody data) {

        jobManagement.deleteConsert(data.getUuid());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("remove consert");
        System.out.println(data.getUuid());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
