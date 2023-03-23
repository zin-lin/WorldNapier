package com.napier.devops13;

import com.napier.devops13.models.CapitalCityReport;
import com.napier.devops13.models.CountryReport;
import com.napier.devops13.models.PopulationReport;

import java.sql.*;
import java.util.ArrayList;

/**
SQLConnection :: the purpose of this class is to extract data from database docker.
Author: Zin Lin Htun
Modified by: Maya Peretz, Joseph Kettles, Guy Cameron, Patrick Nwagulu
 */
public class SQLConnection {
    /**
     * private materials
     */
    private Connection con = null;

    /**
     * connect to Database
     */
    public void connect(String location, int delay) throws ClassNotFoundException, SQLException, InterruptedException {
        // try to find the SQL Driver

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");

                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "devops13");
                System.out.println("Successfully connected");
                break;

        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() throws SQLException {
        if (con != null) {

            // Close connection
            con.close();

        }
    }

    /**
     * get the total population of the world
     * @return ans, returns the total population of the world.
     */
    public PopulationReport getWorldPopulation() {
        PopulationReport report;
        long ans = 0L;
        long city = 0L;
        double percent = 0;
        String name = "The World";
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population) `Population`  FROM `country`";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) {
                ans += rset.getLong("Population");
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }

        /**
         * Living in cities
         * returns report of percentage of all people living in cities.
         */
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population) `Population`  FROM `city`";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) {
                city += rset.getLong("Population");
            }

            percent = ((double) city / ans) * 100.0;
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
        /**
         * calculate and return the percentage of people living in cities.
         * since this is within the existing city report, the % of people living in cities will be 100.
         */
        report = new PopulationReport(name, ans, percent, 100 - percent);
        return report;
    }

    /**
     * get Population of a particular country
     * @param code, specific code of country
     * @return ans, returns population of the particular country queried for.
     */
    public PopulationReport getPopulationOfCountry(String code) {
        PopulationReport report;
        long ans = 0L;
        long city = 0L;
        double percent = 0;
        String name = "";
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select Population, Code, Name from country where `Code`" + "='" + code + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) {
                ans += rset.getLong("Population");
                name = rset.getString("Name");
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
        /**
         * creates report of people living in cities from the given country.
         */
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select SUM(Population) Population, CountryCode from city where `CountryCode`" + "='" + code + "' GROUP BY CountryCode";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) {
                city += rset.getLong("Population");
            }
            percent = ((double) city / ans) * 100.0;
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
        /**
         * gets the percentage of people living in cities from the given country.
         */
        report = new PopulationReport(name, ans, percent, 100 - percent);
        return report;
    }

    /**
     * get population of a particular continent
     *
     * @param continent, takes what continent we are querying for the population of
     * @return report, returns population report for queried company.
     */
    public PopulationReport getPopulationOfContinent(String continent) {
        PopulationReport report;
        long ans = 0L;
        long city = 0L;
        double percent = 0;
        String name = continent;
        String code = "";
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select sum(Population) `Population`, Code from country where `Continent`" + "='" + continent + "'" + " GROUP BY Code";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) {
                ans += rset.getLong("Population");
                code = rset.getString("Code");
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }

        /**
         * gets those living in cities from the given continent.
         */
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select SUM(Population) Population, CountryCode from city where `CountryCode`" + "='" + code + "' GROUP BY CountryCode";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) {
                city += rset.getLong("Population");
            }
            percent = ((double) city / ans) * 100.0;
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
        /**
         * retrieves the percentage of those living in cities for the given continent.
         */
        report = new PopulationReport(name, ans, percent, 100 - percent);
        return report;
    }

    /**
     * get population of a particular region
     *
     * @param region, takes in the region we want to query for the population of.
     * @return report, returns report of the region's population.
     */
    public PopulationReport getPopulationOfRegion(String region) {
        long ans = 0L;
        long city = 0L;
        double percent = 0;
        PopulationReport report;
        String code = "";
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select sum(Population) `Population`, Code from country where `Region`" + "='" + region + "'" + " GROUP BY Code";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) {
                ans += rset.getLong("Population");
                code = rset.getString("Code");
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }

        /**
         * gets population of those living in cities within the specific region
         */
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select SUM(Population) Population, CountryCode from city where `CountryCode`" + "='" + code + "' GROUP BY CountryCode";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) {
                city += rset.getLong("Population");
            }
            percent = ((double) city / ans) * 100.0;
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
        /**
         * gets percentage of people living in cities for that specific region
         */
        report = new PopulationReport(region, ans, percent, 100 - percent);
        return report;
    }

    /**
     * get population of a particular city by ID.
     *
     * @param id, takes in the ID of the city we want to query for.
     * @return report, returns report of the population of the city queried.
     */
    public PopulationReport getPopulationOfCityID(String id) {
        long ans = 0;
        String name = "";
        PopulationReport report;
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select Population, Name from city where `ID`" + "='" + id + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) {
                ans += rset.getLong("Population");
                name = rset.getString("Name");
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
        /**
         * gets percentage of people living in cities, for... the city by ID. should always be 100%.
         */
        report = new PopulationReport(name, ans, 100, 0);
        return report;
    }

    /**
     * get population of a particular district
     *
     * @param id, takes the ID of the district we want the population of.
     * @return report, returns a population report of the district we are querying for.
     */
    public PopulationReport getPopulationOfDistrict(String id) {
        long ans = 0;
        long city = 0;
        double percent = 0;
        PopulationReport report;
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select sum(Population) `Population` from city where `District`" + "='" + id + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) {
                ans += rset.getLong("Population");
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }

        /**
         * gets percentage of people living in cities for the district.
         */
        report = new PopulationReport(id, ans, 100, 0);
        return report;
    }

    /**
     * @return ans, returns a report for every country in the world, organised largest to smallest.
     */
    public ArrayList<CountryReport> getCountryWorldPopulationDesc() {
        ArrayList<CountryReport> ans = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select Code, country.Name Name, Continent, Region, city.Name Capital, country.Population from country JOIN city ON country.Capital = ID ORDER BY `Population` desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()) {
                CountryReport countryReport = new CountryReport(rset.getString("Code"),
                        rset.getString("Name"),
                        rset.getString("Continent"),
                        rset.getString("Region"),
                        rset.getString("Capital"),
                        rset.getLong("Population")
                );
                ans.add(countryReport);
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
        return ans;
    }

    /**
     * @param continent, takes in a specific continent
     * @return ans, returns every country in that continent, in descending population size order.
     */
    public ArrayList<CountryReport> getCountryContinentPopulationDesc(String continent) {
        ArrayList<CountryReport> ans = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select Code, country.Name Name, Continent, Region, city.Name Capital, country.Population from country JOIN city ON country.Capital = ID Where Continent = '" + continent + "' ORDER BY `Population` desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()) {
                CountryReport countryReport = new CountryReport(rset.getString("Code"),
                        rset.getString("Name"),
                        rset.getString("Continent"),
                        rset.getString("Region"),
                        rset.getString("Capital"),
                        rset.getLong("Population")
                );
                ans.add(countryReport);
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
        return ans;
    }

    /**
     * @param region, takes in a specific region.
     * @return ans, returns list of continents, countries in that region, as well as the respective capital cities, and lists them in descending population size order.
     */
    public ArrayList<CountryReport> getCountryRegionPopulationDesc(String region) {
        ArrayList<CountryReport> ans = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select Code, country.Name Name, Continent, Region, city.Name Capital, country.Population from country JOIN city ON country.Capital = ID  Where Continent = '" + region + "' ORDER BY `Population` desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()) {
                CountryReport countryReport = new CountryReport(rset.getString("Code"),
                        rset.getString("Name"),
                        rset.getString("Continent"),
                        rset.getString("Region"),
                        rset.getString("Capital"),
                        rset.getLong("Population")
                );
                ans.add(countryReport);
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
        return ans;
    }

    /**
     * @param count, takes in a numeric value.
     * @return ans, returns world population report in descending population value.
     */
    public ArrayList<CountryReport> getCountryWorldPopulationDesc(int count) {
        ArrayList<CountryReport> ans = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select Code, country.Name Name, Continent, Region, city.Name Capital, country.Population from country JOIN city ON country.Capital = ID ORDER BY `Population` desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            for (int a = 0; a < count; a++) {
                rset.next();
                CountryReport countryReport = new CountryReport(rset.getString("Code"),
                        rset.getString("Name"),
                        rset.getString("Continent"),
                        rset.getString("Region"),
                        rset.getString("Capital"),
                        rset.getLong("Population")
                );
                ans.add(countryReport);
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
        return ans;
    }

    /**
     *
     * @param continent, takes in the continent name.
     * @param count, used to index the information and make sure our loop does not continue forever.
     * @return ans, returns the report of country population in descending order for a specific continent.
     */
    public ArrayList<CountryReport> getCountryContinentPopulationDesc(String continent, int count) {
        ArrayList<CountryReport> ans = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select Code, country.Name Name, Continent, Region, city.Name Capital, country.Population from country JOIN city ON country.Capital = ID Where Continent = '" + continent + "' ORDER BY `Population` desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            for (int a = 0; a < count; a++) {
                rset.next();
                CountryReport countryReport = new CountryReport(rset.getString("Code"),
                        rset.getString("Name"),
                        rset.getString("Continent"),
                        rset.getString("Region"),
                        rset.getString("Capital"),
                        rset.getLong("Population")
                );
                ans.add(countryReport);
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
        return ans;
    }

    /**
     *
     * @param region, takes parameter of region we want the populations for.
     * @param count, indexes our information again so the loop is not infinite.
     * @return ans, returns the report of country populations in descending order for the specified region.
     */
    public ArrayList<CountryReport> getCountryRegionPopulationDesc(String region, int count) {
        ArrayList<CountryReport> ans = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select Code, country.Name Name, Continent, Region, city.Name Capital, country.Population from country JOIN city ON country.Capital = ID Where Continent = '" + region + "' ORDER BY `Population` desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            for (int a = 0; a < count; a++) {
                rset.next();
                CountryReport countryReport = new CountryReport(rset.getString("Code"),
                        rset.getString("Name"),
                        rset.getString("Continent"),
                        rset.getString("Region"),
                        rset.getString("Capital"),
                        rset.getLong("Population")
                );
                ans.add(countryReport);
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
        return ans;
    }

    /**
     * Gets city for the certain continent
     * @param continent, takes the continent from which we want the city information.
     * @return ans, returns the capital city report.
     */

    public ArrayList<CapitalCityReport> getCapitalCityContinentReport(String continent) {
        ArrayList<CapitalCityReport> ans = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select Code, city.Name Capital, Continent ,country.Name Name,city.Population Population from country JOIN city ON country.Capital = ID  Where country.Continent = '" + continent + "' ORDER BY `Population` desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()) {
                CapitalCityReport capitalCityReport;
                capitalCityReport = new CapitalCityReport(
                        rset.getString("Capital"),
                        rset.getString("Continent"),
                        rset.getLong("Population")
                );
                ans.add(capitalCityReport);
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
        return ans;
    }

    /**
     * Gets city for the world
     * @param, no parameter specified, so we get all of the capital cities.
     * @return ans, returns list of the capital city population reports.
     */

    public ArrayList<CapitalCityReport> getCapitalCityReport() {
        ArrayList<CapitalCityReport> ans = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select Code, city.Name Capital, Continent , country.Name Name,city.Population Population from country JOIN city ON country.Capital = ID ORDER BY `Population` desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()) {
                CapitalCityReport capitalCityReport;
                capitalCityReport = new CapitalCityReport(
                        rset.getString("Capital"),
                        rset.getString("Continent"),
                        rset.getLong("Population")
                );
                ans.add(capitalCityReport);
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
        return ans;
    }

    /**
     * Gets city for the certain region
     * @param region, specifies the region we want the information for.
     * @return ans, returns capital city reports for the specified region.
     */

    public ArrayList<CapitalCityReport> getCapitalCityRegionReport(String region) {
        ArrayList<CapitalCityReport> ans = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select Code, city.Name Capital, Continent ,Region, country.Name Name,city.Population Population from country JOIN city ON country.Capital = ID  Where country.Region = '" + region + "' ORDER BY `Population` desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()) {
                CapitalCityReport capitalCityReport;
                capitalCityReport = new CapitalCityReport(
                        rset.getString("Capital"),
                        rset.getString("Continent"),
                        rset.getLong("Population")
                );
                ans.add(capitalCityReport);
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
        return ans;
    }

    /**
     * Gets city for the certain continent
     * @param continent, specifies the continent for which we want the capital city reports.
     * @param count, indexes our information in the loop.
     * @return ans, returns the capital city reports for the specific continent we want in order.
     */

    public ArrayList<CapitalCityReport> getCapitalCityContinentReport(String continent, int count) {
        ArrayList<CapitalCityReport> ans = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select Code, city.Name Capital, Continent ,country.Name Name,city.Population Population from country JOIN city ON country.Capital = ID  Where country.Continent = '" + continent + "' ORDER BY `Population` desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            for (int a = 0; a < count; a++) {
                rset.next();
                CapitalCityReport capitalCityReport;
                capitalCityReport = new CapitalCityReport(
                        rset.getString("Capital"),
                        rset.getString("Continent"),
                        rset.getLong("Population")
                );
                ans.add(capitalCityReport);
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
        return ans;
    }

    /**
     * Gets city for the world
     * @param count, indexes our information in the loop.
     * @return ans, returns the capital city population reports in descending population order.
     */

    public ArrayList<CapitalCityReport> getCapitalCityReport(int count) {
        ArrayList<CapitalCityReport> ans = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select Code, city.Name Capital, Continent , country.Name Name,city.Population Population from country JOIN city ON country.Capital = ID ORDER BY `Population` desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            for (int a = 0; a < count; a++) {
                rset.next();
                CapitalCityReport capitalCityReport;
                capitalCityReport = new CapitalCityReport(
                        rset.getString("Capital"),
                        rset.getString("Continent"),
                        rset.getLong("Population")
                );
                ans.add(capitalCityReport);
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
        return ans;
    }

    /**
     * Gets city for the certain region
     * @param region, specifies the region for which we want the information.
     * @param count, indexes our information in the loop.
     * @return ans, returns capital city reports in descending order for the specified region.
     */

    public ArrayList<CapitalCityReport> getCapitalCityRegionReport(String region, int count) {
        ArrayList<CapitalCityReport> ans = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "select Code, city.Name Capital, Continent ,Region, country.Name Name,city.Population Population from country JOIN city ON country.Capital = ID  Where country.Region = '" + region + "' ORDER BY `Population` desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            for (int a = 0; a < count; a++) {
                rset.next();
                CapitalCityReport capitalCityReport;
                capitalCityReport = new CapitalCityReport(
                        rset.getString("Capital"),
                        rset.getString("Continent"),
                        rset.getLong("Population")
                );
                ans.add(capitalCityReport);
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
        return ans;
    }

}