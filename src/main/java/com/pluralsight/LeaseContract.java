package com.pluralsight;

// Represents a lease contract for a vehicle.
public class LeaseContract extends Contract{
    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
    }

    // Calculates the monthly lease payment.
    @Override
    public double monthlyPayment() {
        double monthlyCost = getVehicleSold().getPrice()/36;
        double interestFee = monthlyCost * 0.07;
        return monthlyCost + interestFee;
    }

    // Calculates the total lease cost over 36 months.
    @Override
    public double totalPrice() {
        return monthlyPayment() * 36;
    }




}
