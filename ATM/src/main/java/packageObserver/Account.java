/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageObserver;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author diang
 */
public class Account implements Subject{
    private double balance;
    private List<Observer> observers;
    public Account(double initialBalance) {
        this.balance = initialBalance;
        this.observers = new ArrayList<>();

    }

    public Account() {
        this.balance = 0;
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
        }
    }

    public void transfer(Account target, double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            notifyObservers();
            target.balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    @java.lang.Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @java.lang.Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @java.lang.Override
    public void notifyObservers() {
        for(Observer o : observers){
            o.update(this);
        }
    }
}