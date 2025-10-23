package BankingManagementSystem;

public class CurrentAccount extends BankAccount {
    private double overdraftLimit;
    
    public CurrentAccount(String accountNumber, double initialBalance, Customer customer, double overdraftLimit) {
        super(accountNumber, initialBalance, customer);
        this.overdraftLimit = overdraftLimit;
    }
    
    @Override
    public boolean canWithdraw(double amount) {
        // Different business rule: can go into overdraft up to limit
        return (getBalance() - amount) >= -overdraftLimit;
    }
    
    @Override
    public String toString() {
        return "Current Account [Number: " + getAccountNumber() + 
               ", Balance: $" + getBalance() + ", Overdraft: $" + overdraftLimit + "]";
    }
}
