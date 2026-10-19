package model;

public abstract class Account implements Transactable, InterestBearing {
    protected int accountNumber;
    protected double balance;

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    
    @Override
    public void deposit(long amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public boolean withdraw(long amount) {
        if (canWithdraw(amount)) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
            return true;
        }

    System.out.println("Withdrawal not allowed.");
    return false;
}

    public abstract double interestRate();

    public abstract boolean canWithdraw(long amount);

    @Override
    public String toString() {
        return "Account{accountNumber=" + accountNumber
                + ", balance=" + balance + "}";
    }
}
