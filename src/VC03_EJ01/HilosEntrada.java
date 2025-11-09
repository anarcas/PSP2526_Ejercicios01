/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VC03_EJ01;

/**
 *
 * @author anaranjo
 */
public class HilosEntrada implements Runnable {
    
    Museo museo = new Museo();
    
    public HilosEntrada(Museo gernika){
        
        this.museo=gernika;
    }
    
    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            museo.incrementar();
        }
    }
    
}
