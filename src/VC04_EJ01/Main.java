/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package VC04_EJ01;

/**
 *
 * @author anaranjo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here

        Almacen almacen = new Almacen();

        Thread hiloPintor;
        Thread hiloVendedor;

        hiloPintor = new Thread(new Pintor(almacen), "pintor Antonio");
        hiloPintor.start();

        hiloVendedor = new Thread(new Vendedor(almacen), "vendedor Jesús");
        hiloVendedor.start();

        hiloVendedor.join();
        hiloPintor.join();

        System.out.println(String.format("Se cierra el almacen. Total cuadros vendidos %d", Almacen.getNumCuadrosVendidos()));

    }

}
