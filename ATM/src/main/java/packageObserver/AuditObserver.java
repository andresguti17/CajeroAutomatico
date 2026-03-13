/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageObserver;


public class AuditObserver implements Observer {

    @Override
    public void update(Subject subject) {
        if(subject instanceof Account){
            Account ac = (Account) subject;
            System.out.println("AUDITORY: ambio en el saldo  :"+ac.getBalance());
        }
        System.out.println("no se realizaron cambios");
    }
    }
