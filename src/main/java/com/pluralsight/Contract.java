package com.pluralsight;

/**
 * Abstract base class for all contract types (Sales and Lease).
 * Holds common customer and vehicle information.
 * Defines abstract methods for calculating total price and monthly payment
 */

public abstract class Contract {
    // Shared fields for all contracts
    private String date;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicleSold;
    private double totalPrice;
    private double monthlyPayment;

    public Contract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }

    // Getters and setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    // abstract method totalPrice() calculates the total price of the contract
    public abstract double totalPrice();

    // abstract method monthlyPayment() calculates the monthly payment amount
    public abstract double monthlyPayment();
}
