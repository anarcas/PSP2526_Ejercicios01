/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VC03_EJ02;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anaranjo
 */
public class Cocinero implements Runnable {

    private final Cocina cocina;

    public Cocinero(Cocina restLaBrasa) {

        this.cocina = restLaBrasa;

    }

    @Override
    public void run() {

        for (int i = 1; i <= 4; i++) {

            try {
                cocina.cogerCuchillo();
            } catch (InterruptedException ex) {
                Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
            }
            cocina.soltarCuchillo();

        }

    }

}
