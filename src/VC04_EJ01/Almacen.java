/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VC04_EJ01;

/**
 *
 * @author anaranjo
 */
public class Almacen {

    private static int cuadrosVendidos;
    private int cuadrosAlmacenados = 0;

    public static synchronized int getNumCuadrosVendidos() {
        return Almacen.cuadrosVendidos;
    }

    public synchronized void almacenarCuadro() throws InterruptedException {
        while (cuadrosAlmacenados > 0) {
            System.out.println(String.format("El %s está esperando que el vendedor venda el cuadro existente en el almacén (número de cuadros en el almacen: %d).", Thread.currentThread().getName(), cuadrosAlmacenados));
            wait();
        }
        if (Almacen.getNumCuadrosVendidos() < 10) {
            cuadrosAlmacenados++;
            System.out.println(String.format("El %s ha almacenado un cuadro. Existen %d cuadros en el almacen.", Thread.currentThread().getName(), cuadrosAlmacenados));
            notify();
        } else {
            System.out.println(String.format("El %s no puede almacenar cuadros porque ya se han vendido los posibles -> %d vendidos.", Thread.currentThread().getName(), Almacen.getNumCuadrosVendidos()));

        }
    }

    public synchronized void venderCuadro() throws InterruptedException {
        while (cuadrosAlmacenados < 1) {
            System.out.println(String.format("El %s está esperando que el pintor almacene un cuadro en el almacén (número de cuadros en el almacen: %d).", Thread.currentThread().getName(), cuadrosAlmacenados));
            wait();
        }
        cuadrosAlmacenados--;
        System.out.println(String.format("El %s ha vendido un cuadro. Existen %d cuadros en el almacen.", Thread.currentThread().getName(), cuadrosAlmacenados));

        Almacen.cuadrosVendidos++;
        System.out.println(String.format("El %s lleva vendidos %d cuadros.", Thread.currentThread().getName(), Almacen.getNumCuadrosVendidos()));
        notify();

    }

}
