/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package VC05_EJ01;

import java.util.ArrayList;
import java.util.List;

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

        Documento doc = new Documento();
        String mensajeSalida;
        mensajeSalida = "Existía un archivo con el mismo nombre y ha sido eliminado con éxito.";
        int longCadena;
        longCadena = mensajeSalida.length();

        List<Thread> hilosEscritores = new ArrayList<>();
        List<Thread> hilosLectores = new ArrayList<>();

        // Verificar si existe y eliminarlo
        if (doc.archivo.exists()) {
            boolean eliminado = doc.archivo.delete();
            if (eliminado) {
                System.out.println("*".repeat(longCadena));
                System.out.println(mensajeSalida);
                System.out.println("*".repeat(longCadena) + "\n");
            } else {
                System.err.println("Error: No se pudo eliminar el archivo.");
                return; // Salir si la eliminación falla
            }
        }

        int numEscritores = 2;
        int numLectores = 5;

        Thread hiloEscritor;
        Thread hiloLector;

        for (int i = 1; i <= numEscritores; i++) {
            hiloEscritor = new Thread(new Escritores(doc), String.format("Escritor %d", i));
            hilosEscritores.add(hiloEscritor);
            hiloEscritor.start();
        }

        for (int i = 1; i <= numLectores; i++) {
            hiloLector = new Thread(new Lectores(doc), String.format("Lector %d", i));
            hilosLectores.add(hiloLector);
            hiloLector.start();
        }

        for (Thread hiloRead : hilosLectores) {
            hiloRead.join();
        }
        for (Thread hiloWriter : hilosEscritores) {
            hiloWriter.join();
        }

        mensajeSalida = "Fin del programa.";
        longCadena = mensajeSalida.length();
        System.out.println("\n" + "*".repeat(longCadena));
        System.out.println(mensajeSalida);
        System.out.println("*".repeat(longCadena));
    }

}
