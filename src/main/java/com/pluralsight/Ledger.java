package com.pluralsight;

import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class Ledger {

    public static void showLedgerMenu(Scanner scanner) {
        boolean viewingLedger = true;

        while (viewingLedger) {
            System.out.println("\n---------- LEDGER MENU ----------");
            System.out.println("A) All Entries");
            System.out.println("D) Deposits Only");
            System.out.println("P) Payments Only");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "A":
                    displayTransactions("ALL");
                    break;
                case "D":
                    displayTransactions("DEPOSIT");
                    break;
                case "P":
                    displayTransactions("PAYMENT");
                    break;
                case "R":
                    Reports.showReportsMenu(scanner);
                    break;
                case "H":
                    viewingLedger = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void displayTransactions(String type) {
        List<Transaction> transactions = TransactionManager.loadTransactions();

        // Sort newest first
        transactions.sort(Comparator.comparing(Transaction::getDate)
                .thenComparing(Transaction::getTime)
                .reversed());

        System.out.println("\nDate       | Time     | Description          | Vendor           | Amount");
        System.out.println("--------------------------------------------------------------------------");

        /*
        1. setup variables for the count, expenses and income
        2. Loop through each transaction
        3. Filter through the transaction types
        4. Print the transaction details
        5. Use an if else statement to determine whether a transaction should be put to expenses or income
        6. Print a statement if there was no transaction found
        7. Print the total with correct color coordination
         */

        for (Transaction t : transactions) {
            if (type.equals("DEPOSIT") && t.getAmount() < 0) continue;
            if (type.equals("PAYMENT") && t.getAmount() >= 0) continue;
            System.out.println(t);

        }
        System.out.println("--------------------------------------------------------------------------");
    }
}