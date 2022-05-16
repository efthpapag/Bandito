package com.backend.bandtito.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class  InstrumentInitializer {

    @Autowired
    InstrumentManagement instrumentManagement;
    
    public void init(){

        instrumentManagement.createInstument("Piano", "PianoPic");
        instrumentManagement.createInstument("Guitar", "GuitarPic");
        instrumentManagement.createInstument("Violin", "ViolinPic");
        instrumentManagement.createInstument("Drums", "DrumsPic");
        instrumentManagement.createInstument("Saxophone", "SaxophonePic");
        instrumentManagement.createInstument("Flute", "FlutePic");
        instrumentManagement.createInstument("Clarinet", "ClarinetPic");
        instrumentManagement.createInstument("Cello", "CelloPic");
        instrumentManagement.createInstument("Trumpet", "TrumpetPic");
        instrumentManagement.createInstument("Voice", "VoicePic");
        instrumentManagement.createInstument("Bass", "BassPic");

        System.out.println("instrument");


    }

}
