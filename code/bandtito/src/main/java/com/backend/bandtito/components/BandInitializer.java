package com.backend.bandtito.components;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.backend.bandtito.models.Band;
import com.backend.bandtito.models.BandPosition;
import com.backend.bandtito.models.Employer;
import com.backend.bandtito.models.Instrument;
import com.backend.bandtito.models.MusicGenre;
import com.backend.bandtito.models.Musician;
import com.backend.bandtito.models.User;
import com.backend.bandtito.repositories.InstrumentRepository;
import com.backend.bandtito.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BandInitializer {

    @Autowired
    private UserManagement userManagement;

    @Autowired
    private BandManagement bandManagement;

    @Autowired
    private UserRepository UserRepo;

    @Autowired
    private InstrumentRepository InstrumentRepo;

    public void init() throws ClassNotFoundException{

        List<Instrument> Inst = new ArrayList<>();
        Inst = InstrumentRepo.findAll();
        ArrayList<Instrument> Instuments = new ArrayList<Instrument>(Inst);

        ArrayList<String> bandnames = new ArrayList<>();

        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"../initializer_texts/bandnames.txt"));
			String line = reader.readLine();
			while (line != null) {
				//System.out.println(line);
				line = reader.readLine();
                bandnames.add(line);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

        List<User> m = new ArrayList<>();
        m = UserRepo.findAll();
        ArrayList<Musician> musicians = new ArrayList<Musician>();
        for (int i = 0; i < m.size(); i++) {
            if(m.get(i) instanceof Musician){
                musicians.add((Musician) m.get(i));
                //System.out.println(i);
            }
        }

        //create full bands
        for(int j = 0; j < 15; j++){

            String name = bandnames.get(j);
            
            int rnd = new Random().nextInt(musicians.size());
            while(musicians.get(rnd).getIsBandMember()){
                rnd = new Random().nextInt(musicians.size());
                //System.out.println("-------------------- is member");
            }
            Musician musician = musicians.get(rnd);
            //System.out.println(musician.getUsername());

            ArrayList<String> mg = new ArrayList<>();

            Iterator<MusicGenre> it = musician.getMusicGenres().iterator();
            while(it.hasNext()){
                String s = it.next().getName();
                //System.out.println(s);
                mg.add(s);
            }

            String bandPicture = "bandPic.png";

            Band band = bandManagement.createBand(name, "address", musician.getUsername(), mg, true, bandPicture);

            Random r = new Random();
            int low = 1;
            int high = 3;
            int inNum = r.nextInt(high-low) + low;

            for(int i = 0; i < inNum; i++){
                rnd = new Random().nextInt(Instuments.size());
                BandPosition bandPosition = bandManagement.createBandPosition(Instuments.get(rnd).getName(), band.getName());
                if (true) {

                    List<User> mp = new ArrayList<>();
                    mp = UserRepo.findAll();
                    ArrayList<Musician> musiciansp = new ArrayList<Musician>();
                    for (int k = 0; k < mp.size(); k++) {
                        //System.out.println("--------------------------------------------");
                        //System.out.println(mp.get(k).getUsername());
                        //System.out.println(mp.get(k).getClass().getName());
                        if(!mp.get(k).getClass().getName().equals("com.backend.bandtito.models.Employer")){//TO create proper instsnce of finder
                            musiciansp.add((Musician) mp.get(i));
                            //System.out.println(k);
                        }
                    }

                    int ran = new Random().nextInt(musiciansp.size());
                    //System.out.print(musiciansp.get(ran).getIsBandMember());
                    while(musiciansp.get(ran).getIsBandMember()){ 
                        //System.out.println("-------------------- is member");
                        //System.out.println(ran);
                        ran = new Random().nextInt(musiciansp.size());
                    }
                    musician = musiciansp.get(ran);
                    bandManagement.fillBandPosition(bandPosition.getUuid(), musician.getUsername());
            
                }
                //System.out.print("band position ");
                //System.out.println(i);

            }

            ArrayList<User> listOfEmployers = new ArrayList<>();
            /*List<User> list = UserRepo.findAll();
            for(int i = 0; i < list.size(); i++){
                listOfEmployers.add((User) list.get(i));
                System.out.println("user added");
            }*/
            Employer e = userManagement.createEmployer("JoeSmith", "Joe", "Smith", "1234", "a");
            e = userManagement.createEmployer("MariaSmith", "Maria", "Smith", "1234", "a");
            listOfEmployers.add(e);
            e = userManagement.createEmployer("JohnHammond", "John", "Hammond", "1234", "a");
            listOfEmployers.add(e);
            e = userManagement.createEmployer("BillFox", "Bill", "Fox", "1234", "a");
            listOfEmployers.add(e);


            for (int i = 0; i < listOfEmployers.size(); i++) {
                User user = listOfEmployers.get(i);
                //System.out.println("band rated 1");
                if(user instanceof Employer){
                    r = new Random();
                    low = 1;
                    high = 5;
                    inNum = r.nextInt(high-low) + low;
                    bandManagement.rateBand(user.getUsername(), band.getName(), inNum);
                    //System.out.println("band rated 2");
                }
            }

            System.out.print("bands full");
            System.out.println(j);

        }

        //create empty bands
        for(int j = 0; j < 15; j++){

            String name = bandnames.get(j);
            
            int rnd = new Random().nextInt(musicians.size());
            while(musicians.get(rnd).getIsBandMember()){
                rnd = new Random().nextInt(musicians.size());
                //System.out.println("-------------------- is member");
            }
            Musician musician = musicians.get(rnd);
            //System.out.println(musician.getUsername());

            ArrayList<String> mg = new ArrayList<>();

            Iterator<MusicGenre> it = musician.getMusicGenres().iterator();
            while(it.hasNext()){
                String s = it.next().getName();
                //System.out.println(s);
                mg.add(s);
            }

            String bandPicture = "bandPic.png";

            Band band = bandManagement.createBand(name, "address", musician.getUsername(), mg, true, bandPicture);

            Random r = new Random();
            int low = 1;
            int high = 3;
            int inNum = r.nextInt(high-low) + low;

            for(int i = 0; i < inNum; i++){
                rnd = new Random().nextInt(Instuments.size());
                BandPosition bandPosition = bandManagement.createBandPosition(Instuments.get(rnd).getName(), band.getName());
                if (new Random().nextInt(2) == 0/*true*/) {

                    List<User> mp = new ArrayList<>();
                    mp = UserRepo.findAll();
                    ArrayList<Musician> musiciansp = new ArrayList<Musician>();
                    for (int k = 0; k < mp.size(); k++) {
                        //System.out.println("--------------------------------------------");
                        //System.out.println(mp.get(k).getUsername());
                        //System.out.println(mp.get(k).getClass().getName());
                        if(!mp.get(k).getClass().getName().equals("com.backend.bandtito.models.Employer")){//TO create proper instsnce of finder
                            musiciansp.add((Musician) mp.get(i));
                            //System.out.println(k);
                        }
                    }

                    int ran = new Random().nextInt(musiciansp.size());
                    //System.out.print(musiciansp.get(ran).getIsBandMember());
                    while(musiciansp.get(ran).getIsBandMember()){ 
                        //System.out.println("-------------------- is member");
                        //System.out.println(ran);
                        ran = new Random().nextInt(musiciansp.size());
                    }
                    musician = musiciansp.get(ran);
                    bandManagement.fillBandPosition(bandPosition.getUuid(), musician.getUsername());
            
                }
                //System.out.print("band position ");
                //System.out.println(i);

            }

            ArrayList<User> listOfEmployers = new ArrayList<>();
            /*List<User> list = UserRepo.findAll();
            for(int i = 0; i < list.size(); i++){
                listOfEmployers.add((User) list.get(i));
                System.out.println("user added");
            }*/
            Employer e = userManagement.createEmployer("GeorgeAbbott", "George", "Abbott", "1234", "a");
            e = userManagement.createEmployer("GiovanyGorgio", "Giovany", "Gorgio", "1234", "a");
            listOfEmployers.add(e);
            e = userManagement.createEmployer("GeorgePapadopoylos", "George", "Papadopoylos", "1234", "a");
            listOfEmployers.add(e);
            e = userManagement.createEmployer("AnneSimpson", "Anne", "Simpson", "1234", "a");
            listOfEmployers.add(e);


            for (int i = 0; i < listOfEmployers.size(); i++) {
                User user = listOfEmployers.get(i);
                //System.out.println("band rated 1");
                if(user instanceof Employer){
                    r = new Random();
                    low = 1;
                    high = 5;
                    inNum = r.nextInt(high-low) + low;
                    bandManagement.rateBand(user.getUsername(), band.getName(), inNum);
                    //System.out.println("band rated 2");
                }
            }

            System.out.print("bands empty");
            System.out.println(j);

        }

    }
}