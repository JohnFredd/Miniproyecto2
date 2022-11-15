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

import java.util.Calendar;

public class Juego {
    
    private int cantAciertos;
    private int cantFallos;
    private long tiempoJuego;
    private int puntajeTotal;
    
    public Juego(){
        tiempoJuego = Calendar.getInstance().getTimeInMillis();
    }
    
    public void actualizarDatos(boolean acerto) {
        if (acerto) {
            cantAciertos += 1;
            puntajeTotal += 100;
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
    
    public int getPuntajeTotal() {
        return puntajeTotal;
    }
    
}
