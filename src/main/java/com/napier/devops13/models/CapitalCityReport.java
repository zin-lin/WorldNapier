package com.napier.devops13.models;
/**
 * This class represents a Capital City Report
 * author: Maya Peretz
 */
public class CapitalCityReport {
    private String name;
    private long population;
    private String country;

    /**
     * Constructor for the Capital City Report
     * @param capital
     * @param continent
     * @param capitalPopulation
     */
    public CapitalCityReport(String capital, String continent, long capitalPopulation)
    {
        this.name = capital;
        this.population = capitalPopulation;
        this.country = continent;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getPopulation() {
        return population;
    }
    public void setPopulation(long population) {
        this.population = population;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public CapitalCityReport(String name, long population, String country) {
        this.name = name;
        this.population = population;
        this.country = country;
    }

    @Override
    public String toString(){
         return "Name: " + name
                + ", Country: " + country
                + ", Population: " + population;
    }
}
