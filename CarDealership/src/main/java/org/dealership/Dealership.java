package org.dealership;

import org.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    String name;
    String address;
    String phone;
    ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        inventory = new ArrayList<>();
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

    public ArrayList<Vehicle> getVehiclesByType(String type){
        ArrayList<Vehicle> inventoryWithinType = new ArrayList<>();
        String makeParsed = type.trim();
        for(Vehicle vehicle: inventory){
            if(vehicle.getColor().equalsIgnoreCase(type)){
                inventoryWithinType.add(vehicle);
            }
        }
        return inventoryWithinType;
    }

    public ArrayList<Vehicle> getAllVehicles(){
        return inventory;
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
