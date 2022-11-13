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

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class GameOverGUI extends PlantillaGUI{
    
    private int aciertos;
    private int fallos;
    private int puntaje;
    private String tiempo;
    
    private JLabel lblSubTitulo;
    
    private JLabel lblImg1;
    private JLabel lblAciertos;
    private JLabel lblAciertosDato;
    
    private JLabel lblImg2;
    private JLabel lblFallos;
    private JLabel lblFallosDato;
    
    private JLabel lblImg3;
    private JLabel lblPuntaje;
    private JLabel lblPuntajeDato;
    
    private JLabel lblImg4;
    private JLabel lblTiempo;
    private JLabel lblTiempoDato;
    
    public GameOverGUI(String titulo, int aciertos, int fallos, int puntaje, String tiempo) {
        super(titulo, false);
        this.aciertos = aciertos;
        this.fallos = fallos;
        this.puntaje = puntaje;
        this.tiempo = tiempo;
        iniciarComponentes();
    }
    
    @Override
    public void iniciarComponentes(){
        //SUBTITULO
        ImageIcon subTitulo = new ImageIcon("ResultadosDeJuego.png");
        lblSubTitulo = new JLabel();
        lblSubTitulo.setBounds(205, 110, 435, 116);
        lblSubTitulo.setIcon(new ImageIcon(subTitulo.getImage().getScaledInstance(lblSubTitulo.getWidth(), lblSubTitulo.getHeight(), Image.SCALE_SMOOTH)));
        add(lblSubTitulo);
        
        //ACIERTOS
        ImageIcon img1 = new ImageIcon("moneda.png");
        lblImg1 = new JLabel();
        lblImg1.setBounds(50, 200, 40, 40);
        lblImg1.setIcon(new ImageIcon(img1.getImage().getScaledInstance(lblImg1.getWidth(), lblImg1.getHeight(), Image.SCALE_DEFAULT)));
        add(lblImg1);
        lblAciertos = new JLabel();
        lblAciertos.setBounds(120, 200, 230, 40);
        lblAciertos.setText("    CANTIDAD DE ACIERTOS:");
        lblAciertos.setBackground(Color.WHITE);
        lblAciertos.setOpaque(true);
        lblAciertos.setBorder(new LineBorder(Color.BLACK,3,false));
        lblAciertos.setFont(new Font("Calibri",Font.BOLD,18));
        lblAciertos.setFocusable(false);
        add(lblAciertos);
        lblAciertosDato = new JLabel();
        lblAciertosDato.setBounds(500, 200, 150, 40);
        lblAciertosDato.setText("    " + String.valueOf(aciertos));
        lblAciertosDato.setBackground(Color.WHITE);
        lblAciertosDato.setOpaque(true);
        lblAciertosDato.setBorder(new LineBorder(Color.BLACK,3,false));
        lblAciertosDato.setFont(new Font("Calibri",Font.BOLD,18));
        lblAciertosDato.setFocusable(false);
        add(lblAciertosDato);
                
        //FALLOS
        ImageIcon img2 = new ImageIcon("moneda.png");
        lblImg2 = new JLabel();
        lblImg2.setBounds(50, 265, 40, 40);
        lblImg2.setIcon(new ImageIcon(img2.getImage().getScaledInstance(lblImg2.getWidth(), lblImg2.getHeight(), Image.SCALE_DEFAULT)));
        add(lblImg2);
        lblFallos = new JLabel();
        lblFallos.setBounds(120, 265, 230, 40);
        lblFallos.setText("    CANTIDAD DE FALLOS:");
        lblFallos.setBackground(Color.WHITE);
        lblFallos.setOpaque(true);
        lblFallos.setBorder(new LineBorder(Color.BLACK,3,false));
        lblFallos.setFont(new Font("Calibri",Font.BOLD,18));
        lblFallos.setFocusable(false);
        add(lblFallos);
        lblFallosDato = new JLabel();
        lblFallosDato.setBounds(500, 265, 150, 40);
        lblFallosDato.setText("    " + String.valueOf(fallos));
        lblFallosDato.setBackground(Color.WHITE);
        lblFallosDato.setOpaque(true);
        lblFallosDato.setBorder(new LineBorder(Color.BLACK,3,false));
        lblFallosDato.setFont(new Font("Calibri",Font.BOLD,18));
        lblFallosDato.setFocusable(false);
        add(lblFallosDato);
        
        
        //PUNTAJE
        ImageIcon img3 = new ImageIcon("moneda.png");
        lblImg3 = new JLabel();
        lblImg3.setBounds(50, 330, 40, 40);
        lblImg3.setIcon(new ImageIcon(img3.getImage().getScaledInstance(lblImg3.getWidth(), lblImg3.getHeight(), Image.SCALE_DEFAULT)));
        add(lblImg3);
        lblPuntaje = new JLabel();
        lblPuntaje.setBounds(120, 330, 230, 40);
        lblPuntaje.setText("    PUNTAJE TOTAL:");
        lblPuntaje.setBackground(Color.WHITE);
        lblPuntaje.setOpaque(true);
        lblPuntaje.setBorder(new LineBorder(Color.BLACK,3,false));
        lblPuntaje.setFont(new Font("Calibri",Font.BOLD,18));
        lblPuntaje.setFocusable(false);
        add(lblPuntaje);
        lblPuntajeDato = new JLabel();
        lblPuntajeDato.setBounds(500, 330, 150, 40);
        lblPuntajeDato.setText("    " + String.valueOf(puntaje));
        lblPuntajeDato.setBackground(Color.WHITE);
        lblPuntajeDato.setOpaque(true);
        lblPuntajeDato.setBorder(new LineBorder(Color.BLACK,3,false));
        lblPuntajeDato.setFont(new Font("Calibri",Font.BOLD,18));
        lblPuntajeDato.setFocusable(false);
        add(lblPuntajeDato);
        
        
        //TIEMPO
        ImageIcon img4 = new ImageIcon("moneda.png");
        lblImg4 = new JLabel();
        lblImg4.setBounds(50, 395, 40, 40);
        lblImg4.setIcon(new ImageIcon(img4.getImage().getScaledInstance(lblImg4.getWidth(), lblImg4.getHeight(), Image.SCALE_DEFAULT)));
        add(lblImg4);
        lblTiempo = new JLabel();
        lblTiempo.setBounds(120, 395, 230, 40);
        lblTiempo.setText("    TIEMPO JUGADO:");
        lblTiempo.setBackground(Color.WHITE);
        lblTiempo.setOpaque(true);
        lblTiempo.setBorder(new LineBorder(Color.BLACK,3,false));
        lblTiempo.setFont(new Font("Calibri",Font.BOLD,18));
        lblTiempo.setFocusable(false);
        add(lblTiempo);
        lblTiempoDato = new JLabel();
        lblTiempoDato.setBounds(500, 395, 150, 40);
        lblTiempoDato.setText("    " + tiempo);
        lblTiempoDato.setBackground(Color.WHITE);
        lblTiempoDato.setOpaque(true);
        lblTiempoDato.setBorder(new LineBorder(Color.BLACK,3,false));
        lblTiempoDato.setFont(new Font("Calibri",Font.BOLD,18));
        lblTiempoDato.setFocusable(false);
        add(lblTiempoDato);
        
        
        
        super.iniciarComponentes();
        
        //CONFIGURACION SOBRE PLANTILLA
        ImageIcon gameOver = new ImageIcon("GameOver.png");
        lblTitulo.setIcon(new ImageIcon(gameOver.getImage().getScaledInstance(lblTitulo.getWidth(), lblTitulo.getHeight(), Image.SCALE_SMOOTH)));
        lblTitulo.setBounds(205, 0, 435, 116);
        txtAInfo.setVisible(false);
        btnVolver.setBounds(670, 450, 140,50);
    }
    
}
