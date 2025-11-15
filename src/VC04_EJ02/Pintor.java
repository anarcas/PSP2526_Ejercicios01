/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VC04_EJ02;

import VC04_EJ01.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anaranjo
 */
public class Pintor implements Runnable {
    
    Almacen almacen;
    
    public Pintor(Almacen almacen){
        this.almacen=almacen;
    
    }

    @Override
    public void run() {
        while  (Almacen.getNumCuadrosPintados()<10){
            try {
                // Simulación de pintar un cuadro
                Thread.sleep(5000);
                almacen.almacenarCuadro();
            } catch (InterruptedException ex) {
                Logger.getLogger(Pintor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println(String.format("El %s deja de pintar cuadros -> Total de cuadros pintados = %d", Thread.currentThread().getName(), Almacen.getNumCuadrosPintados()));
    }
    
}
