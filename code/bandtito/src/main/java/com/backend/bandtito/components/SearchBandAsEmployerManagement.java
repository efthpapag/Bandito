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
import java.util.concurrent.TimeUnit;

import com.backend.bandtito.models.Band;
import com.backend.bandtito.models.MusicGenre;
import com.backend.bandtito.models.Musician;
import com.backend.bandtito.models.User;
import com.backend.bandtito.models.YearsOfExperience;
import com.backend.bandtito.repositories.BandRepository;
import com.backend.bandtito.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchBandAsEmployerManagement {

    @Autowired
    private BandRepository BandRepo;
    
    public /*Band*/ ArrayList<String> searchForMusician(String address, List<String> musicGenres, int maxDistanceInMeters,
    int minDistanceInMeters, int maxRating, int minRating, int numberOfMembers) throws IOException, InterruptedException{

        ArrayList<Band> listOfBands = new ArrayList<>();
        List<Band> list = BandRepo.findAll();
        for(int i = 0; i < list.size(); i++){
            listOfBands.add((Band) list.get(i));
        }

        BufferedWriter bw = null;
        File file = new File("../list_of_musicians.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file);
        bw = new BufferedWriter(fw);
        System.out.println("File written Successfully");
        
        //Creates original preferences
        Musician admin = (Musician) UserRepo.findByUsername(adminName);
        int yearsAdmin=0;
        int n=0;
        Iterator<YearsOfExperience> it = admin.getYearsOfExperience().iterator();
        while(it.hasNext()){
            YearsOfExperience yearsOfExperience = it.next();
            yearsAdmin =+ yearsOfExperience.getNumberOfYears();
            n++;
        }
        bw.write(admin.getUsername() + "++" + admin.getAge() + "++" + 0  + "++" + admin.getYearsInBand().getDays() + "++" + yearsAdmin/n);  
        bw.newLine();



        for (int i = 0; i < listOfBands.size(); i++) {
            int years = 0;
            Band band = listOfBands.get(i);
            if(band.getForHire() && band.getIsFull()){

                int temp = 0;
                int numOfRatings = 0; 

                if(!musician.getIsBandMember() && maxAge >= musician.getAge() && musician.getAge() >= minAge && maxYDaysInBand >= musician.getYearsInBand().getDays() && musician.getYearsInBand().getDays() >= minDaysInBandInDays){    
                    boolean playsInstrument = false;
                    ArrayList<YearsOfExperience> yearsOfExperience = new ArrayList<>();
                    yearsOfExperience.addAll(musician.getYearsOfExperience());
                    int j = 0;
                    while(playsInstrument == false && j < yearsOfExperience.size()){
                        if(yearsOfExperience.get(j).getInstument().getName().equals(instrument)){
                            playsInstrument = true;
                            years = yearsOfExperience.get(j).getNumberOfYears();
                        }    
                        j++;
                    }

                    if(playsInstrument){

                        ArrayList<MusicGenre> musicGennreList = new ArrayList<>();
                        musicGennreList.addAll(musician.getMusicGenres());
                        j = 0;
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
                            int distanceInMeters = new Random().nextInt(5000);//distance from addressOfBand to musician's address calculated here
                            if(maxDistanceInMeters >= distanceInMeters && distanceInMeters >= minDistanceInMeters){
                                bw.write(musician.getUsername() + "++" + musician.getAge() + "++" + distanceInMeters  + "++" + musician.getYearsInBand().getDays() + "++" + years);
                                bw.newLine();
                            }
                        }
                    }
                }
            }

        }
     
        bw.close();
        ProcessBuilder processBuilder = new ProcessBuilder("python", "../algorithm.py");
        Process process = processBuilder.start();
        ArrayList<String> sortedUsernames = new ArrayList<String>();
        process.waitFor();
        //TimeUnit.SECONDS.sleep(5);
        try {
            File myObj = new File("../sorted.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              sortedUsernames.add(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        return sortedUsernames;
    }

}
