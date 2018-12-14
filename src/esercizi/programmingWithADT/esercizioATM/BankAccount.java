package esercizi.programmingWithADT.esercizioATM;

import java.util.*;

public class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private int balance;
    private String userPin;
    private int token;
    private Vector<Transactions> transactions;

    public BankAccount() {
        this.accountHolderName = null;
        this.accountNumber = null;
        this.balance = 0;
        this.userPin = null;
        this.token = 0;
        this.transactions = null;
    }

    public BankAccount(String name, String iban, int balance, String pin) {
        this.accountHolderName = name;
        this.accountNumber = iban;
        this.balance = balance;
        this.userPin = pin;
        this.token = 0;
    }

    public void withdraw(int amount) {
        this.balance = this.balance - amount;
    }

    public void deposit(int amount) {
        this.balance = this.balance + amount;
    }

    public String getPin() {
        return this.userPin;
    }

    public int getBalance() {
        return this.balance;
    }

    public void createToken(BankAccount account) {
        account.token = this.token + 1;
    }

    public String getTransactions() {
        return "";
    }

    private class Transactions {
        final String description;
        final int amountOfOperation;
        final Date date;
        final int ID;

        public Transactions() {
            description = null;
            amountOfOperation = 0;
            date = null;
            ID = 0;
        }

        public Transactions(String operation, int amount, Date day, int id) {
            description = operation;
            amountOfOperation = amount;
            date = day;
            ID = id;
        }

        public String toString() {
            String message = "";
            message = message + this.date + " | " + this.description + " | " + this.amountOfOperation + " |";
            return message;
        }
    }
}
