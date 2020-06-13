package com.example.and1project.Entities;

public class Country {
    private String name;
    private String capital;
    private String region;
    private int population;
    private String flag;

    public Country(String name, String capital, String region, int population, String flag){
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.population = population;
        this.flag = flag;


    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getRegion() {
        return region;
    }

    public int getPopulation() {
        return population;
    }

    public String getFlag() {
        return flag;
    }
}
