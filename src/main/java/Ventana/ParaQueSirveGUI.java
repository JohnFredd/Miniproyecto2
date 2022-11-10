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
        txtAInfo.setBounds(215, 220, 420, 150);
        txtAInfo.append("\n    Un juego que te permite entrenar tu capacidad de\n");
        txtAInfo.append("    codificación y recuerdo de información visual y espacial.\n");
        txtAInfo.append("    Este tipo de habilidades es relevante en la práctica de\n");
        txtAInfo.append("    algunos deportes, el reconocimiento de caras o para\n");
        txtAInfo.append("    recordar dónde guardamos nuestras cosas.");
    }
}
