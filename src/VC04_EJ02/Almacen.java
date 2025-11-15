/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VC04_EJ02;

/**
 *
 * @author anaranjo
 */
public class Almacen {

    private static int cuadrosPintados=0;
    private static int cuadrosVendidos=0;
    private int cuadrosAlmacenados=0;

    public static synchronized int getNumCuadrosPintados() {
        return Almacen.cuadrosPintados;
    }
    
    public static synchronized int getNumCuadrosVendidos() {
        return Almacen.cuadrosVendidos;
    }

    public synchronized void almacenarCuadro() throws InterruptedException {
        while (cuadrosAlmacenados > 0) {
            System.out.println(String.format("El %s está esperando que el vendedor venda el cuadro existente en el almacén (número de cuadros en el almacen: %d).", Thread.currentThread().getName(), cuadrosAlmacenados));
            wait();
        }
        if (Almacen.getNumCuadrosPintados() < 10) {
            Almacen.cuadrosPintados++;
            cuadrosAlmacenados++;
            System.out.println(String.format("El %s ha pintado y almacenado un cuadro. Existen %d cuadros en el almacen.", Thread.currentThread().getName(), cuadrosAlmacenados));
            notifyAll();}
//        } else {
//            System.out.println(String.format("El %s no puede almacenar cuadros porque ya se han vendido los posibles -> %d vendidos.", Thread.currentThread().getName(), Almacen.getNumCuadrosVendidos()));
//            notifyAll();
//        }
    }

    public synchronized void venderCuadro() throws InterruptedException {
        while (cuadrosAlmacenados < 1 && Almacen.getNumCuadrosPintados() < 10) {
            System.out.println(String.format("El %s está esperando que el pintor almacene un cuadro en el almacén (número de cuadros en el almacen: %d).", Thread.currentThread().getName(), cuadrosAlmacenados));
            wait();
        }

        if (Almacen.getNumCuadrosPintados() < 10) {
            cuadrosAlmacenados--;
            System.out.println(String.format("El %s ha vendido un cuadro. Existen %d cuadros en el almacen.", Thread.currentThread().getName(), cuadrosAlmacenados));

            Almacen.cuadrosVendidos++;
            System.out.println(String.format("Los vendedores llevan vendidos -> %d cuadros.", Almacen.getNumCuadrosVendidos()));
            notifyAll();
        }

    }

}
