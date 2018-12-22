package esercizi.programmingWithADT.esercizioATM;

import esercizi.programmingWithADT.esercizioATM.exceptions.*;

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

    private AutomatedTellerMachine() {
        this.moneyInsideATM = 0;
        this.listOfAccounts = new Vector<>();
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

    public void startATM() throws InvalidStateException {
        String msg = "Lo stato è invalido";
        if (this.machineState == MachineState.Off) {
            this.machineState = MachineState.Waiting;
        } else {
            throw new InvalidStateException(msg);
        }
    }

    public void stopATM() throws InvalidStateException {
        String msg = "Lo stato è invalido";
        if (machineState == MachineState.Waiting) {
            this.machineState = MachineState.Off;
        } else {
            throw new InvalidStateException(msg);
        }
    }

    public void authenticateUser(BankAccount account, String userPin) throws InvalidStateException {
        String msg = "Lo stato è invalido";
        if (this.machineState == MachineState.Waiting) {
            this.machineState = MachineState.Authenticated;
            this.account = account;
            int counter = account.getFails();
            account.createToken(account);
            for (int i = 0; i < account.getFails(); i++) {
                if (userPin.length() != this.pinDigits && !userPin.equals(account.getPin())) {
                    counter = counter - 1;
                } else {
                    this.userPin = userPin;
                    return;
                }
            }
            if (counter == 0) {
                blockAccount();
            } else {
                logout();
            }
        } else {
            throw new InvalidStateException(msg);
        }
    }

    private void logout() throws InvalidStateException {
        String msg = "Lo stato è invalido";
        if (this.machineState == MachineState.Authenticated) {
            this.machineState = MachineState.Waiting;
        } else {
            throw new InvalidStateException(msg);
        }
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

    private int checkBalance(BankAccount account) {
        return account.getBalance();
    }

    public void transferMoney(int amount, BankAccount account) {
        this.account.withdraw(amount);
        account.deposit(amount);
    }

    public String miniStatement(BankAccount account) {
        return "";
    }

    private void insertMoney(int amount) {
        this.moneyInsideATM = amount;
    }

    private void blockAccount() throws InvalidStateException {
        this.ActiveAccount = false;
        logout();
    }
}
