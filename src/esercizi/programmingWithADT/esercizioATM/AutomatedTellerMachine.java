package esercizi.programmingWithADT.esercizioATM;

import esercizi.programmingWithADT.esercizioATM.Exceptions.*;

import java.util.*;

public class AutomatedTellerMachine {
    private int moneyInsideATM;
    private Vector<BankAccount> listOfAccounts;
    private MachineState machineState;
    private int pinDigits;
    private boolean ActiveAccount;
    private BankAccount account;
    private String userPin;

    public enum MachineState {
        Authenticated, Waiting, Off
    }

    public AutomatedTellerMachine() {
        this.moneyInsideATM = 0;
        this.listOfAccounts = new Vector<BankAccount>();
        this.machineState = null;
        this.pinDigits = 0;
        this.ActiveAccount = false;
        this.account = null;
    }

    public AutomatedTellerMachine(int amount, BankAccount account) {
        assert (account != null);
        insertMoney(amount);
        this.listOfAccounts.add(account);
        this.machineState = MachineState.Off;
        this.pinDigits = 5;
        this.ActiveAccount = true;
        this.account = account;
    }

    public void startATM() {
        this.machineState = MachineState.Waiting;
    }

    public void stopATM() throws InvalidStateException {
        if (machineState == MachineState.Waiting) {
            this.machineState = MachineState.Off;
        } else {
            throw new InvalidStateException();
        }
    }

    public void authenticateUser(BankAccount account, String userPin) {
        int failAttemptsPin = 3;
        this.machineState = MachineState.Authenticated;
        this.account = account;
        account.createToken(account);
        for (int i = failAttemptsPin; i > 0; i--) {
            if (userPin.length() != this.pinDigits && !userPin.equals(account.getPin())) {
                failAttemptsPin = failAttemptsPin - 1;
            } else {
                this.userPin = userPin;
                return ;
            }
        }
        if (failAttemptsPin == 0) {
            blockAccount();
        }
    }

    public void logout() {
        this.machineState = MachineState.Waiting;
    }

    public int withdraw(int amount) throws NotEnoughMoneyException, TooMuchMoneyException {
        String msg1 = "La quantità di denaro richiesta per il prelievo è insufficiente nel ATM";
        String msg2 = "La quantità di denaro richiesta per il prelievo è troppo grande per il bilancio del vostro conto corrente";
        if (amount <= checkBalance(this.account) && amount <= this.moneyInsideATM) {
            this.moneyInsideATM = this.moneyInsideATM - amount;
            this.account.withdraw(amount);
            return amount;
        } else if (amount > this.moneyInsideATM) {
            throw new NotEnoughMoneyException(msg1);
        } else {
            throw new TooMuchMoneyException(msg2);
        }
    }

    public void deposit(int amount) {
        this.moneyInsideATM = this.moneyInsideATM + amount;
        this.account.deposit(amount);
    }

    public int checkBalance(BankAccount account) {
        return account.getBalance();
    }

    public void transferMoney(int amount, BankAccount account) {
        this.account.withdraw(amount);
        account.deposit(amount);
    }

    public String miniStatement(BankAccount account) {
        return "";
    }

    public void insertMoney(int amount) {
        this.moneyInsideATM = amount;
    }

    public void blockAccount() {
        this.ActiveAccount = false;
        logout();
    }
}
