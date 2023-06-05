package com.example.automation.Controller;


import java.util.List;
import java.util.Optional;

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

    @GetMapping("/admin")
    public ResponseEntity<List<Selenium>> findAllEntries(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<Optional<Selenium>> getSelenium(@PathVariable("id") Long id){ 
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSelenium(@PathVariable("id") Long id){
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}