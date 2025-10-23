package BankingManagementSystem;

//Abstract base class for all transactions
public abstract class Transaction {
 private String transactionId;
 private double amount;
 private String date;
 private BankAccount account;
 
 public Transaction(double amount, BankAccount account) {
     this.transactionId = "TXN" + System.currentTimeMillis(); // Unique ID
     this.amount = amount;
     this.date = java.time.LocalDate.now().toString();
     this.account = account;
 }
 
 public abstract void processTransaction();
 
 // Getters
 public String getTransactionId() { return transactionId; }
 public double getAmount() { return amount; }
 public String getDate() { return date; }
 public BankAccount getAccount() { return account; }
}