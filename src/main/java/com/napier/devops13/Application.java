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

        SQLConnection connection = new SQLConnection();
        if(args.length < 1){
            connection.connect("localhost:33060", 30000);
        }else{
            connection.connect(args[0], Integer.parseInt(args[1]));
        }

        System.out.print("The World's Population :: ");
        System.out.println(connection.getWorldPopulation());
        System.out.print("Great Britain's Population :: ");
        System.out.println(connection.getPopulationOfCountry("GBR"));
        System.out.print("Africa's Population :: ");
        System.out.println(connection.getPopulationOfContinent("Africa"));
        System.out.print("Caribbean's Population :: ");
        System.out.println(connection.getPopulationOfRegion("Caribbean"));
        System.out.print("Dubai's Population :: ");
        System.out.println(connection.getPopulationOfCityID("64"));
        System.out.print("Limburgh's Population :: ");
        System.out.println(connection.getPopulationOfDistrcit("Limburg"));
        connection.disconnect();
    }
}
