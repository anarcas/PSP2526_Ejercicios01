/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package VC02_EJ02;

/**
 *
 * @author anaranjo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here

        int[] listaEnteros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        String nombreHilo;
        Thread hilo;

        for (int i = 1; i <= 3; i++) {

            try {
                nombreHilo = String.format("Hilo %d", i);
                hilo = new Thread(new Operador(i, listaEnteros), nombreHilo);
                hilo.start();
                Thread.sleep(2000);
                //hilo.join();
            } catch (OutOfMemoryError e) {
                // Código para manejar la excepción específica (en este caso, la división por cero).
                System.err.println("¡Error! Se intentó dividir por cero: " + e.getMessage());
            }

        }

    }

}
