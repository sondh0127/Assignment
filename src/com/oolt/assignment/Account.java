package com.oolt.assignment;

public abstract class Account{
    protected double balance;
    private String owner;

    // Constructor

    public Account(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public abstract void getDetails();


    //    Assume that the main currency is VND
    public void deposit(double amount) {
        this.balance += amount;
    }

    public void deposit(double amount, String currency) {
        deposit(converter(amount, currency));
    }

    public boolean withdraw(double amount) {
        if (amount > balance)
            return false;
        else {
            balance -= amount;
            return true;
        }
    }

    // old assignment
    public boolean withdraw(double amount, String currency) {
        double converted_amount = converter(amount, currency);
        return withdraw(converted_amount);
    }

    protected double converter(double amount, String currency) {
        if ("USD".equals(currency)) {
            return 22764.01 * amount; // 1 USD =22,764.01VND
        } else if ("GBP".equals(currency)) {
            return 31528.83 * amount; // 1 GBP =31,528.83VND
        } else if ("EUR".equals(currency)) {
            return 28016.03 * amount; // 1 EUR =28,016.03VND
        } else if ("INR".equals(currency)) {
            return 350.204 * amount;
        } else if ("AUD".equals(currency)) {
            return 17874.67 * amount;
        }
        return amount;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void checkBalance() {
        System.out.println(this.balance + " VND");
    }
}
