package com.pluralsight;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Reports {
    public static void showReportsMenu(Scanner scanner) {
        boolean viewingReports = true;


        while (viewingReports) {
            System.out.println("\n========== REPORTS MENU ==========");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.println("Month to Date report");
                    break;
                case "2":
                    System.out.println("Previous Month report");
                    break;
                case "3":
                    System.out.println("Year to Date report");
                    break;
                case "4":
                    System.out.println("Previous Year report");
                    break;
                case "5":
                    System.out.println("Search by Vendor");
                    break;
                case "0":
                    viewingReports = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");

            }
        }
    }


    //this section is for adding methods that will display different report types
    private static void showMonthToDate() {
        List<Transaction> all = TransactionManager.loadTransactions();
        LocalDate now = LocalDate.now();
        List<Transaction> filtered = all.stream()
                .filter(t -> t.getDate().getYear() == now.getYear()
                        && t.getDate().getMonth() == now.getMonth())
                .collect(Collectors.toList());
        //displayResults will go here
    }

    private static void showPreviousMonth() {
        List<Transaction> all = TransactionManager.loadTransactions();
        LocalDate now = LocalDate.now();
        YearMonth lastMonth = YearMonth.from(now).minusMonths(1);

        List<Transaction> filtered = all.stream()
                .filter(t -> YearMonth.from(t.getDate()).equals(lastMonth))
                .collect(Collectors.toList());
        //displayResults will go here
    }

    private static void showYearToDate() {
        List<Transaction> all = TransactionManager.loadTransactions();
        int currentYear = LocalDate.now().getYear();
        List<Transaction> filtered = all.stream()
                .filter(t -> t.getDate().getYear() == currentYear)
                .collect(Collectors.toList());
        //displayResults will go here
    }

    private static void showPreviousYear() {
        List<Transaction> all = TransactionManager.loadTransactions();
        int lastYear = LocalDate.now().getYear() - 1;
        List<Transaction> filtered = all.stream()
                .filter(t -> t.getDate().getYear() == lastYear)
                .collect(Collectors.toList());
        //displayResults will go here
    }

    private static void searchByVendor(Scanner scanner) {
        System.out.print("Enter vendor name to search: ");
        String vendor = scanner.nextLine().trim().toLowerCase();


    }
}