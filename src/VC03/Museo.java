/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VC03;

/**
 *
 * @author anaranjo
 */
public class Museo {
    
    private String nombre;
    private int numTornos;
    public static final int NUM_MIN_TORNOS=1;
    public static final int NUM_MAX_TORNOS=4;
    private long numVisitantes=0;
    
    public Museo(String nombre, int numTornos)throws IllegalArgumentException{
        if (numTornos<Museo.NUM_MIN_TORNOS || numTornos>Museo.NUM_MAX_TORNOS) {
            throw new IllegalArgumentException(String.format("Error, el número de tornos debe estar comprendido entre %d y %d",Museo.NUM_MIN_TORNOS,Museo.NUM_MAX_TORNOS));
        }
        this.numTornos=numTornos;
        this.nombre=nombre;
    }
    
    public void entrar(){
        numVisitantes++;
    }
    
    public long getNumVisitantes(){
        return numVisitantes;
    }
}
