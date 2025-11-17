/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VC05_EJ03;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anaranjo
 */
public class Lectores implements Runnable {

    Fichero f;
    Random r = new Random();

    public Lectores(Fichero f) {
        this.f = f;
    }

    @Override
    public void run() {

        try {
            f.leerFichero();
            Thread.sleep((r.nextInt(9) + 2) * 1000);
            f.terminaLeer();
        } catch (InterruptedException ex) {
            Logger.getLogger(Lectores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
