/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VC03_EJ01;

/**
 *
 * @author anaranjo
 */
public class Museo {
    
    private int contador=0;
    
    public synchronized void incrementar(){
        contador++;
        System.out.println(Thread.currentThread().getName() + " Entra una persona: " + contador);
        
    }
    
    
}
