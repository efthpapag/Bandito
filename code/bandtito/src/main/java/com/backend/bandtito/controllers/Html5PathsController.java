package com.backend.bandtito.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class Html5PathsController { 

    @RequestMapping( method = {RequestMethod.OPTIONS, RequestMethod.GET}, path = {"/path1/**", "/path2/**", "/"} )
    public String forwardAngularPaths() { 
        return "forward:/index.html"; 
    } 
}