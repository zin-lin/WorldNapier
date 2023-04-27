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

    /**
     * Test country to see if a failed test report is created
     */
    @Test
    void testCountry() {
        connection.getPopulationOfCountry("GBR");
    }

    /**
     *  Test city to see if a failed test report is created
     */
    @Test
    void testCity() {
        connection.getPopulationOfCityID("NYC");
    }

    /**
     * Test district to see if a failed test report is created
     */
    @Test
    void testDistrict() {
        connection.getPopulationOfDistrict("Limburg");
    }

    /**
     * test world to see if a failed test report is created
     */
    @Test
    void testPopulation() {
        connection.getWorldPopulation();
    }

    /**
     * test region to see if a failed test report is created
     */
    @Test
    void testRegion() {
        connection.getPopulationOfRegion("Carribean");
    }

    /**
     * test continent to see if a failed test report is created
     */
    @Test
    void testContinent() {
        connection.getPopulationOfContinent("Africa");
    }

    /**
     * test disconnection to see if a failed test is created
     * @throws SQLException
     */
    @Test
    void testDisconnection() throws SQLException {
        connection.disconnect();
    }

    /**
     * Test modelled reports to see if a failed test report is created
     */
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
        connection.getTopNCityPopulationWorld(1);
        connection.getTopNCityPopulationContinent("Europe",1);
        connection.getTopNCityPopulationCountry("Palau", 1);
        connection.getTopNCityPopulationRegion("Southern and Central Asia", 1);
        connection.getTopNCityPopulationDistrict("Limburg", 1);
        connection.getTopCityPopulationWorld();
        connection.getTopCityPopulationContinent("Europe");
        connection.getTopCityPopulationCountry("Palau");
        connection.getTopCityPopulationRegion("Southern and Central Asia");
        connection.getTopCityPopulationDistrict("Limburg");
        connection.getLinguisticData("English");
    }
}
