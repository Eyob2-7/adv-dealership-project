package com.pluralsight;

import java.util.ArrayList;

public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    // Constructor
    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    private static void displayVehicles(ArrayList<Vehicle> vehicleList) {
        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            System.out.printf("%-8s %-6s %-12s %-12s %-12s %-10s %-10s %-10s%n",
                    "VIN", "Year", "Make", "Model", "Type", "Color", "Mileage", "Price");
            System.out.println("--------------------------------------------------------------------------------");

            for (Vehicle v : vehicleList) {
                System.out.printf("%-8d %-6d %-12s %-12s %-12s %-10s %-10d $%-10.2f%n",
                        v.getVin(), v.getYear(), v.getMake(), v.getModel(),
                        v.getVehicleType(), v.getColor(), v.getOdometer(), v.getPrice());
            }
        }
    }

    // Getters
    public int getVin() {return vin;}

    public int getYear() {return year;}

    public String getMake() {return make;}

    public String getModel() {return model;}

    public String getColor() {return color;}

    public String getVehicleType() {return vehicleType;}

    public int getOdometer() {return odometer;}

    public double getPrice() {return price;}


    // Setters
    public void setVin(int vin) {this.vin = vin;}

    public void setYear(int year) {this.year = year;}

    public void setMake(String make) {this.make = make;}

    public void setModel(String model) {this.model = model;}

    public void setVehicleType(String vehicleType) {this.vehicleType = vehicleType;}

    public void setColor(String color) {this.color = color;}

    public void setOdometer(int odometer) {this.odometer = odometer;}

    public void setPrice(double price) {this.price = price;}

    @Override
    public String toString() {
        return String.format("VIN: %d | Year: %d | Make: %s | Model: %s | Type: %s | Color: %s | Odometer: %d | Price: $%.2f",
                vin, year, make, model, vehicleType, color, odometer, price);
    }
}
