package com.oop.exam;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Account> accounts;
    private int totalAccount;

    public Customer(String name) {
        this.name = name;
        accounts = new ArrayList<>(10);
        totalAccount = 0;
    }

    public void addAccount(Account account) {
        if (totalAccount < 10) {
            accounts.add(account);
            totalAccount++;
        }
    }

    public Account getAccount(long accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public void getDetail() {
        int totalBalance = 0;
        System.out.println("Total Account: " + totalAccount);
        for (Account account : accounts) {
            totalBalance += account.getBalance();
            if (account instanceof SavingAccount) {
                System.out.println("Account: " + account.getAccountNumber()
                        + "\tBalance: " + account.getBalance()
                        + "\tInterest: " + ((SavingAccount) account).getInterest());
            } else if (account instanceof CheckingAccount) {
                System.out.println("Account: " + account.getAccountNumber()
                        + "\tBalance: " + account.getBalance());
            }
        }
        System.out.println("Total Balance: " + totalBalance);
    }

}
