
package com.mycompany.bankproject;

abstract class BankAccount {
    protected String accountHolderName;
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountHolderName, String accountNumber, double Deposit) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = Deposit;
    }

    public abstract void deposit(double amount);

    public abstract boolean withdraw(double amount);

    public String getAccountDetails() {
        return "Account Holder: " + accountHolderName + "\n" +
               "Account Number: " + accountNumber + "\n" +
               "Balance: " + balance;
    }
}

