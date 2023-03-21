package com.napier.devops13;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class IntegrationTest {
    static SQLConnection connection;

    @BeforeAll
    static void setup() throws Exception {
        connection = new SQLConnection();
    }
    @Test
    void testConnection() {
        connection.connect("localhost:33060", 30000);
    }

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
        connection.getPopulationOfDistrcit("Limburg");
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
    void testDisconnection() {
        connection.disconnect();
    }

}
