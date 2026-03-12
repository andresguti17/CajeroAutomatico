/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageCommand;

public class ATM {

    private Command command;


    public void setCommand(Command command) {
        this.command = command;
    }


    public void executeCommand() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No hay operación seleccionada.");
        }
    }
}