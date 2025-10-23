package BankingManagementSystem;

import java.util.*;
import java.util.stream.Collectors;

public class BankingSystem {
    private List<Customer> customers;
    private List<BankAccount> accounts;
    private Scanner scanner;
    private int accountCounter;
    private int customerCounter;
    
    public BankingSystem() {
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.accountCounter = 1000;
        this.customerCounter = 100;
    }
    
    public void start() {
        System.out.println(" Welcome to Banking Management System!");
        
        while (true) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1: addCustomer(); break;
                case 2: openAccount(); break;
                case 3: depositMoney(); break;
                case 4: withdrawMoney(); break;
                case 5: applyLoan(); break;
                case 6: displayAccountDetails(); break;
                case 7: 
                    System.out.println("Thank you for using our Banking System!");
                    return;
                default: 
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
    
    private void displayMenu() {
        System.out.println("\n=== BANKING MENU ===");
        System.out.println("1. Add Customer");
        System.out.println("2. Open Account");
        System.out.println("3. Deposit Money");
        System.out.println("4. Withdraw Money");
        System.out.println("5. Apply Loan");
        System.out.println("6. Display Account Details");
        System.out.println("7. Exit");
        System.out.println("====================");
    }
    
    private void addCustomer() {
        System.out.println("\n--- Add New Customer ---");
        String name = getStringInput("Enter customer name: ");
        String email = getStringInput("Enter email: ");
        
        String customerId = "CUST" + customerCounter++;
        Customer customer = new Customer(customerId, name, email);
        customers.add(customer);
        
        System.out.println(" Customer added successfully!");
        System.out.println("Customer ID: " + customerId);
    }
    
    private void openAccount() {
        if (customers.isEmpty()) {
            System.out.println(" No customers available. Please add a customer first.");
            return;
        }
        
        System.out.println("\n--- Open New Account ---");
        displayCustomers();
        
        int custIndex = getIntInput("Select customer (enter number): ") - 1;
        
        if (custIndex < 0 || custIndex >= customers.size()) {
            System.out.println(" Invalid customer selection!");
            return;
        }
        
        Customer customer = customers.get(custIndex);
        
        System.out.println("Select account type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        int accType = getIntInput("Enter choice: ");
        
        double initialDeposit = getDoubleInput("Enter initial deposit: $");
        String accountNumber = "ACC" + accountCounter++;
        
        BankAccount account;
        
        if (accType == 1) {
            account = new SavingsAccount(accountNumber, initialDeposit, customer);
        } else if (accType == 2) {
            double overdraft = getDoubleInput("Enter overdraft limit: $");
            account = new CurrentAccount(accountNumber, initialDeposit, customer, overdraft);
        } else {
            System.out.println("❌ Invalid account type!");
            return;
        }
        
        customer.addAccount(account);
        accounts.add(account);
        
        System.out.println(" Account opened successfully!");
        System.out.println("Account Number: " + accountNumber);
    }
    
    private void depositMoney() {
        BankAccount account = selectAccount();
        if (account == null) return;
        
        double amount = getDoubleInput("Enter deposit amount: $");
        account.deposit(amount);
    }
    
    private void withdrawMoney() {
        BankAccount account = selectAccount();
        if (account == null) return;
        
        double amount = getDoubleInput("Enter withdrawal amount: $");
        account.withdraw(amount);
    }
    
    private void applyLoan() {
        if (customers.isEmpty()) {
            System.out.println("❌ No customers available.");
            return;
        }
        
        System.out.println("\n--- Apply for Loan ---");
        displayCustomers();
        
        int custIndex = getIntInput("Select customer (enter number): ") - 1;
        
        if (custIndex < 0 || custIndex >= customers.size()) {
            System.out.println(" Invalid customer selection!");
            return;
        }
        
        Customer customer = customers.get(custIndex);
        double amount = getDoubleInput("Enter loan amount: $");
        
        String loanId = "LOAN" + System.currentTimeMillis();
        Loan loan = new Loan(loanId, amount, customer);
        loan.processLoan();
        
        customer.addLoan(loan);
    }
    
    private void displayAccountDetails() {
        BankAccount account = selectAccount();
        if (account == null) return;
        
        System.out.println("\n--- Account Details ---");
        System.out.println(account);
        System.out.println("Customer: " + account.getCustomer().getName());
        
        System.out.println("\nRecent Transactions:");
        List<Transaction> transactions = account.getTransactions();
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            transactions.forEach(System.out::println);
        }
    }
    
    private BankAccount selectAccount() {
        if (accounts.isEmpty()) {
            System.out.println(" No accounts available.");
            return null;
        }
        
        System.out.println("\nSelect Account:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + ". " + accounts.get(i).getAccountNumber() + 
                             " - " + accounts.get(i).getCustomer().getName());
        }
        
        int accIndex = getIntInput("Enter account number: ") - 1;
        
        if (accIndex < 0 || accIndex >= accounts.size()) {
            System.out.println("❌ Invalid account selection!");
            return null;
        }
        
        return accounts.get(accIndex);
    }
    
    private void displayCustomers() {
        System.out.println("Available Customers:");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". " + customers.get(i));
        }
    }
    
    // Utility methods for input handling
    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    
    private int getIntInput(String prompt) {
        System.out.print(prompt);
        try {
            int value = scanner.nextInt();
            scanner.nextLine(); // consume newline
            return value;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // clear invalid input
            return -1;
        }
    }
    
    private double getDoubleInput(String prompt) {
        System.out.print(prompt);
        try {
            double value = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            return value;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // clear invalid input
            return -1;
        }
    }
    
    // Main method to run the application
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.start();
    }
}