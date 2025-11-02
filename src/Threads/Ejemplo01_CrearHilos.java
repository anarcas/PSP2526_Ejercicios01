/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Threads;

/**
 * Ejemplo 1 Creando hijos 
 * @author anaranjo
 */
public class Ejemplo01_CrearHilos extends Thread {

    
    @Override
    public void run(){
    
        System.out.println("Hola! descendiente de Thread! solo se puede heredar de una clase");
        System.out.println("Tu nombre es: "+ Thread.currentThread().getName());
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Ejemplo01_CrearHilos creaHilo = new Ejemplo01_CrearHilos();
        creaHilo.start();
        
    }
    
}