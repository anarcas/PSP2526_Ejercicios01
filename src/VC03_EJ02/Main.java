/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package VC03_EJ02;

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

        Cocina restLaBrasa = new Cocina();
        
        // Hilos sueltos
//        Thread cocinero1 = new Thread(new Cocinero(restLaBrasa), "Cocinero 1");
//        Thread cocinero2 = new Thread(new Cocinero(restLaBrasa), "Cocinero 2");
//        Thread cocinero3 = new Thread(new Cocinero(restLaBrasa), "Cocinero 3");
//
//        cocinero1.start();
//        cocinero2.start();
//        cocinero3.start();
        
        // Hilos creados por un bucle determinado
        Thread cocinero;
        String nombreCocinero;
        
        for (int i = 1; i <=7; i++) {
            nombreCocinero="Cocinero nº " + i;
            cocinero=new Thread(new Cocinero(restLaBrasa),nombreCocinero);
            cocinero.start();
        }

    }

}
