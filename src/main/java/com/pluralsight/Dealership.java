package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    // Constructor
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    // Adds a new vehicle to the inventory list
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    // Returns all vehicles in the dealership
    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    // Returns vehicles within the given price range
    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        ArrayList<Vehicle> result= new ArrayList<>();
        for(Vehicle v : inventory){
            if(v.getPrice() >= min && v.getPrice() <= max){
                result.add(v);
            }
        }
        return result;
    }

    // Returns vehicles that match a given make and model
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> result= new ArrayList<>();
        for(Vehicle v : inventory){
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)){
                result.add(v);
            }
        }

        return result;
    }

    // Returns vehicles within the given year range
    public ArrayList<Vehicle> getVehicleByYear(int min, int max) {
        ArrayList<Vehicle> result= new ArrayList<>();
        for(Vehicle v : inventory){
            if(v.getYear() >= min && v.getYear() <= max){
                result.add(v);
            }
        }
        return result;
    }

    // Returns vehicles that match a given color
    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> result= new ArrayList<>();
        for(Vehicle v : inventory){
            if(v.getColor().equalsIgnoreCase(color) ){
                result.add(v);
            }
        }
        return result;
    }

    // Returns vehicles within the given mileage range
    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> result= new ArrayList<>();
        for(Vehicle v : inventory){
            if(v.getOdometer() >= min && v.getOdometer() <= max){
                result.add(v);
            }
        }
        return result;
    }

    //Returns vehicles that match the given type
    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        ArrayList<Vehicle> result= new ArrayList<>();
        for(Vehicle v : inventory){
            if(v.getVehicleType().equalsIgnoreCase(vehicleType) ){
                result.add(v);
            }
        }
        return result;
    }

    // Removes a vehicle from inventory
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }


    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
