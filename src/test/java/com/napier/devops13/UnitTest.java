package com.napier.devops13;

import com.napier.devops13.models.CapitalCityReport;
import com.napier.devops13.models.CityReport;
import com.napier.devops13.models.CountryReport;
import com.napier.devops13.models.PopulationReport;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests, for unit testing purposes of Java classes
 * Author: Zin Lin Htun
 * modified by: Patrick Nwagulu and Maya Peretz
 * matric: 40542237
 */
public class UnitTest {
    /**
     * application build test
     */
    static Application app;
    static SQLConnection connection;
    @BeforeAll
    public static void appTest() {
        app = new Application();
    }

    /**
     * application build test
     */
    @Test
    public void testConnection() {
        connection = new SQLConnection();
    }

    /**
     * test connection to database
     */
    @Test
    void testPrint() {
        app.printPopulationReportInFormat(new PopulationReport("XXX", 234234234, 12, 100-12) );
        app.printCountryReports(new ArrayList<>());
    }

    /**
     * test connection to database
     */
    @Test
    void testMain() throws SQLException, ClassNotFoundException, InterruptedException {
        app.main(new String[]{"localhost:33060", "10"} );
    }

    /**
     * test connection to database, when null is passed
     */
    @Test
    void testMainNull() throws SQLException, ClassNotFoundException, InterruptedException {
        app.main(new String[]{});
    }

    /**
     * test city model
     */
    @Test
    void testCityReport(){
        CityReport cityReport = new CityReport("Name", "Country", "District", 232323232);
        cityReport.setCountry("United States");
        cityReport.getCountry();
        cityReport.setName("Name1");
        cityReport.setDistrict("District1");
        cityReport.setPopulation(932323232);
        cityReport.getDistrict();
        cityReport.getPopulation();
        cityReport.getName();
        cityReport.toString();
    }

    /**
     * test capital city model
     */
    @Test
    void testCapitalCityReport(){
        CapitalCityReport cityReport = new CapitalCityReport("Name", 232323232, "Country");
        cityReport.setCountry("United States");
        cityReport.getCountry();
        cityReport.setName("Name1");
        cityReport.setPopulation(932323232);
        cityReport.getPopulation();
        cityReport.getName();
        cityReport.toString();
    }

    /**
     * test country model
     */
    @Test
    void testCountryReport(){
        CountryReport countryReport = new CountryReport("code", "name", "continent", "region", "capital", 999999999);
        countryReport.setName("name1");
        countryReport.setContinent("cont");
        countryReport.setRegion("region1");
        countryReport.setCapital("capital1");
        countryReport.setPopulation(1);
        countryReport.setCode("code1");
        countryReport.getContinent();
        countryReport.getRegion();
        countryReport.getCapital();
        countryReport.getCode();
        countryReport.getName();
        countryReport.getCode();
        countryReport.getPopulation();
        countryReport.toString();
    }

    /**
     * test population models
     */
    @Test
    void testPopulationReport(){
        PopulationReport populationReport = new PopulationReport("Name", 23232323, 100, 0);
        populationReport.setName("Name1");
        populationReport.setPopulation(93232323);
        populationReport.getPopulation();
        populationReport.getName();
        populationReport.setCityPercentage(0);
        populationReport.getCityPercentage();
        populationReport.setNonCityPercentage(100);
        populationReport.getNonCityPercentage();
        populationReport.toString();

    }

    @Test
    void testData(){

    }

}

