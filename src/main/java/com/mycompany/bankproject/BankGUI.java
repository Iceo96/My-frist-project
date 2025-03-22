
package com.mycompany.bankproject;
import javax.swing.*;
class BankGUI {
    private Bank bank = new Bank();

    public void start() {
        while (true) {
            String[] options = {"Create Account", "Show Details", "Deposit", "Withdraw", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Select an option", "Bank System",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 0) createAccount();
            else if (choice == 1) showDetails();
            else if (choice == 2) deposit();
            else if (choice == 3) withdraw();
            else if (choice == 4) {
                JOptionPane.showMessageDialog(null, "Thank you for using the bank system.");
                break;
            }
        }
    }

    private void createAccount() {
        String name = JOptionPane.showInputDialog("enter account holder name:");
        String accountNumber = JOptionPane.showInputDialog("enter account number:");
        String initialDepositStr = JOptionPane.showInputDialog("enter initial deposit:");

        double initialDeposit = Double.parseDouble(initialDepositStr);

        String[] accountTypes = {"Savings", "Current"};
        int accountTypeChoice = JOptionPane.showOptionDialog(null, "select Account Type", "account Type",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, accountTypes, accountTypes[0]);

        if (accountTypeChoice == 0) {
            bank.addAccount(new SavingsAccount(name, accountNumber, initialDeposit));
        } else if (accountTypeChoice == 1) {
            bank.addAccount(new CurrentAccount(name, accountNumber, initialDeposit));
        }

        JOptionPane.showMessageDialog(null, "Account created successfully!");
    }

    private void showDetails() {
        String accountNumber = JOptionPane.showInputDialog("Enter Account Number:");
        BankAccount account = bank.findAccount(accountNumber);

        if (account != null) {
            JOptionPane.showMessageDialog(null, account.getAccountDetails(), "Account Details", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Account not found");
        }
    }

    private void deposit() {
        String accountNumber = JOptionPane.showInputDialog("Enter Accunt Number:");
        BankAccount account = bank.findAccount(accountNumber);

        if (account != null) {
            String depositAmountStr = JOptionPane.showInputDialog("Enter deposit amount ");
            double depositAmount = Double.parseDouble(depositAmountStr);
            account.deposit(depositAmount);
            JOptionPane.showMessageDialog(null, "Deposit successful!");
        } else {
            JOptionPane.showMessageDialog(null, "Account not found");
        }
    }

    private void withdraw() {
        String accountNumber = JOptionPane.showInputDialog("Enter Account Number:");
        BankAccount account = bank.findAccount(accountNumber);

        if (account != null) {
            String withdrawAmountStr = JOptionPane.showInputDialog("Enter withdrawal amount:");
            double withdrawAmount = Double.parseDouble(withdrawAmountStr);
            if (account.withdraw(withdrawAmount)) {
                JOptionPane.showMessageDialog(null, "Withdrawal successful!");
            } else {
                JOptionPane.showMessageDialog(null, "Insufficient funds or limits.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Account not found.");
        }
    }
}