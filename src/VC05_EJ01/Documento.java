/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VC05_EJ01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author anaranjo
 */
public class Documento {

    private final String ARCHIVO_TXT = "archivo.txt";
    File archivo = new File(ARCHIVO_TXT);
    Random numAleatorio = new Random();
    long tiempoEscritura;
    long tiempoLectura;

    public synchronized void escribir(String texto) throws IOException, InterruptedException {
        tiempoEscritura = (numAleatorio.nextLong(1, 10) + 1) * 1000;
        wait(tiempoEscritura);
        //FileWriter escribe caracteres y BufferedWriter crea el flujo de escritura
        try (FileWriter fw = new FileWriter(archivo, true); BufferedWriter bw = new BufferedWriter(fw);) {
            bw.write("\n");
            bw.write(texto);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de texto.");
        }
    }

    public synchronized void leer() throws IOException {
        // Verifica si el archivo existe usando el objeto File
        if (!archivo.exists()) {
            System.out.println(String.format("\n Advertencia: El archivo %s no existe para la lectura.", ARCHIVO_TXT));
            return;
        }
        tiempoLectura = (numAleatorio.nextLong(1, 10) + 1) * 1000;
        //FileWriter escribe caracteres y BufferedReader capta el flujo de lectura
        try (FileReader fr = new FileReader(archivo); BufferedReader br = new BufferedReader(fr);) {

            String linea;
            // Bucle que lee línea por línea hasta que readLine() devuelve null
            while ((linea = br.readLine()) != null) {
                System.out.println(String.format("Hilo: %s leyendo... %s", Thread.currentThread().getName(), linea));
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de texto.");
        }
    }

}
