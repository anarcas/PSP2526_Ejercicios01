/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VC05_EJ01;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anaranjo
 */
public class Escritores implements Runnable {

    Documento doc;
    Random numAleatorio = new Random();
    long tiempoEscritura;
    
    public Escritores(Documento doc){
        this.doc=doc;
    }
    
    @Override
    public void run() {

        try {
            doc.escribir(String.format("Hilo %s ha escrito.",Thread.currentThread().getName()));
            tiempoEscritura = (numAleatorio.nextLong(1, 10) + 1) * 1000;
            Thread.sleep(tiempoEscritura);
        } catch (IOException ex) {
            Logger.getLogger(Escritores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Escritores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
}
