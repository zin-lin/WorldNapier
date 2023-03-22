package com.napier.devops13;

import com.napier.devops13.models.CountryReport;
import com.napier.devops13.models.PopulationReport;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 Author : Zin Lin Htun
 Optimised by : Maya Peretz
 Matriculation : 40542237, 40528965
 Application class : main class
*/
public class Application {

    /**
     * printing population report
     * @param report
     */
    public void printPopulationReportInFormat(PopulationReport report) {
        System.out.println(report.toString());
    }

    public void printCountryReports(ArrayList<CountryReport> reports){
        reports.forEach(countryReport -> {
            System.out.println(countryReport.toString());
        });
    }

    /**
     * Entrypoint:: docker app
     * @param args
     */
    public static void main (String [] args) throws SQLException, ClassNotFoundException, InterruptedException {

        Application app = new Application();
        SQLConnection connection = new SQLConnection();
        if(args.length < 1){
            connection.connect("localhost:33060", 30000);
        }else{
            connection.connect(args[0], Integer.parseInt(args[1]));
        }

        System.out.println("Population Reports/n");

        app.printCountryReports(connection.getFullCountryReport(6));
        app.printCountryReports(connection.getFullContinentReport("Asia"));
        app.printCountryReports(connection.getFullRegionReport("North America"));
        app.printCountryReports(connection.getFullCountryReport(3));
        app.printCountryReports(connection.getFullContinentReport("Asia",3));
        app.printCountryReports(connection.getFullRegionReport("North America", 3));

        app.printPopulationReportInFormat(connection.getWorldPopulation());
        app.printPopulationReportInFormat( connection.getCountryPopulation("GBR"));
        app.printPopulationReportInFormat(connection.getContinentPopulation("Africa"));
        app.printPopulationReportInFormat(connection.getRegionPopulation("Caribbean"));
        app.printPopulationReportInFormat(connection.getCityPopulation("64"));
        app.printPopulationReportInFormat( connection.getDistrictPopulation("Limburg"));
        connection.disconnect();
    }
}
