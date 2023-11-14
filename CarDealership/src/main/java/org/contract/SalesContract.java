package org.contract;

import org.vehicle.Vehicle;

public class SalesContract extends Contract {
    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
    }

    public double getTax() {
        return 0.05;
    }

    public double getProcessingFee() {
        return 100;
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }

    @Override
    public String getContractString() {
        return String.format("SALE|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s \n",
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
                // totalPrice?
                // monthlyPayment?
        );
    }
}
