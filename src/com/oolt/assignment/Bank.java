package com.oolt.assignment;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> bankAccounts = new ArrayList<>();

    public void add(Account account) {
        bankAccounts.add(account);
    }

    public void printAllAccount() {
        for (Account account : bankAccounts) {
            System.out.println("Owner: " + account.getOwner() + "\tBalance: " + account.getBalance());
        }
    }

    public double calculateTotalBalance() {
        double totalBalance = 0;
        for (Account account : bankAccounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }
}
