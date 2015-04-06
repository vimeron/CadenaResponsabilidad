/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadenaresponsabilidad;

/**
 *
 * @author Flia Mersan
 */
import java.util.Scanner;
 
public class ATMDispenseChain {
 
    private DispenseChain c1;
 
    public ATMDispenseChain() {
        // inicializar la cadena de
        this.c1 = new Dollar50Dispenser();
        DispenseChain c2 = new Dollar20Dispenser();
        DispenseChain c3 = new Dollar10Dispenser();
 
        // establece la cadena de responsabilidad
        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }
 
    public static void main(String[] args) {
        ATMDispenseChain atmDispenser = new ATMDispenseChain();
        while (true) {
            int amount = 0;
            System.out.println("Enter amount to dispense");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();
            if (amount % 10 != 0) {
                System.out.println("Amount should be in multiple of 10s.");
                return;
            }
            // procesando la solicitud
            atmDispenser.c1.dispense(new Currency(amount));
        }
 
    }
 
}
