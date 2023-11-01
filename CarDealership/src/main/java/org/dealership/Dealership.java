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
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max){
        return null;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        return null;
    }

    public List<Vehicle> getVehiclesByYear(double min, double max){
        return null;
    }

    public List<Vehicle> getVehiclesByColor(String color){
        return null;
    }

    public List<Vehicle> getVehiclesByMileage(double min, double max){
        return null;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType){
        return null;
    }

    public List<Vehicle> getAllVehicles(){
        return inventory;
    }

    public void addVehicle(String vehicle){
    }

    public void removeVehicle(String vehicle){

    }
}
