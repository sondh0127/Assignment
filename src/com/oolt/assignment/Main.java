package com.oolt.assignment;

public class Main {

    public static void main(String[] args) {
        System.out.println("Part 3:");
        // Create 2 object
        SavingAccount savingAccount = new SavingAccount("Stephen", 1000, "27/10/2015");
        CheckingAccount checkingAccount = new CheckingAccount("Anna", 1000);

        // Upcastting
        Account upcastSavingaccount = savingAccount;
        Account upcastCheckingAccount = checkingAccount;
        upcastSavingaccount.getDetails();
        upcastCheckingAccount.getDetails();
        // Downcastting
        SavingAccount downcastSavingAccount = (SavingAccount) upcastSavingaccount;
        downcastSavingAccount.getDetails();
        CheckingAccount downcastCheckingAccount = (CheckingAccount) upcastCheckingAccount;
        downcastCheckingAccount.getDetails();

        CheckingAccount annaCheckingAccount = new CheckingAccount("Tim", 30000);
        System.out.println("\n Part 4:");
        // Create new bank and add all some account to the bank
        Bank bank = new Bank("ACB Bank", "Toronto");
        bank.addAccount(savingAccount);
        bank.addAccount(annaCheckingAccount);
        bank.addAccount(checkingAccount);

        // print all detail of bank
        bank.printAllAccount();

//        oldmethod(checkingAccount);


    }

    private static void oldmethod(CheckingAccount checkingAccount) {
        // checkingAccount demo
        CheckingAccount checkingAccountDemo = new CheckingAccount("Ming", 200);
        checkingAccount.getDetails();


        //savingAccount demo
        // setting Date of Bank to 01/04/2018
        DateUtil.changeNow("01/04/2018");
        System.out.println("\nToday: " + DateUtil.format(DateUtil.now));

        SavingAccount heenSavingAccount = new SavingAccount("Heen", 2000, "01/04/2017");
        SavingAccount stephenSavingAccount = new SavingAccount("Stephen", 1000, "08/04/2017");

        heenSavingAccount.getDetails();
        stephenSavingAccount.getDetails();

        heenSavingAccount.deposit(200);
        stephenSavingAccount.deposit(200);

        heenSavingAccount.getDetails();
        stephenSavingAccount.getDetails();

        // setting Date of Bank to 08/04/2018
        DateUtil.changeNow("08/04/2018");
        System.out.println("\nToday: " + DateUtil.format(DateUtil.now));

        stephenSavingAccount.deposit(200);
        stephenSavingAccount.getDetails();

        stephenSavingAccount.updateBalance();
        stephenSavingAccount.getDetails();


        //creaditAccount demo
        CreditAccount cuongCreditAccount = new CreditAccount("Cuong", 0, "08/04/2017", 30000, 6.5, 2.5);

        cuongCreditAccount.getDetails();

        cuongCreditAccount.withdraw(1000);

        cuongCreditAccount.getDetails();

        // demo over withdraw balance
        cuongCreditAccount.withdraw(30000);

        cuongCreditAccount.getDetails();

        cuongCreditAccount.updateBalance();

        cuongCreditAccount.getDetails();
    }
}
