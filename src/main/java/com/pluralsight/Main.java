package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n==============================");
            System.out.println("   ACCOUNTING LEDGER SYSTEM");
            System.out.println("==============================");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim().toUpperCase();
            switch (choice) {
                case "D":
                    System.out.println("Deposit option selected");//placeholder
                    break;
                case "P":
                    System.out.println("Payment option selected");//placeholder
                    break;
                case "L":
                    Ledger.showLedgerMenu(scanner);
                    break;
                case "X":
                    running = false;
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}