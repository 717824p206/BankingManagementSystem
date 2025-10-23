package BankingManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private String email;
    private List<BankAccount> accounts; // Association: Customer HAS-MANY BankAccounts
    private List<Loan> loans; // Association: Customer HAS-MANY Loans
    
    public Customer(String customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.accounts = new ArrayList<>();
        this.loans = new ArrayList<>();
    }
    
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }
    
    public void addLoan(Loan loan) {
        loans.add(loan);
    }
    
    // Getters
    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public List<BankAccount> getAccounts() { return accounts; }
    public List<Loan> getLoans() { return loans; }
    
    @Override
    public String toString() {
        return "Customer [ID: " + customerId + ", Name: " + name + ", Email: " + email + "]";
    }
} 	