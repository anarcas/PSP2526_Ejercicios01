/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VC05_EJ03;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anaranjo
 */
public class Escritores implements Runnable {
    
    Fichero f;
    Random r = new Random();
    
    public Escritores(Fichero f){
        this.f=f;
    }

    @Override
    public void run() {
        
        try{
            f.escribirFichero();
            Thread.sleep((r.nextInt(9)+2)*1000);
            f.terminaEscribir();
        } catch (InterruptedException ex){
                    Logger.getLogger(Escritores.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
    
    
    
}
