package org.contract;

import org.vehicle.Vehicle;

public class LeaseContract extends Contract {

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
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
        // amount * monthlyRate / (1- (1 + monthlyRate) ^ num of months for lease
        return (amount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -12));
    }

    @Override
    public String getContractString() {
        return String.format("LEASE|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s \n",
                getDate(),
                getCustomerName(),
                getCustomerEmail(),
                getVehicleSold().getVin(),
                getVehicleSold().getYear(),
                getVehicleSold().getMake(),
                getVehicleSold().getModel(),
                getVehicleSold().getVehicleType(),
                getVehicleSold().getColor(),
                getVehicleSold().getOdometer(),
                getVehicleSold().getPrice()
        );
    }
}
