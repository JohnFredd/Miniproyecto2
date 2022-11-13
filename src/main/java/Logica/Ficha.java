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
import javax.swing.JButton;

public class Ficha extends JButton {
    
    private Color color;
    private String forma;
    private Color[] colores = {
    Color.WHITE,
    Color.BLUE,
    Color.BLACK,
    Color.GREEN,
    Color.RED,
    Color.MAGENTA};
    private String[] formas = {
    "sin forma",
    "corazon",
    "cruz",
    "estrella",
    "rayo",
    "rombo"};
    
    public Ficha(String tipoFicha) {
        if ("vacia".equals(tipoFicha)) {
            color = colores[0];
            forma = formas[0];
        }
        if ("libre".equals(tipoFicha)){
            int colorEscogido;
            int formaEscogida;
            while(true) {
                colorEscogido = (int)(Math.random()*colores.length);
                formaEscogida = (int)(Math.random()*formas.length);
                if (colorEscogido != 0 || formaEscogida != 0) {
                    break;
                }
            }
            color = colores[colorEscogido];
            forma = formas[formaEscogida];
        }
        if ("completa".equals(tipoFicha)){
            int colorEscogido;
            while(true) {
                colorEscogido = (int)(Math.random()*colores.length);
                if (colorEscogido != 0) {
                    break;
                }
            }
            int formaEscogida;
            while(true) {
                formaEscogida = (int)(Math.random()*formas.length);
                if (formaEscogida != 0) {
                    break;
                }
            }
            color = colores[colorEscogido];
            forma = formas[formaEscogida];
        }
    }
    
    public Ficha(Color color,String forma) {
        if (color == colores[0]) {
            int colorEscogido;
            while(true) {
                colorEscogido = (int)(Math.random()*colores.length);
                if (colorEscogido != 0) {
                    break;
                }
            }
            this.color = colores[colorEscogido];
        } else {
            this.color = color;
        }
        if (forma.equals(formas[0])) {
            int formaEscogida;
            while(true) {
                formaEscogida = (int)(Math.random()*colores.length);
                if (formaEscogida != 0) {
                    break;
                }
            }
            this.forma = formas[formaEscogida];
        } else {
            this.forma = forma;
        }
    }

    public Color getColor() {
        return color;
    }

    public String getForma() {
        return forma;
    }
    
}
