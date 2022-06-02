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

import com.backend.bandtito.models.MusicGenre;
import com.backend.bandtito.models.Musician;
import com.backend.bandtito.models.User;
import com.backend.bandtito.models.YearsOfExperience;
import com.backend.bandtito.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchMusicianManagement {

    @Autowired
    private UserRepository UserRepo;
    
    public /*Musician*/ ArrayList<String> searchForMusician(String adminName,String addressOfBand, List<String> musicGenres, String instrument, int maxAge, int maxDistanceInMeters, int maxYDaysInBand, int maxYearsOfExperience, 
    int minAge, int minDistanceInMeters, int minDaysInBandInDays, int minYearsOfExperience) throws IOException, InterruptedException{

        ArrayList<User> listOfMusicians = new ArrayList<>();
        List<User> list = UserRepo.findAll();
        for(int i = 0; i < list.size(); i++){
            listOfMusicians.add((User) list.get(i));
        }

        BufferedWriter bw = null;
        File file = new File("../list_of_musicians.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file);
        bw = new BufferedWriter(fw);
        System.out.println("File written Successfully");
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

        for (int i = 0; i < listOfMusicians.size(); i++) {
            int years = 0;
            User user = listOfMusicians.get(i);
            if(user instanceof Musician){
                Musician musician = (Musician) user;
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
