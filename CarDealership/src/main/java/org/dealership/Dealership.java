package org.dealership;

import org.vehicle.Vehicle;

import java.util.ArrayList;

public class Dealership {
    String name;
    String address;
    String phone;
    ArrayList<Vehicle> inventory;
    public Dealership(String name, String address, String phone, ArrayList<Vehicle> inventory) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = inventory;
    }
}
