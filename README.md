# Accounting Ledger Application

### A Java CLI app for tracking deposits, payments, and generating financial reports.

---

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [How It Works](#how-it-works)
- [File Format](#file-format)
- [Screens & Menus](#screens--menus)
- [My Favorite Part To Work On](#my-favorite-part-to-work-on)
- [Author](#author)

---

## Overview

The **Accounting Ledger Application** is a command-line Java program that helps individuals 
or small businesses track their **financial transactions** — deposits (income) and payments 
(expenses) — directly from the terminal.

All transactions are automatically saved to and read from a CSV file named `transactions.csv`, 
allowing users to view, search, and report on their data anytime.

---

## Features

**Add Deposits & Payments**
- Prompt-based input for description, vendor, and amount.
- Automatically timestamps transactions.

**Ledger View**
- Display all transactions, only deposits, or only payments.
- Shows newest transactions first.

**Reports**
- Month-to-date
- Previous month
- Year-to-date
- Previous year
- Search by vendor
- Custom search (by date range, vendor, description, amount)

**Persistent Data**
- Transactions are stored in a CSV file (`transactions.csv`).

**User-Friendly CLI Navigation**
- Simple text menus and keyboard shortcuts.

---

## How It Works

- Each transaction (deposit or payment) is represented by the `Transaction` class.
- Transactions are saved to and loaded from a `transactions.csv` file using the 
  `TransactionManager` class.
- The `Ledger` and `Reports` classes handle the user interface (menus and filters).
- The `Main` class runs the main program loop and manages navigation.

---

## File Format

All transactions are stored in a file named `transactions.csv` in the root directory.

Each line represents one transaction:

```
date|time|description|vendor|amount
```

**Example:**
```
2025-10-13|10:13:25|Ergonomic keyboard|Amazon|-89.50
2025-10-13|11:15:00|Invoice 1001 paid|Joe|1500.00
```

- Deposits (income) → Positive amounts  
- Payments (expenses) → Negative amounts  

---

## Screens & Menus

### Home Screen

<img width="410" height="353" alt="Screenshot 2025-10-16 at 2 45 27 PM" src="https://github.com/user-attachments/assets/45b01919-49fe-471b-ac45-e77cd84b48bc" />


```
==============================
   ACCOUNTING LEDGER SYSTEM
==============================
D) Add Deposit
P) Make Payment (Debit)
L) Ledger
X) Exit
```

### Ledger Menu

```
---------- LEDGER MENU ----------
A) All Entries
D) Deposits Only
P) Payments Only
R) Reports
H) Home
```

### Reports Menu

```
========== REPORTS MENU ==========
1) Month To Date
2) Previous Month
3) Year To Date
4) Previous Year
5) Search by Vendor
6) Custom Search
0) Back
```

---

## My Favorite Part To Work On

My favorite part of working on this project was going past my comfort zone and adding colors 
to my application. I utilized ANSI escape codes to format output and add color to make it more 
readable for the user. 

<img width="729" height="664" alt="Screenshot 2025-10-16 at 5 39 32 PM" src="https://github.com/user-attachments/assets/7fe808c2-121a-462d-af3d-bb8f98d21292" />


---

## Author

**Developed by:** A.K. Kourouma  
**Academy:** Year Up United  
**Capstone Project:** Capstone 1 — Accounting Ledger Application  
**GitHub:** [https://github.com/akgit00](https://github.com/akgit00)
