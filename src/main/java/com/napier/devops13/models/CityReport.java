package com.napier.devops13.models;

public class CityReport {
    private String name;
    private String country;
    private String district;
    private long population;

    public String getName() {
        return name;
    }
    public String getCountry() {
        return country;
    }
    public String getDistrict() {
        return district;
    }
    public long getPopulation() {
        return population;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public void setPopulation(long population) {
        this.population = population;
    }
    public CityReport(String name, String country, String district, long population) {
        this.name = name;
        this.country = country;
        this.district = district;
        this.population = population;
    }
}
