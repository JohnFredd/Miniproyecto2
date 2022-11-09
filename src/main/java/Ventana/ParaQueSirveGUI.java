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

package Ventana;

import java.awt.Image;
import javax.swing.ImageIcon;

public class ParaQueSirveGUI extends PlantillaGUI{

    public ParaQueSirveGUI(String titulo) {
        super(titulo);
    }
    
    @Override
    public void iniciarComponentes(){
        super.iniciarComponentes();
        
        //CONFIGURACION SOBRE PLANTILLA
        ImageIcon titulo = new ImageIcon("ParaQueSirve.png");
        lblTitulo.setIcon(new ImageIcon(titulo.getImage().getScaledInstance(lblTitulo.getWidth(), lblTitulo.getHeight(), Image.SCALE_SMOOTH)));
        txtAInfo.setBounds(150, 165, 550, 270);
    }
}
