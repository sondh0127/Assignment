package com.oolt.assignment;

import java.time.LocalDate;

public class SavingAccount extends Account implements HasInterest {

    private static final double DEFAULT_INTEREST = 7.00;

    private static double interest;
    private LocalDate dateCreated;

    public SavingAccount(String owner, double balance) {
        super(owner, balance);
        interest = DEFAULT_INTEREST;
        dateCreated = DateUtil.now;
    }

    public SavingAccount(String owner, double balance, String dateCreated) {
        super(owner, balance);
        interest = DEFAULT_INTEREST;
        this.dateCreated = DateUtil.parse(dateCreated);
    }

    public SavingAccount(String owner, double balance, String dateCreated, double interest) {
        super(owner, balance);
        this.dateCreated = DateUtil.parse(dateCreated);
        SavingAccount.interest = interest;
    }

    public static double getInterest() {
        return interest;
    }

    public static void setInterest(double interest) {
        SavingAccount.interest = interest;
    }

    @Override
    public void getDetails() {
        System.out.println("\n- Saving Account:");
        System.out.println("Account owner: " + this.getOwner());
        System.out.println("Balance: " + this.getBalance());
        System.out.println("Date Created: " + DateUtil.format(this.getDateCreated()));
        System.out.println("Interest: " + getInterest());
    }

    /**
     * checking valid date by compare day/month of creation date and the day do action
     */
    private boolean checkValidDate() {
        return DateUtil.now.getMonthValue() == dateCreated.getMonthValue() &&
                DateUtil.now.getDayOfMonth() == dateCreated.getDayOfMonth();
    }

    @Override
    public void deposit(double amount) {
        if (checkValidDate()) {
            super.deposit(amount);
        } else {
            System.out.println("\nAccount: " + this.getOwner());
            System.out.println("=> Deposit is not allowed ! You can only deposit on " + dateCreated.getDayOfMonth() + "/" + dateCreated.getMonthValue());
        }
    }

    @Override
    public void deposit(double amount, String currency) {
        if (checkValidDate()) {
            super.deposit(amount, currency);
        } else {
            System.out.println("\nAccount: " + this.getOwner());
            System.out.println("=> Deposit is not allowed ! You can only deposit on " + dateCreated.getDayOfMonth() + "/" + dateCreated.getMonthValue());

        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (checkValidDate()) {
            return super.withdraw(amount);
        } else {
            System.out.println("\nAccount: " + this.getOwner());
            System.out.println("=> Withdraw is not allowed ! You can only Withdraw on " + dateCreated.getDayOfMonth() + "/" + dateCreated.getMonthValue());
        }
        return false;
    }

    @Override
    public boolean withdraw(double amount, String currency) {
        if (checkValidDate()) {
            return super.withdraw(amount, currency);
        } else {
            System.out.println("\nAccount: " + this.getOwner());
            System.out.println("=> Withdraw is not allowed ! You can only Withdraw on " + dateCreated.getDayOfMonth() + "/" + dateCreated.getMonthValue());
        }
        return false;
    }
    @Override
    public void updateBalance() {
        if (checkValidDate()) {
            this.balance += this.balance * interest / 100;
        } else {
            System.out.println("\nAccount: " + this.getOwner());
            System.out.println("=> Update failed! You can only update balance on " + dateCreated.getDayOfMonth() + "/" + dateCreated.getMonthValue());
        }

    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

}
