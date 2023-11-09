package org.contract;

import org.vehicle.Vehicle;

public class LeaseContract extends Contract {

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, double totalPrice, double monthlyPayment) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
    }

    @Override
    public double getTotalPrice() {
        return getVehicleSold().getPrice() + (getVehicleSold().getPrice() * leaseFee());
    }

    @Override
    public double getMonthlyPayment() {
        return monthlyPayment();
    }

    public double expectedEndValue() {
        return getVehicleSold().getPrice() * .5;
    }

    public double leaseFee() {
        return 0.07;
    }

    public double monthlyPayment() {
        double amount = getVehicleSold().getPrice();
        double monthlyRate = 0.04 / .12;
        return (amount*monthlyRate) / (1-Math.pow(1+monthlyRate, -12));
    }
}
