package com.oolt.assignment;

import java.util.ArrayList;

public class Bank {
    private String bankName;
    private String bankAddress;
    private ArrayList<Account> bankAccounts;

    public Bank(String bankName, String bankAddress) {
        this.bankName = bankName;
        this.bankAddress = bankAddress;
        bankAccounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        bankAccounts.add(account);
    }

    public void printAllAccount() {
        System.out.println("Band name: " + bankName);
        System.out.println("Band address: " + bankAddress);
        System.out.println("Account List: ");
        System.out.println("===============");
        for (Account account : bankAccounts) {
            account.getDetails();
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
