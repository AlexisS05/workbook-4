package org.dealership;

import org.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

import static org.dealership.DealershipFileManager.getDealership;

public class Dealership {
    String name;
    String address;
    String phone;
    ArrayList<Vehicle> inventory = new ArrayList<>();
    public Dealership() {
    }



    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }




    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max){
        ArrayList<Vehicle> inventoryWithinRange = new ArrayList<>();
        for(Vehicle vehicle: inventory){
            if(vehicle.getPrice() >= min && vehicle.getPrice() <= max){
                inventoryWithinRange.add(vehicle);
            }
        }
        return inventoryWithinRange;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){
        ArrayList<Vehicle> inventoryWithinMakeModel = new ArrayList<>();
        String makeParsed = make.trim();
        String modelParsed = model.trim();
        for(Vehicle vehicle: inventory){
            if(vehicle.getMake().equalsIgnoreCase(makeParsed) && vehicle.getModel().equalsIgnoreCase(modelParsed)){
                inventoryWithinMakeModel.add(vehicle);
            }
        }
        return inventoryWithinMakeModel;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max){
        ArrayList<Vehicle> inventoryWithinRange = new ArrayList<>();
        for(Vehicle vehicle: inventory){
            if(vehicle.getYear() >= min && vehicle.getYear() <= max){
                inventoryWithinRange.add(vehicle);
            }
        }
        return inventoryWithinRange;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color){
        ArrayList<Vehicle> inventoryWithinColor = new ArrayList<>();
        String makeParsed = color.trim();
        for(Vehicle vehicle: inventory){
            if(vehicle.getColor().equalsIgnoreCase(color)){
                inventoryWithinColor.add(vehicle);
            }
        }
        return inventoryWithinColor;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max){
        ArrayList<Vehicle> inventoryWithinRange = new ArrayList<>();
        for(Vehicle vehicle: inventory){
            if(vehicle.getOdometer() >= min && vehicle.getOdometer() <= max){
                inventoryWithinRange.add(vehicle);
            }
        }
        return inventoryWithinRange;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                result.add(vehicle);
            }
        }
        return result;
    }

    public Vehicle getVehiclesByVIN(int vin) {
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVin() == vin) {
                System.out.println("Found vehicle: " + vehicle);
                return vehicle;
            }
        }
        System.out.println("Vehicle not found");
        return null;
    }

    public ArrayList<Vehicle> getAllVehicles(){
        return new ArrayList<>(inventory);
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }
    @Override
    public String toString() {
        return "Dealership{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
