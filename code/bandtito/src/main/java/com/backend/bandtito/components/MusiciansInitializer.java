package com.backend.bandtito.components;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.backend.bandtito.models.Instrument;
import com.backend.bandtito.models.MusicGenre;
import com.backend.bandtito.repositories.InstrumentRepository;
import com.backend.bandtito.repositories.MusicGenreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusiciansInitializer {
    
    @Autowired
    private UserManagement userManagement;

    @Autowired
    private InstrumentRepository InstrumentRepo;

    @Autowired
    private MusicGenreRepository MusicGenreRepo;

    public void init(){

        ArrayList<String> firstNames = new ArrayList<>();

        ArrayList<String> lastNames = new ArrayList<>();

        List<Instrument> Inst = new ArrayList<>();
        Inst = InstrumentRepo.findAll();
        ArrayList<Instrument> Instuments = new ArrayList<Instrument>(Inst);

        List<MusicGenre> mg = new ArrayList<>();
        mg = MusicGenreRepo.findAll();
        ArrayList<MusicGenre> MusicGenres = new ArrayList<MusicGenre>(mg);

        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"../initializer_texts/firstNames.txt"));
			String line = reader.readLine();
			while (line != null) {
				//System.out.println(line);
				line = reader.readLine();
                firstNames.add(line);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

        try {
			reader = new BufferedReader(new FileReader(
					"../initializer_texts/surnames.txt"));
			String line = reader.readLine();
			while (line != null) {
				//System.out.println(line);
				line = reader.readLine();
                lastNames.add(line);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

        ArrayList<String> lmg = new ArrayList<>();
        for(int i = 0; i < MusicGenres.size(); i++){
            lmg.add(MusicGenres.get(i).getName()); 
        }


        for(int j = 0; j < 50; j++){

            int rnd = new Random().nextInt(firstNames.size());
            String firstname = firstNames.get(rnd);

            rnd = new Random().nextInt(lastNames.size());
            String lastname = lastNames.get(rnd);

            String username = firstname + lastname;

            Random r = new Random();
            int low = 18;
            int high = 67;
            int age = r.nextInt(high-low) + low;

            low = 1;
            high = 3;
            int inNum = r.nextInt(high-low) + low;
            
            ArrayList<String> listOfInstuments = new ArrayList<>();
            ArrayList<Integer> listOfYears = new ArrayList<>();

            for(int i = 0; i < inNum;){
                rnd = new Random().nextInt(Instuments.size());
                low = 0;
                high = 50;
                int years = r.nextInt(high-low) + low;
                if(!listOfInstuments.contains(Instuments.get(rnd).getName())){
                    listOfInstuments.add(Instuments.get(rnd).getName());
                    //System.out.println(Instuments.get(rnd).getName());
                    listOfYears.add(years);
                    i++;
                }
                /*else{
                    System.out.println("same");
                }*/
            }


            low = 1;
            high = 3;
            int mgNum = r.nextInt(high-low) + low;

            ArrayList<String> listOfMusicGenres = new ArrayList<>();
            ArrayList<String> remaining = new ArrayList<>();
            for(int i = 0; i < lmg.size(); i++){
                remaining.add(lmg.get(i));
                //System.out.println(lmg.get(i));
            }
            
            for(int i = 0; i < mgNum; i++){
                if (remaining.isEmpty()) {
                    throw new IllegalStateException("names all used");
                }
                int index = (int) (Math.random() * remaining.size());
                String result = remaining.remove( index);
                //System.out.println(result);
                listOfMusicGenres.add(result);
            }

            String profilePic = "profilePic.png";
            
            userManagement.createMusician(username, firstname, lastname, "aA@123456", "address", age, listOfInstuments, listOfYears, listOfMusicGenres, profilePic);

            System.out.print(username + "---");
            System.out.print("musician");
            System.out.println(j);

        }
    }
}