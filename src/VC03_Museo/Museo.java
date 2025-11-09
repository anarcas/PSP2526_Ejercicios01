/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VC03_Museo;

/**
 *
 * @author anaranjo
 */
public class Museo {

    private String nombre;
    private int torno;
    private int numTornos;
    public static final int NUM_MIN_TORNOS = 1;
    public static final int NUM_MAX_TORNOS = 4;
    private long numVisitas;
    private long numVisitantesTorno1;
    private long numVisitantesTorno2;
    private long numVisitantesTorno3;
    private long numVisitantesTorno4;
    private boolean isTorno1Abierto;
    private boolean isTorno2Abierto;
    private boolean isTorno3Abierto;
    private boolean isTorno4Abierto;
    private boolean isMuseoAbierto;
    private boolean isVisitanteDentro;

    public Museo(String nombre, int numTornos) throws IllegalArgumentException {
        if (numTornos < Museo.NUM_MIN_TORNOS || numTornos > Museo.NUM_MAX_TORNOS) {
            throw new IllegalArgumentException(String.format("Error, el número de tornos debe estar comprendido entre %d y %d.%n", Museo.NUM_MIN_TORNOS, Museo.NUM_MAX_TORNOS));
        }
        this.numTornos = numTornos;
        this.nombre = nombre;
        this.isTorno1Abierto = true;
        this.isTorno2Abierto = true;
        this.isTorno3Abierto = true;
        this.isTorno4Abierto = true;
        this.isMuseoAbierto = true;
        this.numVisitas = 0;
        this.numVisitantesTorno1 = 0;
        this.numVisitantesTorno2 = 0;
        this.numVisitantesTorno3 = 0;
        this.numVisitantesTorno4 = 0;
    }

    public void entrar(int torno) throws IllegalArgumentException {
        if (torno < Museo.NUM_MIN_TORNOS || torno > Museo.NUM_MAX_TORNOS) {
            throw new IllegalArgumentException(String.format("Error, el número del torno de acceso debe estar comprendido entre %d y %d.%n", Museo.NUM_MIN_TORNOS, Museo.NUM_MAX_TORNOS));
        }

        if (isTornoAbierto(torno)) {

            switch (torno) {

                case 1:
                    numVisitantesTorno1++;
                    numVisitas++;
                    break;
                case 2:
                    numVisitantesTorno2++;
                    numVisitas++;
                    break;
                case 3:

                    numVisitantesTorno3++;
                    numVisitas++;

                    break;
                case 4:

                    numVisitantesTorno4++;
                    numVisitas++;

                    break;
                default:

            }

        }

    }

    public long getNumVisitantesTorno(int torno) throws IllegalArgumentException {

        if (torno < Museo.NUM_MIN_TORNOS || torno > Museo.NUM_MAX_TORNOS) {
            throw new IllegalArgumentException(String.format("Error, el número del torno de acceso debe estar comprendido entre %d y %d.%n", Museo.NUM_MIN_TORNOS, Museo.NUM_MAX_TORNOS));
        }

        long numVisitantes = 0;
        switch (torno) {

            case 1:
                numVisitantes = this.numVisitantesTorno1;
                break;
            case 2:
                numVisitantes = this.numVisitantesTorno2;
                break;
            case 3:
                numVisitantes = this.numVisitantesTorno3;
                break;
            case 4:
                numVisitantes = this.numVisitantesTorno4;
                break;
            default:

        }

        return numVisitantes;
    }

    public boolean isTornoAbierto(int torno) throws IllegalArgumentException {

        if (torno < Museo.NUM_MIN_TORNOS || torno > Museo.NUM_MAX_TORNOS) {
            throw new IllegalArgumentException(String.format("Error, el número del torno de acceso debe estar comprendido entre %d y %d", Museo.NUM_MIN_TORNOS, Museo.NUM_MAX_TORNOS));
        }

        boolean isAbierto = true;

        switch (torno) {

            case 1:
                if (this.getNumVisitantesTorno(torno) < 20) {
                    isAbierto = true;
                } else {
                    isAbierto = false;
                }
                break;
            case 2:
                if (this.getNumVisitantesTorno(torno) < 20) {
                    isAbierto = true;
                } else {
                    isAbierto = false;
                }
                break;
            case 3:
                if (this.getNumVisitantesTorno(torno) < 20) {
                    isAbierto = true;
                } else {
                    isAbierto = false;
                }
                break;
            case 4:
                if (this.getNumVisitantesTorno(torno) < 20) {
                    isAbierto = true;
                } else {
                    isAbierto = false;
                }
                break;
            default:

        }

        return isAbierto;

    }

    public String getNombreMuseo() {
        return this.nombre;
    }

    public long getNumTotalVisitas() {
        return this.numVisitas;
    }

    public long getNumTotalVisitasTorno(int torno) {
        return this.getNumVisitantesTorno(torno);
    }

    public boolean isMuseoAbierto() {
        return this.numVisitas < 80;
    }
}
