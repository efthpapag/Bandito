package com.backend.bandtito.components;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.backend.bandtito.models.MusicGenre;
import com.backend.bandtito.models.Musician;
import com.backend.bandtito.models.User;
import com.backend.bandtito.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BandInitializer {

    @Autowired
    private BandManagement bandManagement;

    @Autowired
    private UserRepository UserRepo;

    public void init(){

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
            }
        }

        for(int j = 0; j < 10; j++){

            String name = bandnames.get(j);
            
            int rnd = new Random().nextInt(musicians.size());
            while(musicians.get(rnd).getIsBandMember()){
                rnd = new Random().nextInt(musicians.size());
            }
            Musician musician = musicians.get(rnd);
            System.out.println(musician.getUsername());

            ArrayList<String> mg = new ArrayList<>();

            Iterator<MusicGenre> it = musician.getMusicGenres().iterator();
            while(it.hasNext()){
                String s = it.next().getName();
                System.out.println(s);
                mg.add(s);
            }

            System.out.println("-------------------------------------------- 1");

            String bandPicture = "bandPic.png";

            bandManagement.createBand(name, "address", musician.getUsername(), mg, true, bandPicture);

            System.out.print("band");
            System.out.println(j);

        }
    }
}