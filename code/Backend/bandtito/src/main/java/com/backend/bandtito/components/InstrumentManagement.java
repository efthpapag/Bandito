package com.backend.bandtito.components;

import com.backend.bandtito.models.Instrument;
import com.backend.bandtito.repositories.InstrumentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InstrumentManagement {

	@Autowired
    private InstrumentRepository InstrumentRepo;
    
    //create instument
    public Instrument createInstument(String name){
        Instrument instument = new Instrument(name);
        InstrumentRepo.save(instument);
        return instument;
    }
}
