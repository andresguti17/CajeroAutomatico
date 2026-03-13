/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.proyecto.atm;

/**
 *
 * @author diang
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import packageObserver.*;
import packageCommand.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Account> accounts = new ArrayList<>();
        //usuarios existentes
        accounts.add(new Account("1111", "1234", 1000));
        accounts.add(new Account("2222", "4321", 500));
        accounts.add(new Account("3333", "0000", 2000));

        Account currentAccount = null;

        System.out.println("=================================");
        System.out.println("        BIENVENIDO AL ATM        ");
        System.out.println("=================================");

        System.out.print("Ingrese número de tarjeta: ");
        String cardNumber = scanner.nextLine();

        System.out.print("Ingrese PIN: ");
        String pin = scanner.nextLine();
        //validacion de acceso
        for (Account acc : accounts) {
            if (acc.getCardNumber().equals(cardNumber) && acc.validatePin(pin)) {
                currentAccount = acc;
                break;
            }
        }

        if (currentAccount == null) {
            System.out.println("Tarjeta o PIN incorrectos.");
            scanner.close();
            return;
        }

        System.out.println("\nAcceso concedido.");

        // Agregacion observadores
        currentAccount.addObserver(new AuditObserver());
        currentAccount.addObserver(new NotificationObserver());

        ATM atm = new ATM();

        int option;

        do {
            System.out.println("\n===============================");
            System.out.println("           MENU ATM            ");
            System.out.println("===============================");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Transferir dinero");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            option = scanner.nextInt();

            switch (option) {

                case 1 -> {
                    atm.setCommand(new BalanceCommand(currentAccount));
                    atm.executeCommand();
                }

                case 2 -> {
                    System.out.print("Ingrese cantidad a depositar: ");
                    double amount = scanner.nextDouble();

                    atm.setCommand(new DepositCommand(currentAccount, amount));
                    atm.executeCommand();
                }

                case 3 -> {
                    System.out.print("Ingrese cantidad a retirar: ");
                    double amount = scanner.nextDouble();

                    atm.setCommand(new WithdrawCommand(currentAccount, amount));
                    atm.executeCommand();
                }

                case 4 -> {

                    scanner.nextLine(); // limpiar buffer

                    System.out.print("Ingrese número de tarjeta destino: ");
                    String targetCard = scanner.nextLine();

                    // Verificar si intenta transferir a sí mismo
                    if (targetCard.equals(currentAccount.getCardNumber())) {
                        System.out.println("No puede transferir a su propia cuenta.");
                        break;
                    }

                    Account targetAccount = null;

                    for (Account acc : accounts) {
                        if (acc.getCardNumber().equals(targetCard)) {
                            targetAccount = acc;
                        break;
                        }
                    }

                    if (targetAccount == null) {
                        System.out.println("Cuenta destino no encontrada.");
                        break;
                    }

                    System.out.print("Ingrese cantidad a transferir: ");
                    double amount = scanner.nextDouble();

                    atm.setCommand(new TransferCommand(currentAccount, targetAccount, amount));
                    atm.executeCommand();
                }

                case 5 -> System.out.println("Retire su tarjeta. Gracias por usar el ATM.");

                default -> System.out.println("Opción inválida.");
            }

        } while (option != 5);

        scanner.close();
    }
}