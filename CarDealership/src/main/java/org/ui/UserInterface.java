package org.ui;

import org.contract.Contract;
import org.contract.ContractFileManager;
import org.contract.SalesContract;
import org.dealership.Dealership;
import org.dealership.DealershipFileManager;
import org.utils.Utils;
import org.vehicle.Vehicle;

import java.time.LocalDate;
import java.util.ArrayList;


public class UserInterface {
    Dealership dealership = new Dealership();
    DealershipFileManager dfm;
    ContractFileManager cfm;

    private void init() {
        // Create object
        dealership = DealershipFileManager.getDealership();
        dfm = new DealershipFileManager();
        cfm = new ContractFileManager();

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
                    "0) Sell vehicle \n" +
                    "X) Exit");
            char input = Utils.getCharInput();

            switch (input) {
                case '1':
                    getByPrice();
                    break;
                case '2':
                    getByMakeModelRequest();
                    break;
                case '3':
                    getByYearRequest();
                    break;
                case '4':
                    getByColor();
                    break;
                case '5':
                    getByMileage();
                    break;
                case '6':
                    getByType();
                    break;
                case '7':
                   getAllVehicles();
                    break;
                case '8':
                    addVehicleToCSV();
                    break;
                case '9':
                    removeVehicleFromCSV();
                    break;
                case '0':
                    sellLeaseVehicle();
                    break;
                case 'X':
                    System.exit(0);
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

    private void getByPrice() {
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

    public void getByYearRequest() {
        int minYear = Utils.getIntInput("Enter minimum year: ");
        int maxYear = Utils.getIntInput("Enter maximum year: ");

        System.out.println("Vehicles by Year:");
        displayVehicles(dealership.getVehiclesByYear(minYear, maxYear));
    }

    public void getByColor() {
        String color = Utils.getStringInput("Enter color: ");

        System.out.println("Vehicles by Color:");
        displayVehicles(dealership.getVehiclesByColor(color));
    }

    public void getByMileage() {
        int minMileage = Utils.getIntInput("Enter minimum mileage: ");
        int maxMileage = Utils.getIntInput("Enter maximum mileage: ");

        System.out.println("Vehicles by Mileage:");
        displayVehicles(dealership.getVehiclesByMileage(minMileage, maxMileage));
        System.out.println();
    }

    public void getByType() {
        String vehicleType = Utils.getStringInput("Enter vehicle type: ");

        System.out.println("Vehicles by Vehicle Type:");
        displayVehicles(dealership.getVehiclesByType(vehicleType));
    }

    public void getAllVehicles() {
        displayVehicles(dealership.getAllVehicles());
    }

    public void addVehicleToCSV() {
        System.out.println("Enter the vehicle details:");
        int vin = Utils.getIntInput("VIN: ");
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

    public void removeVehicleFromCSV() {
        int vin = Utils.getIntInput("Enter the vin of the vehicle you would like to remove: ");
        Vehicle vehicleToRemove = dealership.getVehiclesByVIN(vin);

        if (vehicleToRemove != null) {
            dealership.removeVehicle(vehicleToRemove);
            dfm.saveDealershipToCSV(dealership);
            System.out.println("Vehicle removed successfully!");
        } else {
            System.out.println("Vehicle not found!");
        }
    }

    public void sellLeaseVehicle(){
        String date = LocalDate.now().toString();
        int vin = Utils.getIntInput("Enter vehicle VIN: ");
        String customerName = Utils.getStringInput("Enter customer name: " );
        String customerEmail = Utils.getEmailInput("Enter customer email: ");
        String typeOfContract = Utils.getStringInput("Enter contract type (sell/lease): ");

        Vehicle findVehicle = dealership.getVehiclesByVIN(vin);

        if(findVehicle !=null){
            if(typeOfContract.equals("sell")){
                Contract salesContract = new SalesContract(date, customerName, customerEmail, findVehicle);
                cfm.saveContract(salesContract);
                dealership.removeVehicle(findVehicle);
                dfm.saveDealershipToCSV(dealership);
            }
            // Else if typeOfContract equal lease
            // ... new LeaseContract
             else {
                System.out.println("Please try again.");
            }
        }
    }
}
