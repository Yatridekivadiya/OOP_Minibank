package model;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;
import model.annotation.Id;
import model.annotation.Positive;
import exception.BankException;
import exception.AccountNotFoundException;

public abstract class Account implements Transactable, InterestBearing {
    @Id
    protected int accountNumber;
    @Positive
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
public synchronized void deposit(long amount) throws InvalidAmountException {
    if (amount <= 0) {
        throw new InvalidAmountException("Deposit amount must be positive.");
    }

    balance += amount;
}

@Override
public synchronized boolean withdraw(long amount)
        throws InsufficientFundsException, InvalidAmountException {

    if (amount <= 0) {
        throw new InvalidAmountException("Withdrawal amount must be positive.");
    }

    if (balance < amount) {
       throw new InsufficientFundsException(
    "Insufficient funds.", (long) (amount - balance));
    }

    balance -= amount;
    return true;
}

    public abstract double interestRate();

    public abstract boolean canWithdraw(long amount);

    @Override
    public String toString() {
        return "Account{accountNumber=" + accountNumber
                + ", balance=" + balance + "}";
    }

    public void transfer(Account to, long amount) throws BankException {
    try {
        withdraw(amount);
        to.deposit(amount);
    } catch (InsufficientFundsException | InvalidAmountException e) {
        throw e;
    } finally {
        System.out.println("Transfer operation completed.");
    }
}
}
