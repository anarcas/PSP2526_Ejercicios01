/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VC03_Museo;

import java.util.Random;

/**
 *
 * @author anaranjo
 */
public class Visitante implements Runnable {

    private final Museo museo;
    private final int torno;
    private boolean haEntrado;
    Random numAleatorio = new Random();

    public Visitante(Museo museo, int torno, boolean estado) {
        this.museo = museo;
        this.torno = torno;
        this.haEntrado=estado;
    }

    @Override
    public void run() {
        while (museo.isMuseoAbierto()) {
            if (museo.isTornoAbierto(torno)) {
                museo.entrar(torno);
                this.haEntrado=true;
                System.out.println(String.format("El %s ha entrado en el museo %s por el torno nº %d (total visitantes museo = %d, total visitas torno nº %d).", Thread.currentThread().getName(), museo.getNombreMuseo(), torno, museo.getNumTotalVisitas(), museo.getNumTotalVisitasTorno(torno)));
            } else {
                System.out.println(String.format("El %s está intentando entrar en el torno nº %d, pero ya se encuentra cerrado. Número de visitantes que han entrado por el torno nº %d = %d.", Thread.currentThread().getName(), torno, torno, museo.getNumTotalVisitasTorno(torno)));
                System.out.println(String.format("El %s está buscando un torno abierto...", Thread.currentThread().getName()));
                // El visitante intenta entrar en el museo por otro torno que se encuentre abierto

                int tornoSiguiente;
                do {
                    tornoSiguiente = numAleatorio.nextInt(4) + 1;
                    System.out.println(String.format("El %s está intentando entrar en un torno nº %d. Número de visitantes que ya han entrado = %d. ¿El torno está abierto? %b", Thread.currentThread().getName(), tornoSiguiente, museo.getNumTotalVisitasTorno(tornoSiguiente), museo.isTornoAbierto(tornoSiguiente)));
                    System.out.println(String.format("¿El museo sigue abierto? %b Total de visitantes = %d", museo.isMuseoAbierto(), museo.getNumTotalVisitas()));
                    if (museo.isTornoAbierto(tornoSiguiente)) {
                        museo.entrar(tornoSiguiente);
                        this.haEntrado=true;
                        System.out.println(String.format("El %s ha entrado en el museo %s por el torno nº %d (total visitantes museo = %d, total visitas torno nº %d).", Thread.currentThread().getName(), museo.getNombreMuseo(), tornoSiguiente, museo.getNumTotalVisitas(), museo.getNumTotalVisitasTorno(tornoSiguiente)));
                    }
                } while (museo.isMuseoAbierto() & !this.haEntrado);

                //System.out.println(String.format("El %s ha entrado en el museo %s por el torno nº %d (total visitantes museo = %d, total visitas torno nº %d).", Thread.currentThread().getName(), museo.getNombreMuseo(), tornoSiguiente, museo.getNumTotalVisitas(), museo.getNumTotalVisitasTorno(tornoSiguiente)));
            }
        }
        System.out.println(String.format("El %s se marcha porque el aforo del museo %s está completado (nº total de visitantes = %d).", Thread.currentThread().getName(), museo.getNombreMuseo(), museo.getNumTotalVisitas()));

    }
}
