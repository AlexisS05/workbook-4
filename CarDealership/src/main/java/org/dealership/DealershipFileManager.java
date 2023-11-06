package org.dealership;

import org.vehicle.Vehicle;

import java.io.*;

public class DealershipFileManager {

    private String fileName;

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

    public void saveDealershipToCSV(Dealership dealership) { // write dealership info, then vehicles
        String dealerName = dealership.getName();
        String address = dealership.getAddress();
        String phone = dealership.getPhone();
        String dealershipInfo = String.format("%s|%s|%s\n", address, dealerName, phone);

        try (FileWriter fileWriter = new FileWriter("inventory.csv", false)) {
            fileWriter.write(dealershipInfo);

            for (Vehicle vehicle : dealership.getAllVehicles()) {
                String vehicleInfo = String.format("%d|%d|%s|%s|%s|%s|%d|%.2f\n",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice());
                fileWriter.write(vehicleInfo);
            }
            fileWriter.close();

            System.out.println("Dealership inventory saved to file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving dealership inventory");
        }
    }
}
