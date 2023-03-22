package com.napier.devops13;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * FailedTestReport
 * Author: Zin Lin Htun
 * Modified by Joeseph Kettles
 */
public class FailedIntegratedTest {
    static SQLConnection connection = new SQLConnection();

    @Test
    void testCountry() {
        connection.getPopulationOfCountry("GBR");
    }
    @Test
    void testCity() {
        connection.getPopulationOfCityID("NYC");
    }
    @Test
    void testDistrict() {
        connection.getPopulationOfDistrict("Limburg");
    }
    @Test
    void testPopulation() {
        connection.getWorldPopulation();
    }
    @Test
    void testRegion() {
        connection.getPopulationOfRegion("Carribean");
    }

    @Test
    void testContinent() {
        connection.getPopulationOfContinent("Africa");
    }

    @Test
    void testDisconnection() throws SQLException {
        connection.disconnect();
    }

    @Test
    void testCountryReports() {
        connection.getCountryContinentPopulationDesc("Europe");
        connection.getCountryRegionPopulationDesc("North America");
        connection.getCountryWorldPopulationDesc();
        connection.getCountryContinentPopulationDesc("Europe",3);
        connection.getCountryRegionPopulationDesc("North America", 3);
        connection.getCountryWorldPopulationDesc(6);
        connection.getCapitalCityRegionReport("North America");
        connection.getCapitalCityContinentReport("Europe");
        connection.getCapitalCityReport();
        connection.getCapitalCityRegionReport("North America",1);
        connection.getCapitalCityContinentReport("Europe", 6);
        connection.getCapitalCityReport(1);
    }
}
