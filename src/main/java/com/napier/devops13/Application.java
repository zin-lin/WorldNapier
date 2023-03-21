package com.napier.devops13;

import com.napier.devops13.models.CountryReport;
import com.napier.devops13.models.PopulationReport;

import java.util.ArrayList;

/**
 Author : Zin Lin Htun
 Matriculation : 40542237
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
    public static void main (String [] args){

        Application app = new Application();
        SQLConnection connection = new SQLConnection();
        if(args.length < 1){
            connection.connect("localhost:33060", 30000);
        }else{
            connection.connect(args[0], Integer.parseInt(args[1]));
        }

        System.out.println("Population Reports/n");

        app.printCountryReports(connection.getCountryWorldPopulationDesc());
        app.printCountryReports(connection.getCountryContinentPopulationDesc("Asia"));
        app.printCountryReports(connection.getCountryRegionPopulationDesc("North America"));
        app.printCountryReports(connection.getCountryWorldPopulationDesc(3));
        app.printCountryReports(connection.getCountryContinentPopulationDesc("Asia",3));
        app.printCountryReports(connection.getCountryRegionPopulationDesc("North America", 3));

        app.printPopulationReportInFormat(connection.getWorldPopulation());
        app.printPopulationReportInFormat( connection.getPopulationOfCountry("GBR"));
        app.printPopulationReportInFormat(connection.getPopulationOfContinent("Africa"));
        app.printPopulationReportInFormat(connection.getPopulationOfRegion("Caribbean"));
        app.printPopulationReportInFormat(connection.getPopulationOfCityID("64"));
        app.printPopulationReportInFormat( connection.getPopulationOfDistrict("Limburg"));

        connection.disconnect();
    }
}
