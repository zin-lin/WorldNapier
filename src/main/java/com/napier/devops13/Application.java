package com.napier.devops13;

import com.napier.devops13.models.CapitalCityReport;
import com.napier.devops13.models.CountryReport;
import com.napier.devops13.models.LinguisticData;
import com.napier.devops13.models.PopulationReport;

import java.sql.SQLException;
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

    public void printCapitalReports(ArrayList<CapitalCityReport> reports){
        reports.forEach(capitalCityReport -> {
            System.out.println(capitalCityReport.toString());
        });
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
            connection.connect("localhost:33060", 0000);
        }else{
            connection.connect(args[0], Integer.parseInt(args[1]));
        }


        System.out.println("General Reports\n Country Reports");

        app.printCountryReports(connection.getCountryWorldPopulationDesc());
        app.printCountryReports(connection.getCountryContinentPopulationDesc("Asia"));
        app.printCountryReports(connection.getCountryRegionPopulationDesc("North America"));

        System.out.println("\nGeneral Reports\n Country Reports with Top n\n\n\n");

        app.printCountryReports(connection.getCountryWorldPopulationDesc(3));
        app.printCountryReports(connection.getCountryContinentPopulationDesc("Asia",3));
        app.printCountryReports(connection.getCountryRegionPopulationDesc("North America", 3));


        System.out.println("\nGeneral Reports\n Capital Reports");
        app.printCapitalReports(connection.getCapitalCityReport());
        app.printCapitalReports(connection.getCapitalCityContinentReport("Asia"));
        app.printCapitalReports(connection.getCapitalCityRegionReport("North America"));
        System.out.println("\nGeneral Reports\n Capital Reports for Top N");
        app.printCapitalReports(connection.getCapitalCityReport(3));
        app.printCapitalReports(connection.getCapitalCityContinentReport("Asia",4));
        app.printCapitalReports(connection.getCapitalCityRegionReport("North America",1));

        System.out.println("\nPopulation Reports\n");

        app.printPopulationReportInFormat(connection.getWorldPopulation());
        app.printPopulationReportInFormat( connection.getPopulationOfCountry("GBR"));
        app.printPopulationReportInFormat(connection.getPopulationOfContinent("Africa"));
        app.printPopulationReportInFormat(connection.getPopulationOfRegion("Caribbean"));
        app.printPopulationReportInFormat(connection.getPopulationOfCityID("64"));
        app.printPopulationReportInFormat( connection.getPopulationOfDistrict("Limburg"));

        System.out.println("\n\n");

        for (LinguisticData country :connection.getLinguisticData("Chinese")){
            System.out.println(country.getLanguage() + " : "+ country.getPercentage() + "%");
        }


        connection.disconnect();
    }
}
