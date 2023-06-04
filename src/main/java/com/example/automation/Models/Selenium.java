package com.example.automation.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "files")
public class Selenium {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String feature;

    private String scenario;

    private String given;

    private String whenStatement;

    private String thenStatement;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getGiven() {
        return given;
    }

    public void setGiven(String given) {
        this.given = given;
    }

    public String getWhenStatement() {
        return whenStatement;
    }

    public void setWhenStatement(String whenStatement) {
        this.whenStatement = whenStatement;
    }

    public String getThenStatement() {
        return thenStatement;
    }

    public void setThenStatement(String thenStatement) {
        this.thenStatement = thenStatement;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    };

}
