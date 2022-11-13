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
    
    private Juego juego;
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
        Ficha mapa[][] = new Ficha[7][5];
        int numeroDeRonda = juego.getCantAciertos() + juego.getCantFallos() + 1;
        int numeroDeFichas = (numeroDeRonda/3) + 1;
        mapa[(int)(Math.random()*7)][(int)(Math.random()*5)] = new Ficha(fichaAdivinar.getColor(), fichaAdivinar.getForma());
        for (int i = 0; i < numeroDeFichas; i++) {
            while(true) {
                int x = (int)(Math.random()*7);
                int y = (int)(Math.random()*5);
                if (mapa[x][y] == null) {
                    mapa[x][y] = new Ficha("completa");
                    break;
                }
            }
        }
        for (int x = 0; x < 7; x++) {
            for(int y = 0; y < 5; y++) {
                if (mapa[x][y] == null) {
                    mapa[x][y] = new Ficha("vacia");
                }
            }
        }
        return mapa;
    }
    
    public boolean comprobarFicha(Ficha ficha) {
        boolean coincideColor = false;
        boolean coincideForma = true;
        
        if (fichaAdivinar.getColor() == new Ficha("vacia").getColor()) {
            coincideColor = true;
        } else {
            if (fichaAdivinar.getColor() == ficha.getColor()) {
                coincideColor = true;
            }
        }
        if (fichaAdivinar.getForma().equals(new Ficha("vacia").getForma())) {
            coincideForma = true;
        } else {
            if (fichaAdivinar.getForma().equals(ficha.getForma())) {
                coincideForma = true;
            }
        }
        
        boolean coincide = coincideColor && coincideForma;
        return coincide;
    }

    public int getFichasFaltantes() {
        return fichasFaltantes;
    }
    
}
