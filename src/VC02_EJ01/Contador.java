/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package VC02_EJ01;

/**
 *
 * @author anaranjo
 */
public class Contador implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("El %s está contando ... %d %n", Thread.currentThread().getName(), i);
        }
    }

}
