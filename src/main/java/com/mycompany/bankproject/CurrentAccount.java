
package com.mycompany.bankproject;

class CurrentAccount extends BankAccount {
    private static final double OVERDRAFT_LIMIT = 1000.0;

    public CurrentAccount(String accountHolderName, String accountNumber, double Deposit) {
        super(accountHolderName, accountNumber, Deposit);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance - amount >= -OVERDRAFT_LIMIT) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

