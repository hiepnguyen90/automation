package com.example.automation.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.automation.Models.Selenium;
import com.example.automation.Service.SeleniumService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SeleniumController {
    @Autowired
    private final SeleniumService service;

    public SeleniumController(SeleniumService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<Selenium> createSelenium(@RequestBody Selenium s){
        Selenium selenium = service.save(s);
        return new ResponseEntity<>(selenium, HttpStatus.CREATED);       
    }
    
}
