package com.example.automation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.automation.Models.Selenium;

@Repository
public interface SeleniumRepository extends JpaRepository<Selenium, Long> {
    
}
