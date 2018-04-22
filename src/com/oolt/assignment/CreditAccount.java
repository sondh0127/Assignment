package com.oolt.assignment;

import java.time.LocalDate;

public class CreditAccount extends Account implements HasInterest {

    private static double debitInterest;
    private static double creditInterest;
    private final double DEFAULT_DEBIT_INTEREST = 6.00;
    private final double DEFAULT_CREDIT_INTEREST = 2.00;
    private final double DEFAULT_LIMIT = 30000000;
    private double limit;
    private LocalDate dateCreated;


    public CreditAccount(String owner, double balance) {
        super(owner, balance);
        limit = DEFAULT_LIMIT;
        debitInterest = DEFAULT_DEBIT_INTEREST;
        creditInterest = DEFAULT_CREDIT_INTEREST;
        dateCreated = DateUtil.now;
    }

    public CreditAccount(String owner, double balance, double limit) {
        super(owner, balance);
        this.limit = limit;
        debitInterest = DEFAULT_DEBIT_INTEREST;
        creditInterest = DEFAULT_CREDIT_INTEREST;
        this.dateCreated = DateUtil.now;
    }

    public CreditAccount(String owner, double balance, String dateCreated, double limit, double debitInterest, double creditInterest) {
        super(owner, balance);
        this.dateCreated = DateUtil.parse(dateCreated);
        this.limit = limit;
        CreditAccount.debitInterest = debitInterest;
        CreditAccount.creditInterest = creditInterest;
    }

    public static double getDebitInterest() {
        return debitInterest;
    }

    public static void setDebitInterest(double debitInterest) {
        CreditAccount.debitInterest = debitInterest;
    }

    public static double getCreditInterest() {
        return creditInterest;
    }

    public static void setCreditInterest(double creditInterest) {
        CreditAccount.creditInterest = creditInterest;
    }

    @Override
    public void getDetails() {
        System.out.println("\nCreditAccount: ");
        System.out.println("Account owner: " + this.getOwner());
        System.out.println("Balance: " + this.getBalance());
        System.out.println("Date Created: " + DateUtil.format(this.getDateCreated()));
        System.out.println("Debit Interest: " + getDebitInterest());
        System.out.println("Credit Interest: " + getCreditInterest());
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
    }

    @Override
    public void deposit(double amount, String currency) {
        super.deposit(amount, currency);
    }

    @Override
    public boolean withdraw(double amount) {
        double max_amount = this.balance + this.limit;
        if (amount <= max_amount) {
            this.balance -= amount;
            return true;
        } else
            return false;
    }

    @Override
    public boolean withdraw(double amount, String currency) {
        double converted_amount = converter(amount, currency);
        return this.withdraw(converted_amount);
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public double getLimit() {
        return limit;
    }

    @Override
    public void updateBalance() {
        if (balance > 0) {
            balance += balance * debitInterest / 100;
        } else {
            balance += balance * creditInterest / 100;
        }
    }
}
