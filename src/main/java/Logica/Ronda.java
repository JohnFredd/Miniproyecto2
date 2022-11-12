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

public class Ronda {
    
    private Juego juego
    private Ficha fichaAdivinar;
    private int fichasFaltantes;
    
    public Ronda(Juego juego){
        this.juego = juego;
        escogerFichaAdivinar();
    }
    
    public void escogerFichaAdivinar() {
        fichaAdivinar = new Ficha("libre");
    }
    
    public Ficha[][] generarMapaFichas() {
        int numeroDeRonda = juego.getCantAciertos() + juego.getCantFallos() + 1;
        int numeroDeFichas = numeroDeRonda/3;
    }
    
    public boolean comprobarFicha(Ficha ficha) {
        if (true) {
            
        }
    }

    public int getFichasFaltantes() {
        return fichasFaltantes;
    }
    
}
