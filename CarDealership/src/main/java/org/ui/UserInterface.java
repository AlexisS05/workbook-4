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
}
