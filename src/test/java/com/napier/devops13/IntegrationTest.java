package com.napier.devops13;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class IntegrationTest {
    static SQLConnection connection;

    /**
     * connection initialization.
     * @throws Exception
     */
    @BeforeAll
    static void setup() throws Exception {
        connection = new SQLConnection();
    }

    /**
     * testing connecction
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws InterruptedException
     */
    @Test
    void testConnection() throws SQLException, ClassNotFoundException, InterruptedException {
        connection.connect("localhost:33060", 30000);
    }

    /**
     * test country population report
     */
    @Test
    void testCountry() {
        connection.getPopulationOfCountry("GBR");
    }

    /**
     * test city population report
     */
    @Test
    void testCity() {
        connection.getPopulationOfCityID("NYC");
    }

    /**
     * test district population report
     */
    @Test
    void testDistrict() {
        connection.getPopulationOfDistrict("Limburg");
    }

    /**
     * test world population report
     */
    @Test
    void testPopulation() {
        connection.getWorldPopulation();
    }

    /**
     * test region population report
     */
    @Test
    void testRegion() {
        connection.getPopulationOfRegion("Carribean");
    }

    /**
     * test continent population report
     */
    @Test
    void testContinent() {
        connection.getPopulationOfContinent("Africa");
    }

    /**
     * test disconnecting from the database
     * @throws SQLException
     */
    @Test
    void testDisconnection() throws SQLException {
        connection.disconnect();
    }

    /**
     * test modelled reports
     */
    @Test
    void testCountryReports() {
        connection.getCountryContinentPopulationDesc("Europe");
        connection.getCountryRegionPopulationDesc("North America");
        connection.getCountryWorldPopulationDesc();
        connection.getCountryContinentPopulationDesc("Europe",3);
        connection.getCountryRegionPopulationDesc("North America", 3);
        connection.getCountryWorldPopulationDesc(6);
        connection.getCountryRegionPopulationDesc("North America");
        connection.getCapitalCityContinentReport("Europe");
        connection.getCapitalCityReport();
        connection.getCountryRegionPopulationDesc("North America",5);
        connection.getCapitalCityContinentReport("Europe", 6);
        connection.getCapitalCityReport(1);
        connection.getTopNCityPopulationWorld(1);
        connection.getTopNCityPopulationContinent("Europe",1);
        connection.getTopNCityPopulationCountry("Great Britain ", 1);
        connection.getTopNCityPopulationRegion("Carribean", 1);
        connection.getTopNCityPopulationDistrict("Limburg", 1);
        connection.getTopCityPopulationWorld();
        connection.getTopCityPopulationContinent("Europe");
        connection.getTopCityPopulationCountry("Great Britain ");
        connection.getTopCityPopulationRegion("Carribean");
        connection.getTopCityPopulationDistrict("Limburg");
        connection.getLinguisticData("English");

    }
}
