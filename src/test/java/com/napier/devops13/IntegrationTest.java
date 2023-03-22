package com.napier.devops13;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class IntegrationTest {
    static SQLConnection connection;

    @BeforeAll
    static void setup() throws Exception {
        connection = new SQLConnection();
    }
    @Test
    void testConnection() throws SQLException, ClassNotFoundException, InterruptedException {
        connection.connect("localhost:33060", 30000);
    }

    @Test
    void testCountry() {
        connection.getCountryPopulation("GBR");
    }
    @Test
    void testCity() {
        connection.getCityPopulation("NYC");
    }
    @Test
    void testDistrict() {
        connection.getDistrictPopulation("Limburg");
    }
    @Test
    void testPopulation() {
        connection.getWorldPopulation();
    }
    @Test
    void testRegion() {
        connection.getRegionPopulation("Carribean");
    }

    @Test
    void testContinent() {
        connection.getContinentPopulation("Africa");
    }

    @Test
    void testDisconnection() {
        connection.disconnect();
    }

    @Test
    void testCountryReports() {
        connection.getFullContinentReport("Europe");
        connection.getFullRegionReport("North America");
        connection.getFullCountryReport();
        connection.getFullContinentReport("Europe",3);
        connection.getFullRegionReport("North America", 3);
        connection.getFullCountryReport(6);
        connection.getCapitalReport("London");

    }
}
