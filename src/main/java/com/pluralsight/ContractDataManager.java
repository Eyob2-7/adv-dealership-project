package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

// Handles saving and reading contracts from the contracts.csv file.
public class ContractDataManager {
    public static final String FILE_PATH = "src/main/resources/contracts.csv";

    public void saveContract(Contract contract) {
        boolean fileExists = new File(FILE_PATH).exists();

        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            // Write header only if it's the first time writing to the file
            if (!fileExists) {
                writer.write("Type|Date|Customer Name|Email|VIN|Year|Make|Model|Color|Mileage|Price|Tax|Recording Fee|Processing Fee|Financing Option (yes/no)|Total Price|Monthly Payment\n");

            }

            Vehicle v = contract.getVehicleSold();
            String line;

            if (contract instanceof SalesContract) {
                SalesContract sc = (SalesContract) contract;
                double tax = v.getPrice() * 0.05;
                double recordingFee = 100;
                double processingFee = v.getPrice() < 10000 ? 295 : 495;
                String financing = sc.isFinanced() ? "yes" : "no";

                line = String.format("SALE|%s|%s|%s|%d|%d|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%s|%.2f|%.2f\n",
                        contract.getDate(),
                        contract.getCustomerName(),
                        contract.getCustomerEmail(),
                        v.getVin(),
                        v.getYear(),
                        v.getMake(),
                        v.getModel(),
                        v.getColor(),
                        v.getOdometer(),
                        v.getPrice(),
                        tax,
                        recordingFee,
                        processingFee,
                        financing,
                        contract.totalPrice(),
                        contract.monthlyPayment()
                );

            } else { // LeaseContract
                line = String.format(
                        "LEASE|%s|%s|%s|%d|%d|%s|%s|%s|%d|%.2f|%s|%s|%s|%s|%.2f|%.2f\n",
                        contract.getDate(),
                        contract.getCustomerName(),
                        contract.getCustomerEmail(),
                        v.getVin(),
                        v.getYear(),
                        v.getMake(),
                        v.getModel(),
                        v.getColor(),
                        v.getOdometer(),
                        v.getPrice(),
                        "N/A", "N/A", "N/A", "N/A",
                        contract.totalPrice(),
                        contract.monthlyPayment()
                );
            }
            writer.write(line);
        } catch (IOException e) {
            System.out.println("Error writing contract: " + e.getMessage());
        }

    }

    // Read all contracts from Contracts.csv file.
    public ArrayList<Contract> readContracts() {
        ArrayList<Contract> contracts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                String type = parts[0];
                String date = parts[1];
                String customerName = parts[2];
                String email = parts[3];
                int vin = Integer.parseInt(parts[4]);
                int year = Integer.parseInt(parts[5]);
                String make = parts[6];
                String model = parts[7];
                String color = parts[8];
                int mileage = Integer.parseInt(parts[9]);
                double price = Double.parseDouble(parts[10]);
                Vehicle vehicle = new Vehicle(vin, year, make, model, "", color, mileage, price);
                if (type.equalsIgnoreCase("SALE")) {
                    boolean isFinanced = parts[14].equalsIgnoreCase("yes");
                    contracts.add(new SalesContract(date, customerName, email, vehicle, isFinanced));
                } else if (type.equalsIgnoreCase("LEASE")) {
                    contracts.add(new LeaseContract(date, customerName, email, vehicle));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading contracts: " + e.getMessage());
        }
        return contracts;
    }
}
