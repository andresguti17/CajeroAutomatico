/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageCommand;


import packageObserver.Account;

public class TransferCommand implements Command {

    private final Account origen;
    private final Account destino;
    private final double amount;

    public TransferCommand(Account origen, Account destino, double amount) {
        this.origen = origen;
        this.destino = destino;
        this.amount = amount;
    }

    @Override
    public void execute() {
        origen.transfer(destino, amount);
    }
}
