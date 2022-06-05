package com.backend.bandtito.components;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.backend.bandtito.models.Band;
import com.backend.bandtito.models.BandPosition;
import com.backend.bandtito.models.MusicGenre;
import com.backend.bandtito.models.Musician;
import com.backend.bandtito.models.Rating;
import com.backend.bandtito.models.YearsOfExperience;
import com.backend.bandtito.repositories.BandRepository;
import com.backend.bandtito.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchBandPositionAsMusicianManagement {

    @Autowired
    private BandRepository BandRepo;

    @Autowired
    private UserRepository UserRepo;
    
    public ArrayList<String> searchForBandPosition(String musicianUsername, String address, List<String> musicGenres, int maxDistanceInMeters,
    int minDistanceInMeters, int maxRating, int minRating, int maxNumberOfMembers, int minNumberOfMembers , int minAvgAge, int maxAvgAge, int maxAvgYearsOfExperience, int minAvgYearsOfExperience) throws IOException, InterruptedException{

        ArrayList<Band> listOfBands = new ArrayList<>();
        List<Band> list = BandRepo.findAll();
        for(int i = 0; i < list.size(); i++){
            listOfBands.add((Band) list.get(i));
        }

        BufferedWriter bw = null;
        File file = new File("../list_of_bandPositions.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file);
        bw = new BufferedWriter(fw);
        System.out.println("File written Successfully");
        
        //Creates original preferences
        Musician musician = (Musician) UserRepo.findByUsername(musicianUsername);
        int yearsOfExperienceOfmusician=0;
        Iterator<YearsOfExperience> it = musician.getYearsOfExperience().iterator();
        while(it.hasNext()){
            YearsOfExperience yearsOfExperience = it.next();
            yearsOfExperienceOfmusician =+ yearsOfExperience.getNumberOfYears();
        }
        bw.write(musician.getUsername() + "++" + musician.getAge() + "++" + 5 + "++" + 0 + "++" + yearsOfExperienceOfmusician/musician.getYearsOfExperience().size() + "++"+ (maxNumberOfMembers + minNumberOfMembers) / 2);  
        bw.newLine();

        for (int i = 0; i < listOfBands.size(); i++) {
            Band band = listOfBands.get(i);
            if(!band.getIsFull()){



                //Calculate average rating
                int temp = 0;
                int numOfRatings = 0;
                Iterator<Rating> it2 = band.getRating().iterator();
                while(it2.hasNext()){
                    Rating rating = it2.next();
                    numOfRatings++;
                    temp += rating.getRating();
                }

                float avgRating = temp/numOfRatings;

                if(maxRating < avgRating && minRating > avgRating && maxNumberOfMembers < band.getNumberOfPositions() && minNumberOfMembers > band.getNumberOfPositions()){    

                    //Calculate average band member age
                    temp = 0;
                    Iterator<BandPosition> it3 = band.getBandPositions().iterator();
                    while(it3.hasNext()){
                        BandPosition bandPosition = it3.next();
                        if(bandPosition.getOccupied()){
                            temp += bandPosition.getMusician().getAge();
                        }
                    }

                    int avgAge = temp/band.getNumberOfPositions();

                    if(avgAge < minAvgAge && avgAge > maxAvgAge){


                        //Calculate average band member experience
                        temp = 0;
                        Iterator<BandPosition> it4 = band.getBandPositions().iterator();
                        while(it4.hasNext()){
                            BandPosition bandPosition = it4.next();
                            if(bandPosition.getOccupied()){
                                Iterator<YearsOfExperience> it5 = bandPosition.getMusician().getYearsOfExperience().iterator();
                                while(it5.hasNext()){
                                    YearsOfExperience yearsOfExperience = it5.next();
                                    if(yearsOfExperience.getInstument().getName().equals(bandPosition.getInstument().getName())){
                                        temp += yearsOfExperience.getNumberOfYears();
                                    }
                                }
                            }
                        }

                        int avgExperience = temp/band.getNumberOfPositions();

                        if(avgExperience < minAvgYearsOfExperience && avgExperience > maxAvgYearsOfExperience){
                    
                            ArrayList<MusicGenre> musicGennreList = new ArrayList<>();
                            musicGennreList.addAll(band.getMusicGenres());
                            int j = 0;
                            int musicGennreNum = 0;
                            while(musicGennreNum != musicGenres.size() && j < musicGennreList.size()){
                                int k = 0;
                                while(musicGennreNum != musicGenres.size() && k < musicGenres.size()){
                                    if(musicGennreList.get(j).getName().equals(musicGenres.get(k))){
                                        musicGennreNum++;
                                    }
                                    k++;
                                }
                                j++;
                            }      

                            if(musicGennreNum == musicGenres.size()){
                                int distanceInMeters = new Random().nextInt(5000);//distance from addressOfBand to musican's address calculated here
                                if(maxDistanceInMeters >= distanceInMeters && distanceInMeters >= minDistanceInMeters){


                                    //Check if the band plays needs one of the musicians instruments
                                    Iterator<BandPosition> it6 = band.getBandPositions().iterator();
                                    while(it6.hasNext()){
                                        BandPosition bandPosition = it6.next();
                                        if(!bandPosition.getOccupied()){
                                            Iterator<YearsOfExperience> it7 = musician.getYearsOfExperience().iterator();
                                            while(it7.hasNext()){
                                                YearsOfExperience yearsOfExperience = it7.next();
                                                if(yearsOfExperience.getInstument().getName().equals(bandPosition.getInstument().getName())){
                                                    bw.write(bandPosition.getUuid() + "++" + avgAge + "++" + avgRating + "++" + distanceInMeters + "++" + avgExperience + "++" + band.getNumberOfPositions());
                                                    bw.newLine();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
     
        bw.close();
        ProcessBuilder processBuilder = new ProcessBuilder("python", "../algorithmBandPos.py");
        Process process = processBuilder.start();
        ArrayList<String> sortedBandPositions = new ArrayList<String>();
        process.waitFor();
        //TimeUnit.SECONDS.sleep(5);
        try {
            File myObj = new File("../sortedBandPositions.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              sortedBandPositions.add(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        return sortedBandPositions;
    }

}
