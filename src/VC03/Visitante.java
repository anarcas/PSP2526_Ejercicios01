/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VC03;

/**
 *
 * @author anaranjo
 */
public class Visitante implements Runnable {
    Museo museo = new Museo("El Padro",4);
    private int torno;
    
    public Visitante(int torno){
        this.torno=torno;
    }
    
    @Override
    public void run() {
        museo.entrar();
    }
}
