package com.napier.devops13.models;

/**
 * CountryReport class
 * author: Maya Peretz
 */
public class CountryReport {
    public String code;
    public String name;
    public String continent;
    public String region;
    public String capital;
    public long population;

    public void setCapital(String capital) {
        this.capital = capital;
    }
    public String getCapital() {
        return capital;
    }
    public void setPopulation(long population) {
        this.population = population;
    }
    public long getPopulation() {
        return population;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setContinent(String continent) {
        this.continent = continent;
    }
    public String getContinent() {
        return continent;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public String getRegion() {
        return region;
    }


    /**
     * Constructor
     * @param code
     * @param name
     * @param continent
     * @param region
     * @param capital
     * @param population
     */
    public CountryReport(String code, String name, String continent, String region, String capital, long population) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.capital = capital;
        this.population = population;
    }

    @Override
    public String toString(){
        return "Name: " + name
                + ", Code: " + code
                + ", Continent: " + continent
                + ", Region: " + region
                + ", Capital: " + capital
                + ", Population: " + population;
    }
}
