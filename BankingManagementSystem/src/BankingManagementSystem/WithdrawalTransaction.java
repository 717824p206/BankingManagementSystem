package BankingManagementSystem;

public class WithdrawalTransaction extends Transaction {
    
    public WithdrawalTransaction(double amount, BankAccount account) {
        super(amount, account);
    }
    
    @Override
    public void processTransaction() {
        System.out.println("Withdrawal Transaction: $" + getAmount() + " from account " + 
                          getAccount().getAccountNumber());
    }
    
    @Override
    public String toString() {
        return "WITHDRAWAL [ID: " + getTransactionId() + ", Amount: $" + getAmount() + 
               ", Date: " + getDate() + "]";
    }
}