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
        public static List<Transaction> loadTransactions () {
            List<Transaction> transactions = new ArrayList<>();

            File file = new File(FILE_PATH);
        }

    }
