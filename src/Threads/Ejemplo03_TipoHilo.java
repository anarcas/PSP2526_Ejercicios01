/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Threads;

/**
 *
 * @author anaranjo
 */
public class Ejemplo03_TipoHilo {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        Ejemplo02_CrearHilos ch = new Ejemplo02_CrearHilos();
//        Thread tr3 =new Thread(ch);
//        tr3.start();
        
        Thread tr3 =new Thread(new Ejemplo02_CrearHilos());
        tr3.start();
        
    }
    
}
