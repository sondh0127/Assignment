package com.oolt.assignment;

public class Main {

    public static void main(String[] args) {

        // checkingAccount demo
        CheckingAccount checkingAccount = new CheckingAccount("Ming", 200);
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
