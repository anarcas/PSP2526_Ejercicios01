/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package VC04_EJ02;

import VC04_EJ01.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anaranjo
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here

        Almacen almacen = new Almacen();
        int numVendedores = 2;

        Thread hiloPintor;
        Thread hiloVendedor;
        List<Thread> listaHilosVendedores = new ArrayList<>();

        hiloPintor = new Thread(new Pintor(almacen), "pintor Antonio");
        hiloPintor.start();

        for (int i = 1; i <= numVendedores; i++) {
            hiloVendedor = new Thread(new Vendedor(almacen), "vendedor " + i);
            listaHilosVendedores.add(hiloVendedor);
            hiloVendedor.start();
        }

        for (Thread hilo : listaHilosVendedores) {
            hilo.join();
        }
        hiloPintor.join();

        System.out.println(String.format("Se cierra el almacen -> Total cuadros vendidos %d y total cuadros pintados %d.", Almacen.getNumCuadrosVendidos(),Almacen.getNumCuadrosPintados()));

    }

}
