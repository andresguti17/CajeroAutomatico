/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageCommand;


import packageObserver.Account;
import packageStrategy.FeeStrategy;

public class TransferCommand implements Command {

    private final Account fromAccount;
    private final Account toAccount;
    private final double amount;
    private FeeStrategy feeStrategy;

    public TransferCommand(Account fromAccount, Account toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    @Override
    public void execute() {
        double finalAmount = amount + (amount * feeStrategy.calculateFee(Account.getContinent()));
        fromAccount.transfer(toAccount, finalAmount);
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }
}