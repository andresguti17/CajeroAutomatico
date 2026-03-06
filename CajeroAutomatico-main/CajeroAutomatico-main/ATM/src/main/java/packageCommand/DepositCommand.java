/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageCommand;


import packageObserver.Account;

public class DepositCommand implements Command {

    private final Account account;
    private final double amount;

    public DepositCommand(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }
       @Override
    public void execute() {
        account.deposit(amount);
    }

}