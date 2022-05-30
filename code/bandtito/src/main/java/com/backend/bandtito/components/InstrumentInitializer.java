package com.backend.bandtito.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class  InstrumentInitializer {

    @Autowired
    InstrumentManagement instrumentManagement;
    
    public void init(){

        instrumentManagement.createInstument("Piano", "PianoPic.jpg");
        instrumentManagement.createInstument("Guitar", "GuitarPic.jpg");
        instrumentManagement.createInstument("Violin", "ViolinPic.jpg");
        instrumentManagement.createInstument("Drums", "DrumsPic.jpg");
        instrumentManagement.createInstument("Saxophone", "SaxophonePic.jpg");
        instrumentManagement.createInstument("Flute", "FlutePic.jpg");
        instrumentManagement.createInstument("Clarinet", "ClarinetPic.jpg");
        instrumentManagement.createInstument("Cello", "CelloPic.jpg");
        instrumentManagement.createInstument("Trumpet", "TrumpetPic.jpg");
        instrumentManagement.createInstument("Voice", "VoicePic.jpg");
        instrumentManagement.createInstument("Bass", "BassPic.jpg");

        System.out.println("instrument");


    }

}
