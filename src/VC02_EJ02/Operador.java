/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package VC02_EJ02;

import VC02_EJ01.*;

/**
 *
 * @author anaranjo
 */
public class Operador implements Runnable {

    private int operacion;
    private int[] numerosEnteros;
    private int resultado;
    private String nombreOperacion;

    public Operador(int operacion, int[] numeros) {
        this.operacion = operacion;
        this.numerosEnteros = numeros;

    }

    @Override
    public void run() {
        // Se inicia la variable resultado
        resultado = 0;
        nombreOperacion = "";

        switch (operacion) {
            // Sumar
            case 1:
                for (int numero : numerosEnteros) {
                    resultado += numero;
                }
                nombreOperacion = "SUMA";
                break;

            // Restar
            case 2:
                for (int numero : numerosEnteros) {
                    resultado -= numero;
                    nombreOperacion = "RESTA";
                }
                break;

            // Multiplicar
            case 3:
                resultado = 1; // Se inicia a la unidad para resetear la multiplicación, debe ser distinto de cero
                for (int numero : numerosEnteros) {
                    resultado = resultado * numero;
                    nombreOperacion = "MULTIPLICACIÓN";
                }
                break;

            // Otra operacion a definir
            default:

        }
        String parteMensaje;
        int longitudCadena;
        longitudCadena = 15;
        parteMensaje = String.format("%" + longitudCadena + "d", resultado);
        System.out.printf("El %s ha realizado la operación %s y obtiene como resultado %s %n", Thread.currentThread().getName(), nombreOperacion, parteMensaje);
    }

}
