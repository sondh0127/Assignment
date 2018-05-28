package com.oop.exam;

public class CheckingAccount extends Account {

    private SavingAccount associateAccount;

    public CheckingAccount(long accountNumber, double balance, SavingAccount associateAccount) {
        super(accountNumber, balance);
        this.associateAccount = associateAccount;
    }

    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public boolean withdraw(double amount) {
        if (associateAccount == null)
            return super.withdraw(amount);
        if (amount > this.getBalance()) {
            double exceed = amount - getBalance();
            if (associateAccount.withdraw(exceed)) {
                return super.withdraw(getBalance());
            }
        } else {
            return super.withdraw(amount);
        }
        return false;
    }
}
