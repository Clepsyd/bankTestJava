package com.banktest;

public class Account {
    private double balance;

    public Account() {
        balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount) {
        if (amount <= 0) throw new ArithmeticException("Cannot deposit a negative sum!");
        balance += amount;
        return balance;
    }

    public double withdraw(double amount) {
        balance -= amount;
        return balance;
    }
}
