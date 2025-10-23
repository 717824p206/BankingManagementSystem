package BankingManagementSystem;

public class Loan {
    private String loanId;
    private double amount;
    private double interestRate;
    private String status; // "PENDING", "APPROVED", "REJECTED"
    private Customer customer;
    
    public Loan(String loanId, double amount, Customer customer) {
        this.loanId = loanId;
        this.amount = amount;
        this.customer = customer;
        this.interestRate = 8.5; // Default interest rate
        this.status = "PENDING";
    }
    
    // Business rule: Loan eligibility check
    public boolean isEligible() {
        double totalBalance = customer.getAccounts().stream()
            .mapToDouble(BankAccount::getBalance)
            .sum();
        
        // Simple eligibility: total balance should be at least 20% of loan amount
        return totalBalance >= (amount * 0.2);
    }
    
    public void processLoan() {
        if (isEligible()) {
            this.status = "APPROVED";
            System.out.println("Loan APPROVED for $" + amount);
        } else {
            this.status = "REJECTED";
            System.out.println("Loan REJECTED - eligibility criteria not met");
        }
    }
    
    // Getters
    public String getLoanId() { return loanId; }
    public double getAmount() { return amount; }
    public double getInterestRate() { return interestRate; }
    public String getStatus() { return status; }
    public Customer getCustomer() { return customer; }
    
    @Override
    public String toString() {
        return "Loan [ID: " + loanId + ", Amount: $" + amount + 
               ", Status: " + status + ", Interest: " + interestRate + "%]";
    }
}