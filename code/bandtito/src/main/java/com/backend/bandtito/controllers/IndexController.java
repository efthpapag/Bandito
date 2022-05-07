package com.backend.bandtito.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping(path = "/hi")
	public ResponseEntity<String> hi() {
		System.out.println("hi");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}