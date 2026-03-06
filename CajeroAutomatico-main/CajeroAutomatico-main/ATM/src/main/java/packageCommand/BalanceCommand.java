/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageCommand;

import packageObserver.Account;

public class BalanceCommand implements Command {

    private final Account account;

    public BalanceCommand(Account account) {
        this.account = account;
    }

    @Override
    public void execute() {
        System.out.println("Balance: " + account.getBalance());
    }

}

