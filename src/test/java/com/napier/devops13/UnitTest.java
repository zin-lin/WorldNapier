package com.napier.devops13;

import com.napier.devops13.models.PopulationReport;
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
    }

    /**
     * test connection to database
     */
    @Test
    void testMain() {
        app.main(new String[]{"localhost:33060", "10"} );
    }

    /**
     * test connection to database, when null is passed
     */
    @Test
    void testMainNull() {
        app.main(new String[]{});
    }

}

