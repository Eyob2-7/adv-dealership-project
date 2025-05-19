package com.pluralsight;
/**
 * Handles a sales contract for a vehicle, including optional financing.
 * Calculates total price and monthly payment based on financing rules.
 */

public class SalesContract extends Contract{
    private boolean isFinanced;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced) {
        super(date, customerName, customerEmail, vehicleSold);
        this.isFinanced = isFinanced;
    }

    // Getter for whether financing was selected.
    public boolean isFinanced() {
        return isFinanced;
    }

    // Calculates the total cost of the sale.
    @Override
    public double totalPrice() {
        double price = getVehicleSold().getPrice();
        double tax = 0.5 * price;
        double recordingFee = 100;
        double processingFee = price < 10000 ? 295 : 495;
        return price + tax + recordingFee + processingFee;
    }

    /** Calculates the monthly payment using the loan amortization formula:
     * M = P * (r / (1 - (1 + r)^-n))
     * P: principal (total price)
     * r: monthly interest rate
     * n: number of months
     * */
    @Override
    public double monthlyPayment() {
        if(!isFinanced) return 0;
        double principal = totalPrice();
        int months = principal >= 10000 ? 48 : 24;
        double annualRate = principal >= 10000 ? 0.0425 : 0.0525;
        double monthlyRate = annualRate / 12;

        // Amortization formula
        return principal * (monthlyRate / (1- Math.pow(1 + monthlyRate, -months)));
    }
}