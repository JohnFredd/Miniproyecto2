/*
 * MINIPROYECTO #2
 *
 * INTEGRANTES: 
 * John Freddy Belalcázar
 * Hernán David Cisneros
 * Santiago González Gálvez
 *
 * Grupo 01 FPOE 
 *
 * PROFESOR: Luis Yohany Romo Portilla 
 */

package Logica;

import java.awt.Color;
import java.util.Calendar;

public class Juego {
    
    private int cantAciertos;
    private int cantFallos;
    private long tiempoJuego;
    private String[] formas = {
    "corazon",
    "cruz",
    "estrella",
    "rayo",
    "rombo",
    "sin forma"};
    private Color[] colores = {
    Color.BLUE,
    Color.BLACK,
    Color.GREEN,
    Color.RED,
    Color.MAGENTA,
    Color.WHITE};
    
    public Juego(){
        tiempoJuego = Calendar.getInstance().getTimeInMillis();
    }
    
    public void actualizarDatos(boolean acerto) {
        if (acerto) {
            cantAciertos += 1;
        } else {
            cantFallos += 1;
        }
    }

    public long getTiempoJuego() {
        long tiempoActual = Calendar.getInstance().getTimeInMillis();
        long tiempo = tiempoActual - tiempoJuego;
        return tiempo;
    }

    public int getCantAciertos() {
        return cantAciertos;
    }

    public int getCantFallos() {
        return cantFallos;
    }

    public String[] getFormas() {
        return formas;
    }

    public Color[] getColores() {
        return colores;
    }
    
}
