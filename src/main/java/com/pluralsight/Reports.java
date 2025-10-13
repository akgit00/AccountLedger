package com.pluralsight;

import java.util.Scanner;

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
        }
    }
}