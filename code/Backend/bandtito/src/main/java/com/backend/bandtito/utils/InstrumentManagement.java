package com.backend.bandtito.utils;

import com.backend.bandtito.models.Instument;
import com.backend.bandtito.repositories.InstumentRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class InstrumentManagement {

	@Autowired
    private InstumentRepository InstumentRepo;
    
    //create instument
    public Instument createInstument(String name){
        Instument instument = new Instument(name);
        InstumentRepo.save(instument);
        return instument;
    }
}
