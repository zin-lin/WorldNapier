package com.napier.devops13;

import com.napier.devops13.models.PopulationReport;

/**
 Author : Zin Lin Htun
 Matriculation : 40542237
 Application class : main class
*/
public class Application {

    public void printPopulationReportInFormat(PopulationReport report) {

        System.out.println("Name: "+ report.getName() +
                " Population: " + report.getPopulation() +
                " City Percentage: "+ report.getCityPercentage() +
                "% Non-City Percentage: "+ report.getNonCityPercentage() +"%"
                );

    }

    /**
     * Entrypoint:: docker app
     * @param args
     */
    public static void main (String [] args){

        Application app = new Application();
        SQLConnection connection = new SQLConnection();
        if(args.length < 1){
            connection.connect("localhost:33060", 1);
        }else{
            connection.connect(args[0], Integer.parseInt(args[1]));
        }

        app.printPopulationReportInFormat(connection.getWorldPopulation());
        app.printPopulationReportInFormat( connection.getPopulationOfCountry("GBR"));
        app.printPopulationReportInFormat(connection.getPopulationOfContinent("Africa"));
        app.printPopulationReportInFormat(connection.getPopulationOfRegion("Caribbean"));
        app.printPopulationReportInFormat(connection.getPopulationOfCityID("64"));
        app.printPopulationReportInFormat( connection.getPopulationOfDistrict("Limburg"));

        connection.disconnect();
    }
}
