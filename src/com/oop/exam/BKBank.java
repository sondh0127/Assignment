package com.oop.exam;

import java.util.ArrayList;

public class BKBank {
    private String bankName;
    private ArrayList<Customer> customers;

    public BKBank(String bankName) {
        this.bankName = bankName;
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public static void main(String[] args) {
        BKBank bank = new BKBank("BKBank");
        Customer customerB = new Customer("Trần Thị B");
        SavingAccount savingAccountB = new SavingAccount(10001221, 20000000, 1.5);
        CheckingAccount checkingAccountB = new CheckingAccount(100012222, 3000000, savingAccountB);
        customerB.addAccount(savingAccountB);
        customerB.addAccount(checkingAccountB);
        customerB.getDetail();
    }

}
