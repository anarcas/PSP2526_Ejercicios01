/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VC03_EJ02;

/**
 *
 * @author anaranjo
 */
public class Cocina {

    private int cuchillos = 5;

    public synchronized void cogerCuchillo() throws InterruptedException {
        
        while (cuchillos<1){
            System.out.println(String.format("%s: esperando un cuchillo...",Thread.currentThread().getName()));
            wait();
        }
        cuchillos--;
        System.out.println(String.format("%s: cojo un cuchillo, quedan %d cuchillos libres.",Thread.currentThread().getName(), cuchillos));

    }
    
        public synchronized void soltarCuchillo() {
        
        cuchillos++;
        System.out.println(String.format("%s: suelto un cuchillo, quedan %d cuchillos libres.",Thread.currentThread().getName(), cuchillos));
        notifyAll();
    }
}
