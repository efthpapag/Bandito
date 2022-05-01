package com.backend.bandtito.controllers;

import com.backend.bandtito.components.BandManagement;
import com.backend.bandtito.utils.BandPositionRequestBody;
import com.backend.bandtito.utils.BandRequestBody;
import com.backend.bandtito.utils.FillBandPositionRequestBody;
import com.backend.bandtito.utils.RatingRequestBody;
import com.backend.bandtito.utils.UuidRequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BandController {
    
    @Autowired
    BandManagement bandManagement;

    @PostMapping(path = "/create-band")
    public ResponseEntity<String> createBand(@RequestBody BandRequestBody data) {

        bandManagement.createBand(data.getName(), data.getAddress(), data.getMusician(), data.getListOfMusicGenres(), data.getForHire(), data.getBandPicture());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("band created");
        System.out.println(data.getName());
        System.out.println(data.getAddress());
        System.out.println(data.getMusician());
        System.out.println(data.getListOfMusicGenres());
        System.out.println(data.getForHire()); 
        System.out.println(data.getBandPicture());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(path = "/edit-band")
    public ResponseEntity<String> editBand(@RequestBody BandRequestBody data) {

        bandManagement.editBand(data.getName(), data.getAddress(), data.getMusician(), data.getListOfMusicGenres(), data.getForHire(), data.getBandPicture());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("band edited");
        System.out.println(data.getName());
        System.out.println(data.getAddress());
        System.out.println(data.getMusician());
        System.out.println(data.getListOfMusicGenres());
        System.out.println(data.getForHire()); 
        System.out.println(data.getBandPicture());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/create-band-position")
    public ResponseEntity<String> createBandPosition(@RequestBody BandPositionRequestBody data) {

        bandManagement.createBandPosition(data.getInstument(), data.getBand());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("band position created");
        System.out.println(data.getInstument());
        System.out.println(data.getBand());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(path = "/fill-band-position")
    public ResponseEntity<String> fillBandPosition(@RequestBody FillBandPositionRequestBody data) {

        bandManagement.fillBandPosition(data.getBandPositionUuid(), data.getMusician());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("filled band position");
        System.out.println(data.getBandPositionUuid());
        System.out.println(data.getMusician());
        System.out.println(data.getMusician());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/empty-band-position")
    public ResponseEntity<String> emptyBandPosition(@RequestBody UuidRequestBody data) {

        bandManagement.emptyPosition(data.getUuid());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("emptied band position");
        System.out.println(data.getUuid());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/rate-band")
    public ResponseEntity<String> rateBand(@RequestBody RatingRequestBody data) {

        bandManagement.rateBand(data.getEmployer(), data.getBand(), data.getRating());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("rate band");
        System.out.println(data.getEmployer());
        System.out.println(data.getBand());
        System.out.println(data.getRating());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(path = "/delete-band-position")
    public ResponseEntity<String> deleteBandPosition(@RequestBody UuidRequestBody data) {

        bandManagement.deleteBandPossition(data.getUuid());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("deleted band position");
        System.out.println(data.getUuid());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/delete-position")
    public ResponseEntity<String> deleteBand(@RequestBody UuidRequestBody data) {

        bandManagement.deleteBand(data.getUuid());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("deleted band");
        System.out.println(data.getUuid());

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
