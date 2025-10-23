package BankingManagementSystem;

//Inheritance: SavingsAccount IS-A BankAccount
public class SavingsAccount extends BankAccount {
 private static final double MINIMUM_BALANCE = 100.0;
 
 public SavingsAccount(String accountNumber, double initialBalance, Customer customer) {
     // super() calls parent class constructor
     super(accountNumber, Math.max(initialBalance, MINIMUM_BALANCE), customer);
 }
 
 // Method overriding - polymorphism in action
 @Override
 public boolean canWithdraw(double amount) {
     // Business rule: must maintain minimum balance
     return (getBalance() - amount) >= MINIMUM_BALANCE;
 }
 
 @Override
 public String toString() {
     return "Savings Account [Number: " + getAccountNumber() + 
            ", Balance: $" + getBalance() + "]";
 }
}
