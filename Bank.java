import java.util.ArrayList;
import java.util.Date;

class Account {
    private String accountNumber;
    private String holderName;
    private double balance;
    private ArrayList<String> transactionHistory;

   
    public Account(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance + " on " + new Date());
    }

   
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount + " on " + new Date());
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

   
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount + " on " + new Date());
            System.out.println("Successfully withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public double getBalance() {
        return balance;
    }

    // Print transaction history
    public void printTransactionHistory() {
        System.out.println("\nTransaction History for " + holderName + ":");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }
}

public class Bank{
    public static void main(String[] args) {
        // Create account
        Account acc1 = new Account("12345", "Shital Jadhav", 1000.0);

        // Perform some operations
        acc1.deposit(500);
        acc1.withdraw(200);
        acc1.withdraw(1500); 

        // Show balance
        System.out.println("Current Balance: " + acc1.getBalance());

        // Show transaction history
        acc1.printTransactionHistory();
    }
}
