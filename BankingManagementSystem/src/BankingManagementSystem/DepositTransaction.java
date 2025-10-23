package BankingManagementSystem;

public class DepositTransaction extends Transaction {
    
    public DepositTransaction(double amount, BankAccount account) {
        super(amount, account);
    }
    
    @Override
    public void processTransaction() {
        // Deposit logic is already handled in BankAccount.deposit()
        System.out.println("Deposit Transaction: $" + getAmount() + " to account " + 
                          getAccount().getAccountNumber());
    }
    
    @Override
    public String toString() {
        return "DEPOSIT [ID: " + getTransactionId() + ", Amount: $" + getAmount() + 
               ", Date: " + getDate() + "]";
    }
}