/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package VC03;

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
        String nomVisitante;
        Thread hilo;
        for (int i = 1; i <= 10; i++) {
            nomVisitante = String.format("Visitante %d", i);
                hilo = new Thread(new Visitante(1), nomVisitante);
                hilo.start();
        }
    }
    
}
