package com.napier.devops13;

import java.sql.*;

/**
SQLConnection :: the purpose of this class is to extract data from database docker.
Author: Zin Lin Htun
Modified by: Maya Peretz, Joseph Kettles, Guy Cameron, Patrick Nwagulu
 */
public class SQLConnection {
    /**
    private materials
     */
    private Connection con = null;
    /**
     * connect to Database
     */
    public void connect(String location, int delay){
        // try to find the SQL Driver
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://"+ location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "devops13");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqlException)
            {
                // indexing starts with 1 for the sake of readability
                System.out.println("Failed to connect to database attempt " + Integer.toString(i + 1));
                System.out.println(sqlException.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }
    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }
    /**
     * get the total population of the world
     * @return ans
     */
    public long getWorldPopulation ()  {
        long ans = 0;
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population) `Population`  FROM `country`";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) {
                ans += rset.getLong("Population");
            }
        }
        catch (Exception err){
            System.out.println(err.getMessage());
        }
        return  ans;
    }

    /**
     * get Population of a particular country
     * @param code, specific code of country
     * @return ans
     */
    public long getPopulationOfCountry (String code)  {
        long ans = 0;
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select Population, Code from country where `Code`" + "='" + code+ "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) {
                ans += rset.getLong("Population");
            }
        }
        catch (Exception err){
            System.out.println(err.getMessage());
        }
        return  ans;
    }

    /**
     * get population of a particular continent
     * @param continent
     * @return
     */
    public long getPopulationOfContinent (String continent)  {
        long ans = 0;
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select sum(Population) `Population` from country where `Continent`" + "='" + continent+ "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) {
                ans += rset.getLong("Population");
            }
        }
        catch (Exception err){
            System.out.println(err.getMessage());
        }
        return  ans;
    }

    /**
     * get population of a particular continent
     * @param region
     * @return
     */
    public long getPopulationOfRegion (String region)  {
        long ans = 0;
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select sum(Population) `Population` from country where `Region`" + "='" + region + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) {
                ans += rset.getLong("Population");
            }
        }
        catch (Exception err){
            System.out.println(err.getMessage());
        }
        return  ans;
    }

    /**
     * get population of a particular city
     * @param id
     * @return
     */
    public long getPopulationOfCityID (String id)  {
        long ans = 0;
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select Population from city where `ID`" + "='" + id + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) {
                ans += rset.getLong("Population");
            }
        }
        catch (Exception err){
            System.out.println(err.getMessage());
        }
        return  ans;
    }

    /**
     * get population of a particular district
     * @param id
     * @return
     */
    public long getPopulationOfDistrcit (String id)  {
        long ans = 0;
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select sum(Population) `Population` from city where `District`" + "='" + id + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) {
                ans += rset.getLong("Population");
            }
        }
        catch (Exception err){
            System.out.println(err.getMessage());
        }
        return  ans;
    }

}