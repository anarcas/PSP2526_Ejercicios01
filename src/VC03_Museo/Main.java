/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package VC03_Museo;

import java.util.Random;

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
        Museo museo = new Museo("El Prado", 4);
        String nomVisitante;
        Thread hilo;
        boolean estado = false;
        Random numAleatorio = new Random();

        for (int i = 1; i <= 100; i++) {

            int torno = numAleatorio.nextInt(4) + 1;

            nomVisitante = String.format("Visitante %d", i);
            hilo = new Thread(new Visitante(museo, torno, estado), nomVisitante);
            hilo.start();

        }
        System.out.println("Se han lanzado todos los hilos.");

    }

}
