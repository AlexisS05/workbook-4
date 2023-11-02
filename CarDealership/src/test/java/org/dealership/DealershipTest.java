package org.dealership;

import org.junit.jupiter.api.Test;
import org.vehicle.Vehicle;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {



    @Test
    void addVehichleTest(){
        Dealership d = new Dealership("Paul", "222 Old Road", "607-272-4311");
        Vehicle v = new Vehicle(12345, 1992, "Honda", "Civic", "sedan", "black", 25090, 1500.);

        assertEquals(0, d.getInventory().size());
        d.addVehicle(v);
        assertEquals(1, d.getInventory().size());
    }

    @Test
    void removeVehicleTest(){
        Dealership d = new Dealership("Paul", "222 Old Road", "607-272-4311");
        Vehicle v = new Vehicle(12345, 1992, "Honda", "Civic", "sedan", "black", 25090, 1500.);
        d.addVehicle(v);
        assertEquals(1, d.getInventory().size());
        d.removeVehicle(v);
        assertThat(d.getVehiclesByMakeModel("Honda", "Civic"), not(hasItem(in(d.getVehiclesByMakeModel(v.getMake(), v.getModel())))));
        System.out.println("Test worked!");
    }
}