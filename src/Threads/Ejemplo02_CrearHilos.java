/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Threads;

/**
 * Ejemplo 2 Creando hijos 
 * @author anaranjo
 */
public class Ejemplo02_CrearHilos implements Runnable {

    
    @Override
    public void run(){
    
        System.out.println("Hola! Runnable! para solventar la multiherencia");
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Ejemplo02_CrearHilos creaHilo = new Ejemplo02_CrearHilos();
        Thread tr2 = new Thread(creaHilo);
        tr2.start();
        
    }
    
}
