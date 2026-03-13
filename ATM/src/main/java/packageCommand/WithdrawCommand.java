/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageCommand;

import packageObserver.Account;
import packageStrategy.FeeStrategy;

public class WithdrawCommand implements Command {

    private final Account account;
    private final double amount;
    private FeeStrategy feeStrategy;

    public WithdrawCommand(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }
    @Override
    public void execute() {
        double finalAmount = amount + (amount * feeStrategy.calculateFee(Account.getContinent()));
        account.withdraw(finalAmount);
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }
}