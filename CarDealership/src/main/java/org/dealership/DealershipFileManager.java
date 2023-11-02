package org.dealership;

import org.vehicle.Vehicle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

    public static Dealership getDealership() {
        // load and read file
        try {
            BufferedReader vehicleReader;
            vehicleReader = new BufferedReader(new FileReader("inventory.csv"));
            String vehicleString = vehicleReader.readLine();

            // Use data to create Dealership object
            String[] dealershipString = vehicleString.split("\\|");
            Dealership dealership = new Dealership(dealershipString[0], dealershipString[1], dealershipString[2]);

            // Populate the inventory with a list of Vehicles
            while ((vehicleString = vehicleReader.readLine()) != null) {
                String[] vehicleData = vehicleString.split("\\|");

                dealership.addVehicle(new Vehicle(Integer.parseInt(vehicleData[0]), Integer.parseInt(vehicleData[1]), vehicleData[2], vehicleData[3], vehicleData[4], vehicleData[5], Integer.parseInt(vehicleData[6]), Double.parseDouble(vehicleData[7])));
            }
            System.out.println(dealership);
            return dealership;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveDealership() {

    }
}
