/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VC04_EJ02;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anaranjo
 */
public class Vendedor implements Runnable {

    Almacen almacen;

    public Vendedor(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        while (almacen.getNumCuadrosPintados()< 10) {
            try {
                // Simulación de negociación al vender un cuadro
                Thread.sleep(3000);
                almacen.venderCuadro();
            } catch (InterruptedException ex) {
                Logger.getLogger(Pintor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println(String.format("El %s deja de vender cuadros -> Total de cuadros vendidos = %d", Thread.currentThread().getName(), Almacen.getNumCuadrosVendidos()));

    }

}
