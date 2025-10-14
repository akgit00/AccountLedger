package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private static final String FILE_PATH = "transactions.csv";

    //This part will be able to save a transaction to the csv file
    public static void saveTransaction(Transaction transaction) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            String line = String.format("%s|%s|%s|%s|%.2f",
                    transaction.getDate(),
                    transaction.getTime(),
                    transaction.getDescription(),
                    transaction.getVendor(),
                    transaction.getAmount());
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving transaction: " + e.getMessage());
        }
    }

    //This will be finished later to handle reading and writing to the CSV file
    public static List<Transaction> loadTransactions() {
        List<Transaction> transactions = new ArrayList<>();

        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return transactions; // Return empty list if file doesn't exist yet
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length != 5) continue;

                LocalDate date = LocalDate.parse(parts[0]);
                LocalTime time = LocalTime.parse(parts[1]);
                String description = parts[2];
                String vendor = parts[3];
                double amount = Double.parseDouble(parts[4]);

                Transaction transaction = new Transaction(date, time, description, vendor, amount);
                transactions.add(transaction);
            }

        }
        return transactions;
    }
}