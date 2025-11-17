/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package VC05_EJ03;

/**
 *
 * @author anaranjo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Fichero f = new Fichero();

        int numLectores = 5;
        int numEscritores = 2;

        Thread[] Lectores = new Thread[numLectores];
        Thread[] Escritores = new Thread[numEscritores];

        for (int i = 0; i < numLectores; i++) {
            Lectores[i] = new Thread(new Lectores(f), "Lector " + i);
        }

        for (int i = 0; i < numEscritores; i++) {
            Escritores[i] = new Thread(new Escritores(f), "Escritor " + i);
        }

        for (int i = 0; i < numLectores; i++) {
            Lectores[i].start();
        }

        for (int i = 0; i < numEscritores; i++) {
            Escritores[i].start();
        }

    }

}
