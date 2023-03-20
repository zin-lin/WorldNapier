package com.napier.devops13;

/**
 Author : Zin Lin Htun
 Matriculation : 40542237
 Application class : main class
*/
public class Application {

    public void printInFormat(String name, String ans){
        System.out.println( name +  "'s Population :: " + ans);
    }

    /**
     * Entrypoint:: docker app
     * @param args
     */
    public static void main (String [] args){
        // Connect
        SQLConnection sqlConnection = new SQLConnection();
        sqlConnection.connectDB();
        System.out.print("The World's Population :: ");
        System.out.println(sqlConnection.getWorldPopulation());
        System.out.print("Great Britain's Population :: ");
        System.out.println(sqlConnection.getPopulationOfCountry("GBR"));
        System.out.print("Africa's Population :: ");
        System.out.println(sqlConnection.getPopulationOfContinent("Africa"));
        System.out.print("Caribbean's Population :: ");
        System.out.println(sqlConnection.getPopulationOfRegion("Caribbean"));
        System.out.print("Dubai's Population :: ");
        System.out.println(sqlConnection.getPopulationOfCityID("64"));
        System.out.print("Limburgh's Population :: ");
        System.out.println(sqlConnection.getPopulationOfDistrcit("Limburg"));
        sqlConnection.disconnect();
    }
}
