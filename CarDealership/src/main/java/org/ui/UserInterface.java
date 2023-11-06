package org.ui;

import org.dealership.Dealership;
import org.dealership.DealershipFileManager;
import org.utils.Utils;
import org.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Dealership dealership;

    private void init(){
        // Create object
        DealershipFileManager dfm = new DealershipFileManager();
        dfm.saveDealership();

    }
    public void display(){
        init();
        displayMenu();
    }

    public void displayMenu(){
        while(true){
            System.out.println("Choose the following: \n" +
                    "1) Vehicle By Price \n" +
                    "2) Vehicle By Make Model \n" +
                    "3) Vehicle By Year \n" +
                    "4) Vehicle By Color \n" +
                    "5) Vehicle By Mileage \n" +
                    "6) Vehicle By Type \n" +
                    "7) All Vehicles \n" +
                    "8) Add Vehicle \n" +
                    "9) Remove Vehicle \n" +
                    "0) Exit");
            char input = Utils.getCharInput();

            switch (input){
                case '1':
            }
        }
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        System.out.println("Displaying all the vehicles");

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getVin() + "|" + vehicle.getYear() + "|" +
                    vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" +
                    vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice()
            );
        }
    }
    private void processGetByPriceRequest() {
        // enter Price
        String minString = Utils.getStringInputCustom("Enter the min price: "); // Evaluate input to String for isEmpty
        double minPrice = Utils.getDoubleInput(minString); // Evaluate if amount is Empty.

        String maxString = Utils.getStringInputCustom("Enter the max price: "); // Evaluate input to String for isEmpty
        double maxPrice = Utils.getDoubleInput(maxString); // Evaluate if amount is Empty.

        // get Vehicle from Dealership
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(vehicles);
    }

    private void processGetByMakeModelRequest() {
        String make = Utils.getStringInput("Please enter a make: ");
        String model = Utils.getStringInput("Please enter the model: ");

        // get Vehicle from Dealership
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);

        // loop through return vehicles
        // print out each vehicle
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }
}
