/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package VC05_EJ01;

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

        Documento doc = new Documento();
        int numEscritores = 2;
        int numLectores = 5;

        Thread hiloEscritor;
        Thread hiloLector;

        for (int i = 1; i <= numEscritores; i++) {
            hiloEscritor = new Thread(new Escritores(doc), String.format("Escritor %d", i));
            hiloEscritor.start();
        }

        for (int i = 1; i <= numLectores; i++) {
            hiloLector = new Thread(new Lectores(doc), String.format("Lector %d", i));
            hiloLector.start();
        }

    }

}
