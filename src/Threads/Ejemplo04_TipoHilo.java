/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Threads;

/**
 *
 * @author anaranjo
 */
public class Ejemplo04_TipoHilo {

    /**
     * Clase Interna dentro de otra clase de la cual crearemos los hilos
     *
     * @author anaranjo
     */
    public static class ClaseInterna implements Runnable {

        @Override
        public void run() {
            
            // Se imprime el nombre del hilo
            System.out.println("Hola qué tal! soy: " + Thread.currentThread().getName());
        }
    }

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here

        Thread tr4 = new Thread(new ClaseInterna(), "Antonio"); // Se crea un hilo desde una clase interna pasándole el nombre como segundo argumento del constructor.
        tr4.start();
        // Se espera que el hilo termine antes de seguir
        tr4.join();
        
        // Otra manera de definir el nombre de un hilo
        Ejemplo01_CrearHilos ch = new Ejemplo01_CrearHilos();
        ch.setName("Antonio, pero heredando de la clase Thread");
        ch.start();
        // Se espera que el hilo termine antes de seguir
        ch.join();
        
        // Dejar dormido los hilos un tiempo determinado antes de seguir
        Thread.sleep(5000);
        
        System.out.println("Adiós");

    }

}
