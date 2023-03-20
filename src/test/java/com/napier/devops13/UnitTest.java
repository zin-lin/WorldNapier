package com.napier.devops13;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests, for unit testing purposes of Java classes
 * Author: Zin Lin Htun
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
     * application buil test
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
        app.printInFormat(null , null);
    }

}
