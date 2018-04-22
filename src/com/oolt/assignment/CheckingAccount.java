package com.oolt.assignment;

public class CheckingAccount extends Account {

    public CheckingAccount(String owner, double balance) {
        super(owner, balance);
    }

    @Override
    public void getDetails() {
        System.out.println("\n- Checking Account: ");
        System.out.println("Account owner: " + this.getOwner());
        System.out.println("Balance: " + this.getBalance());
    }
}
