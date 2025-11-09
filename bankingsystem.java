import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a bank account
class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0.0; // Initial balance is zero
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            System.out.println("Withdrawal amount must be positive!");
        }
    }
}

// Class to represent the banking system
class BankingSystem {
    private ArrayList<BankAccount> accounts;

    public BankingSystem() {
        accounts = new ArrayList<>();
    }

    public void createAccount(String accountNumber, String accountHolderName) {
        BankAccount newAccount = new BankAccount(accountNumber, accountHolderName);
        accounts.add(newAccount);
        System.out.println("Account created successfully for " + accountHolderName);
    }

    public BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null; // Account not found
    }

    public void deposit(String accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
            System.out.println("New balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
            System.out.println("New balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }
}

// Main class to run the banking system
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankingSystem bankingSystem = new BankingSystem();

        while (true) {
            System.out.println("\n--- Banking System ---");
            System.out.println("1. Open New Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Open New Account
                    System.out.print("Enter Account Number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String holderName = scanner.nextLine();

