package org.ui;

import org.dealership.Dealership;
import org.dealership.DealershipFileManager;
import org.utils.Utils;
import org.vehicle.Vehicle;

import java.util.ArrayList;


public class UserInterface {
    Dealership dealership = new Dealership();
    DealershipFileManager dfm;

    private void init() {
        // Create object
        dealership = new Dealership();
        dfm = new DealershipFileManager();

    }

    public void display() {
        init();
        displayMenu();
    }

    public void displayMenu() {
        while (true) {
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

            switch (input) {
                case '7':
                    displayAllVehicles();
                    break;
                case '8':
                    addVehicleToCSV();
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

    private void getByPriceRequest() {
        // enter Price
        String minString = Utils.getStringInputCustom("Enter the min price: "); // Evaluate input to String for isEmpty
        double minPrice = Utils.getDoubleInput(minString); // Evaluate if amount is Empty.

        String maxString = Utils.getStringInputCustom("Enter the max price: "); // Evaluate input to String for isEmpty
        double maxPrice = Utils.getDoubleInput(maxString); // Evaluate if amount is Empty.

        // get Vehicle from Dealership
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(vehicles);
    }

    private void getByMakeModelRequest() {
        String make = Utils.getStringInput("Please enter a make: ");
        String model = Utils.getStringInput("Please enter the model: ");

        // get Vehicle from Dealership
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);


        displayVehicles(vehicles);
    }

    private void displayAllVehicles() {
        dealership.getAllVehicles();
    }

    public void addVehicleToCSV() {
        System.out.println("Enter the vehicle details:");
        int vin = Utils.getIntInput("VIN: " );
        int year = Utils.getIntInput("Year: ");
        String make = Utils.getStringInput("Make: ");
        String model = Utils.getStringInput("Model: ");
        String vehicleType = Utils.getStringInput("Vehicle Type: ");
        String color = Utils.getStringInput("Color: ");
        int odometer = Utils.getIntInput("Odometer: ");
        String priceString = Utils.getStringInputCustom("Price: ");
        double price = Utils.getDoubleInput(priceString);
        System.out.println("Vehicle added successfully.\n");

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(vehicle);
        dfm.saveDealershipToCSV(dealership);
    }
}
