/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VC05_EJ03;

/**
 *
 * @author anaranjo
 */
public class Fichero {

    private int lectores = 0;
    private int escritores = 0;
    private int escritoresEsperando=0;

    public synchronized void leerFichero() throws InterruptedException {
        while (escritores > 0 || escritoresEsperando>1) {
            System.out.println(Thread.currentThread().getName() + ": Hay alguien usando el fichero. Espero.");
            wait();
        }
        lectores++;
        System.out.println(Thread.currentThread().getName() + ": Leyendo fichero. Lectores: " + lectores);
    }

    public synchronized void escribirFichero() throws InterruptedException {
        while (lectores > 0 || escritores > 0) {
            System.out.println(Thread.currentThread().getName() + ": Hay alguien usando el fichero. Espero.");
            escritoresEsperando++;
            wait();
            escritoresEsperando--;
        }
        escritores++;
        System.out.println(Thread.currentThread().getName() + ": Escribiendo fichero.");
    }

    public synchronized void terminaLeer() {

        lectores--;
        System.out.println(Thread.currentThread().getName() + ": he terminado de leer. Lectores: " + lectores);
        
        if(lectores==0){
        notify();
        }
    }

    public synchronized void terminaEscribir() {

        escritores--;
        System.out.println(Thread.currentThread().getName() + ": he terminado de escribir.");
        notify();
    }

}
