# Banking Management System

## Problem Statement
Design and implement a Java console application for a Banking Management System that manages customers, accounts, deposits, withdrawals, and loans.

### Class Requirements:
1. BankAccount (Abstract)
2. SavingsAccount 
3. CurrentAccount
4. Customer
5. Transaction (Abstract)
6. DepositTransaction
7. WithdrawalTransaction
8. Loan

### Business Rules:
1. Customers can open savings or current accounts
2. Balance must be checked before withdrawals
3. Transactions must update balances immediately
4. Loans can only be approved if eligibility criteria are met
5. All transactions should link to specific accounts

### Console Interface Requirements:
- Add Customer
- Open Account
- Deposit Money
- Withdraw Money
- Apply Loan
- Display Account Details
- Exit

### OOP Principles Applied:
- Encapsulation (Private fields with public getters/setters)
- Inheritance (Parent-child class relationships)
- Polymorphism (Method overriding)
- Abstraction (Abstract classes)

---

## Student Information
- **Name:** AMRUTHA J
- **Roll No:** 717824P206
- **Course:** Java Programming
  
---

## How to Compile and Run

### Method 1: Using Command Prompt/Terminal (CMD)

#### Windows:
```cmd
# 1. Navigate to src directory
cd BankingManagementSystem\src

# 2. Compile all Java files
javac *.java

# 3. Run the application
java BankingSystem

**### Method 2: Using Eclipse IDE**
**Step 1: Create New Java Project

Open Eclipse IDE

Go to File → New → Java Project

Enter Project Name: BankingManagementSystem

Click Finish

**Step 2: Import Java Files**

Right-click on the src folder in your project

Select Import...

Choose File System and click Next

Browse and select the src folder from our project

Select all .java files and click Finish

**Step 3: Set Up Build Path**

Right-click on project → Build Path → Configure Build Path

Ensure Java version is correct (Java 8 or higher)

Click Apply and Close

**Step 4: Run the Application**

Locate BankingSystem.java in Package Explorer

Right-click on BankingSystem.java

Select Run As → Java Application

The console will open and show the banking menu
