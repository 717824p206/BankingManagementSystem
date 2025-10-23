package BankingManagementSystem;

import java.util.ArrayList;
import java.util.List;

// Abstract class - cannot be instantiated directly, only through child classes
public abstract class BankAccount {
    // Encapsulation: private fields with public getters
    private String accountNumber;
    private double balance;
    private Customer customer;
    private List<Transaction> transactions; // Composition relationship
    
    // Constructor - called when object is created
    public BankAccount(String accountNumber, double initialBalance, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.customer = customer;
        this.transactions = new ArrayList<>();
    }
    
    // Abstract method - must be implemented by child classes
    public abstract boolean canWithdraw(double amount);
    
    // Concrete methods - common functionality for all accounts
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            transactions.add(new DepositTransaction(amount, this));
            System.out.println("Deposit successful! New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && canWithdraw(amount)) {
            this.balance -= amount;
            transactions.add(new WithdrawalTransaction(amount, this));
            System.out.println("Withdrawal successful! New balance: $" + balance);
        } else {
            System.out.println("Withdrawal failed! Insufficient funds or invalid amount.");
        }
    }
    
    // Getters - encapsulation principle
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public Customer getCustomer() { return customer; }
    public List<Transaction> getTransactions() { return transactions; }}