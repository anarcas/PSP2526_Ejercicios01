/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package VC03_EJ01;

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
        
        Museo gernika = new Museo();
        
        Thread h1 = new Thread(new HilosEntrada(gernika),"Puerta nº 1");
        Thread h2 = new Thread(new HilosEntrada(gernika),"Puerta nº 2");
        Thread h3 = new Thread(new HilosEntrada(gernika),"Puerta nº 3");
        Thread h4 = new Thread(new HilosEntrada(gernika),"Puerta nº 4");
        
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        
    }
    
}
