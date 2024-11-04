package com.ps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class ContractFileManager {

    public static void saveContract(Contract contract) {
        try {
            // Open the file in append mode
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("contracts.csv", true));

            // Determine transaction type
            String transactionType = (contract instanceof SalesContract) ? "SALE" : "LEASE";

            Vehicle vehicle = contract.getVehicle();

            String contractLine = String.format("%s|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|",
                    transactionType,
                    contract.getDate(),
                    contract.getCustomerName(),
                    contract.getEmail(),
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice()
            );


            if (contract instanceof SalesContract) {
                SalesContract salesContract = (SalesContract) contract;
                contractLine += String.format("%.2f|%.2f|%.2f|%.2f|%s|%.2f\n",
                        salesContract.getTax() * vehicle.getPrice(),
                        salesContract.getRecFee(),
                        salesContract.getProFee(),
                        salesContract.getTotalPrice(),
                        salesContract.isFinanced() ? "YES" : "NO",
                        salesContract.getMonthlyPayment()
                );
            } else if (contract instanceof LeaseContract) {
                LeaseContract leaseContract = (LeaseContract) contract;
                contractLine += String.format("%.2f|%.2f|%.2f|%.2f|%.2f\n",
                        leaseContract.getEndValue(),
                        leaseContract.getLeaseFee(),
                        leaseContract.getTotalPrice(),
                        "YES",
                        leaseContract.getMonthlyPayment()
                );
            }

            bufferedWriter.write(contractLine);
            bufferedWriter.close();

            System.out.println("Contract saved successfully.");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}