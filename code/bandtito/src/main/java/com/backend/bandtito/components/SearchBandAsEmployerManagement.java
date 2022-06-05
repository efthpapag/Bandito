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
import com.backend.bandtito.models.Employer;
import com.backend.bandtito.models.MusicGenre;
import com.backend.bandtito.models.Rating;
import com.backend.bandtito.repositories.BandRepository;
import com.backend.bandtito.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchBandAsEmployerManagement {

    @Autowired
    private BandRepository BandRepo;

    @Autowired
    private UserRepository UserRepo;
    
    public ArrayList<String> searchForBand(String employerUsername, String address, List<String> musicGenres, int maxDistanceInMeters,
    int minDistanceInMeters, int maxRating, int minRating, int maxNumberOfMembers, int minNumberOfMembers) throws IOException, InterruptedException{

        ArrayList<Band> listOfBands = new ArrayList<>();
        List<Band> list = BandRepo.findAll();
        for(int i = 0; i < list.size(); i++){
            listOfBands.add((Band) list.get(i));
        }

        BufferedWriter bw = null;
        File file = new File("../list_of_bandsFH.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file);
        bw = new BufferedWriter(fw);
        System.out.println("File written Successfully");
        
        //Creates original preferences
        Employer employer = (Employer) UserRepo.findByUsername(employerUsername);
        bw.write(employer.getUsername() + "++" + 5 + "++" + 0  + "++" +  (maxNumberOfMembers + minNumberOfMembers)/2);  
        bw.newLine();

        for (int i = 0; i < listOfBands.size(); i++) {
            Band band = listOfBands.get(i);
            if(band.getForHire() && band.getIsFull()){

                //Calculate average rating
                int temp = 0;
                int numOfRatings = 0;
                Iterator<Rating> it2 = band.getRating().iterator();
                while(it2.hasNext()){
                    Rating rating = it2.next();
                    numOfRatings++;
                    temp += rating.getRating();
                }

                int avgRating = temp/numOfRatings;

                if(maxRating > avgRating && minRating < avgRating && maxNumberOfMembers > band.getNumberOfPositions() && minNumberOfMembers < band.getNumberOfPositions()){    

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
                        int distanceInMeters = new Random().nextInt(5000);//distance from addressOfBand to Job's address calculated here
                        if(maxDistanceInMeters >= distanceInMeters && distanceInMeters >= minDistanceInMeters){
                            bw.write(band.getName() + "++" + avgRating + "++" + distanceInMeters  + "++" + band.getNumberOfPositions());
                            bw.newLine();
                        }
                    }
                    
                }
            }

        }
     
        bw.close();
        ProcessBuilder processBuilder = new ProcessBuilder("python", "../algorithmBandsFH.py");
        Process process = processBuilder.start();
        ArrayList<String> sortedBandsFH = new ArrayList<String>();
        process.waitFor();
        //TimeUnit.SECONDS.sleep(5);
        try {
            File myObj = new File("../sortedBandsFH.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              sortedBandsFH.add(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        return sortedBandsFH;
    }

}
