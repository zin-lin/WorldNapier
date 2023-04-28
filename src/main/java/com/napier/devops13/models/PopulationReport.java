package com.napier.devops13.models;

/**
 * Population Report
 * author: Maya Peretz
 */
public class PopulationReport {
    private String name;
    private long population;
    private double cityPercentage;
    private double nonCityPercentage;

    public void setCityPercentage(long cityPercentage) {
        this.cityPercentage = cityPercentage;
    }
    public void setNonCityPercentage(long nonCityPercentage) {
        this.nonCityPercentage = nonCityPercentage;
    }
    public void setPopulation(long population) {
        this.population = population;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getCityPercentage() {
        return cityPercentage;
    }
    public double getNonCityPercentage() {
        return nonCityPercentage;
    }
    public long getPopulation() {
        return population;
    }
    public String getName() {
        return name;
    }

    /**
     * Population Report Constructor
     * @param name
     * @param population
     * @param cityPercentage
     * @param nonCityPercentage
     */
    public PopulationReport(String name, long population, double cityPercentage, double nonCityPercentage) {
        this.name = name;
        this.population = population;
        this.cityPercentage = cityPercentage;
        this.nonCityPercentage = nonCityPercentage;
    }
    @Override
    public String toString(){
        return "Name: " + name
                + ", Population: " + population
                + ", City Percentage: " + cityPercentage
                + "%, Non-City Percentage: " + nonCityPercentage + "%";
    }
}
