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
    private BandManagement bandManagement;

    @Autowired
    private UserRepository UserRepo;

    @Autowired
    private InstrumentRepository InstrumentRepo;

    public void init(){

        List<Instrument> Inst = new ArrayList<>();
        Inst = InstrumentRepo.findAll();
        ArrayList<Instrument> Instuments = new ArrayList<Instrument>(Inst);

        ArrayList<String> bandnames = new ArrayList<>();

        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"C:/Users/Efthimis/Desktop/Bandito/Bandito/code/bandtito/src/main/java/com/backend/bandtito/components/texts/bandnames.txt"));
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

        for(int j = 0; j < 10; j++){

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
                Random rand = new Random();
                if (rand.nextInt(2) == 0) {

                    List<User> mp = new ArrayList<>();
                    mp = UserRepo.findAll();
                    ArrayList<Musician> musiciansp = new ArrayList<Musician>();
                    for (int k = 0; k < mp.size(); k++) {
                        if(mp.get(k) instanceof Musician){
                            musiciansp.add((Musician) mp.get(i));
                            //System.out.println(k);
                        }
                    }

                    int ran = new Random().nextInt(musiciansp.size());
                    //System.out.print(musiciansp.get(ran).getIsBandMember());
                    while(musiciansp.get(ran).getIsBandMember()){ 
                        System.out.println("-------------------- is member");
                        //System.out.println(ran);
                        ran = new Random().nextInt(musiciansp.size());
                    }
                    musician = musiciansp.get(ran);
                    bandManagement.fillBandPosition(bandPosition.getUuid(), musician.getUsername());
            
                }
                //System.out.print("band position ");
                //System.out.println(i);
            }

            System.out.print("band");
            System.out.println(j);

        }
    }
}