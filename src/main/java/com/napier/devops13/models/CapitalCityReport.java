package com.napier.devops13.models;

public class CapitalCityReport {
    private String name;
    private long population;
    private String country;

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
}
