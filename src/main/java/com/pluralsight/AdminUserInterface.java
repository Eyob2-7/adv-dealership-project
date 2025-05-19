package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminUserInterface {

    // Display
    public static void display(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n------ Admin Dashboard ------ ");
        System.out.println("1. List All Contracts");
        System.out.println("2. List Last 10 Contracts");
        System.out.println("Choose option:");
        int option = scanner.nextInt();

        ContractDataManager cdm = new ContractDataManager();
        ArrayList<Contract> contracts = cdm.readContracts();

        if (contracts.isEmpty()){
            System.out.println("No contracts found");
            return;
        }
        switch (option) {
            case 1:
                printContracts(contracts);
                break;
            case 2:
                int start = Math.max(contracts.size() - 10, 0);
                ArrayList<Contract> last10 = new ArrayList<>(contracts.subList(start, contracts.size()));
                printContracts(last10);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
    private static void printContracts(ArrayList<Contract> contracts) {
        for (Contract c : contracts) {
            System.out.printf("%s | %s | %-20s | $%.2f | Monthly: $%.2f\n",
                    (c instanceof SalesContract ? "SALE" : "LEASE"),
                    c.getDate(),
                    c.getCustomerName(),
                    c.totalPrice(),
                    c.monthlyPayment()
            );
        }
    }
}
