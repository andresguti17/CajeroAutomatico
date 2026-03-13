/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageObserver;
/**
 *
 * @author diang
 */
import java.util.ArrayList;
import java.util.List;

public class Account implements Subject {

    private String cardNumber;
    private String pin;
    private double balance;
    private List<Observer> observers;

    public Account(String cardNumber, String pin, double initialBalance) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = initialBalance;
        this.observers = new ArrayList<>();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public boolean validatePin(String inputPin) {
        return pin.equals(inputPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            notifyObservers();
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            notifyObservers();
        } else {
            System.out.println("Fondos insuficientes.");
        }
    }

    public void transfer(Account target, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            target.balance += amount;

            notifyObservers();
            target.notifyObservers();
        } else {
            System.out.println("Transferencia no válida.");
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }
}