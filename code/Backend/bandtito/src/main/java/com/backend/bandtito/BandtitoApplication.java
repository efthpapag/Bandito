package com.backend.bandtito;

import javax.annotation.PostConstruct;

import com.backend.bandtito.models.User;
import com.backend.bandtito.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BandtitoApplication {

	@Autowired
    private UserRepository userRepo;
	public static void main(String[] args) {
		SpringApplication.run(BandtitoApplication.class, args);
	}

	@PostConstruct
    public void init(){
		//test user
        User user = new User("a", "a", "a");
        userRepo.save(user);

    }

}
