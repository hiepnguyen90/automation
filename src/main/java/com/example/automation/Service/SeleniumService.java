package com.example.automation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.automation.Models.Selenium;
import com.example.automation.Repository.SeleniumRepository;

@Service
public class SeleniumService {
    @Autowired
    private SeleniumRepository repository;

    public Selenium save(Selenium selenium){
        return repository.save(selenium);
    }
    
    public List<Selenium> findAll(){
        return (List <Selenium>) repository.findAll();
    }
}
