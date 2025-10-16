package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    private static void showSplashScreen() {
        System.out.println(Utils.BLUE +
                "\n==================================================");
        System.out.println("        💎 WELCOME TO THE LEDGER APP 💎");
        System.out.println("==================================================");
        System.out.println(Utils.YELLOW +
                "Track deposits, payments, and generate reports.");
        System.out.println("Developed By: Ahmad Kourouma");
        System.out.println("Current Time: " +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMMM d, yyyy hh:mm a")));
        System.out.println(Utils.RESET);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        showSplashScreen();

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
                    addTransaction(scanner, true);
                    break;
                case "P":
                    addTransaction(scanner, false);
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

    private static void addTransaction(Scanner scanner, boolean isDeposit) {
        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount = 0;
        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount entered. Transaction canceled.");
            return;
        }

        //Making payments negative
        if (!isDeposit) {
            amount = -Math.abs(amount);
        }
        Transaction transaction = new Transaction(
                LocalDate.now(),
                LocalTime.now(),
                description,
                vendor,
                amount
        );

        TransactionManager.saveTransaction(transaction);
        System.out.println("Transaction saved successfully! ✅");

    }
}