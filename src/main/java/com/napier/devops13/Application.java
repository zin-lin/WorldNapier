package com.napier.devops13;

/**
 Author : Zin Lin Htun
 Matriculation : 40542237
 Application class : main class
*/
public class Application {

    public void printInFormat(String name, long ans){
        System.out.println( name +  "'s Population :: " + ans);
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

        app.printInFormat("The World", connection.getWorldPopulation());
        app.printInFormat("Great Britain", connection.getWorldPopulation());
        app.printInFormat("Africa", connection.getPopulationOfCountry("GBR"));
        app.printInFormat("Caribbean",connection.getPopulationOfRegion("Caribbean"));
        app.printInFormat("Dubai",connection.getPopulationOfCityID("64"));
        app.printInFormat("Limburgh", connection.getPopulationOfDistrcit("Limburg"));

        connection.disconnect();
    }
}
