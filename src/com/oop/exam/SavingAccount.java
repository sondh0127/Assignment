package com.oop.exam;

public class SavingAccount extends Account {

    private double interest;

    public SavingAccount(long accountNumber, double balance, double interest) {
        super(accountNumber, balance);
        this.interest = interest;
    }

    public double getInterest() {
        return interest;
    }
}
