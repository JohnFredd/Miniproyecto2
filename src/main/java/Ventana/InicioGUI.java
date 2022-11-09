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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class InicioGUI extends PlantillaGUI{
    
    private JButton btnJugar;
    private JButton btnComoJugar;
    private JButton btnParaQueSirve;
    private JLabel lblMoneda1;
    private JButton btnMoneda2;
    private JButton btnComoJugar2;
    
    public InicioGUI(String titulo){
        super(titulo);
        
    }
    
    @Override
    public void iniciarComponentes(){
        
        //BOTON COMO JUGAR
        ImageIcon moneda = new ImageIcon("moneda1.png");
        btnComoJugar = new JButton(moneda);
        btnComoJugar.setBounds(45, 350, 205, 150);
        btnComoJugar.setIcon(new ImageIcon(moneda.getImage().getScaledInstance(btnComoJugar.getWidth(), btnComoJugar.getHeight(), Image.SCALE_SMOOTH)));
        btnComoJugar.setRolloverEnabled(false);
        btnComoJugar.setOpaque(false);
        btnComoJugar.setContentAreaFilled(false);
        //btnComoJugar.setBorderPainted(false);
        btnComoJugar.setFocusPainted(false);
        this.add(btnComoJugar);
        /*moneda.getImage().getScaledInstance(btnComoJugar.getWidth(), btnComoJugar.getHeight(), Image.SCALE_SMOOTH);
        btnComoJugar = new JButton("CÓMO JUGAR");
        btnComoJugar.setForeground(Color.WHITE);
        btnComoJugar.setFont(new Font("Playbill",Font.BOLD,50));
        btnComoJugar.addMouseListener(new ManejadoraDeMouse());*/
        
        /*
        //OtroComoJugar
        btnComoJugar2 = new JButton("CÓMO JUGAR");
        btnComoJugar2.setFont(new Font("Playbill",Font.BOLD,50));
        btnComoJugar2.setForeground(Color.WHITE);
        btnComoJugar2.setBounds(45, 350, 220, 150);
        btnComoJugar2.setRolloverEnabled(false);
        btnComoJugar2.setOpaque(false);
        btnComoJugar2.setContentAreaFilled(false);
        //btnComoJugar2.setBorderPainted(false);
        btnComoJugar2.setFocusPainted(false);
        add(btnComoJugar2);

        //MONEDA 1
        ImageIcon imagen1 = new ImageIcon("moneda.png");
        lblMoneda1 = new JLabel();  
        lblMoneda1.setBounds(80, 350, 150, 150);
        lblMoneda1.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(lblMoneda1.getWidth(), lblMoneda1.getHeight(), Image.SCALE_SMOOTH)));
        this.add(lblMoneda1);
        */
        
        //LABEL PARA QUE SIRVE
        ImageIcon paraQueSirve = new ImageIcon("ParaQueSirve.png");
        ImageIcon paraQueSirveIluminado = new ImageIcon("ParaQueSirveRetro.png");
        btnParaQueSirve = new JButton();  
        btnParaQueSirve.setBounds(488, 375, 350, 84); //488, 375, 375, 90
        //btnParaQueSirve.setOpaque(true);
        //btnParaQueSirve.setBackground(Color.BLUE);
        btnParaQueSirve.setOpaque(false);
        btnParaQueSirve.setContentAreaFilled(false);
        btnParaQueSirve.setBorderPainted(false);
        btnParaQueSirve.setFocusPainted(false);
        btnParaQueSirve.setIcon(new ImageIcon(paraQueSirve.getImage().getScaledInstance(btnParaQueSirve.getWidth(), btnParaQueSirve.getHeight(), Image.SCALE_SMOOTH)));
        btnParaQueSirve.setRolloverIcon(new ImageIcon(paraQueSirveIluminado.getImage().getScaledInstance(btnParaQueSirve.getWidth(), btnParaQueSirve.getHeight(), Image.SCALE_SMOOTH)));

        btnParaQueSirve.addMouseListener(new ManejadoraDeMouse());
        add(btnParaQueSirve);
        
        //MONEDA 2
        ImageIcon imagen2 = new ImageIcon("moneda2.png");
        ImageIcon moneda2Iluminada = new ImageIcon("moneda2Retro.png");

        btnMoneda2 = new JButton();  
        btnMoneda2.setBounds(600, 350, 150, 150);
        btnMoneda2.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(btnMoneda2.getWidth(), btnMoneda2.getHeight(), Image.SCALE_SMOOTH)));
        btnMoneda2.setRolloverIcon(new ImageIcon(moneda2Iluminada.getImage().getScaledInstance(btnMoneda2.getWidth(), btnMoneda2.getHeight(), Image.SCALE_SMOOTH)));        
        btnMoneda2.setOpaque(false);
        btnMoneda2.setContentAreaFilled(false);
        btnMoneda2.setBorderPainted(false);
        btnMoneda2.setFocusPainted(false);
        btnMoneda2.addMouseListener(new ManejadoraDeMouse());

        this.add(btnMoneda2);
        
        
        super.iniciarComponentes();
        
        //CONFIGURACION SOBRE PLANTILLA
        txtAInfo.setVisible(false);
        btnVolver.setVisible(false);
        
    }
    /*
    class ManejadoraDeMouse extends MouseAdapter{
        ImageIcon moneda2 = new ImageIcon("moneda2.png");
        ImageIcon moneda2Iluminada = new ImageIcon("moneda2Retro.png");
        ImageIcon paraQueSirve = new ImageIcon("ParaQueSirve.png");
        ImageIcon paraQueSirveIluminado = new ImageIcon("ParaQueSirveRetro.png");

        public void mouseEntered(MouseEvent e) {
            if(e.getSource() == lblMoneda2){
                lblMoneda2.setIcon(new ImageIcon(moneda2Iluminada.getImage().getScaledInstance(lblMoneda2.getWidth(), lblMoneda2.getHeight(), Image.SCALE_SMOOTH)));
                lblParaQueSirve.setIcon(new ImageIcon(paraQueSirveIluminado.getImage().getScaledInstance(lblParaQueSirve.getWidth(), lblParaQueSirve.getHeight(), Image.SCALE_SMOOTH)));            
            }
            if(e.getSource() == lblParaQueSirve){
                lblMoneda2.setIcon(new ImageIcon(moneda2Iluminada.getImage().getScaledInstance(lblMoneda2.getWidth(), lblMoneda2.getHeight(), Image.SCALE_SMOOTH)));                
                lblParaQueSirve.setIcon(new ImageIcon(paraQueSirveIluminado.getImage().getScaledInstance(lblParaQueSirve.getWidth(), lblParaQueSirve.getHeight(), Image.SCALE_SMOOTH)));

            }
        }

        public void mouseExited(MouseEvent e) {
            if(e.getSource() == lblMoneda2){
                lblMoneda2.setIcon(new ImageIcon(moneda2.getImage().getScaledInstance(lblMoneda2.getWidth(), lblMoneda2.getHeight(), Image.SCALE_SMOOTH)));
                lblParaQueSirve.setIcon(new ImageIcon(paraQueSirve.getImage().getScaledInstance(lblParaQueSirve.getWidth(), lblParaQueSirve.getHeight(), Image.SCALE_SMOOTH)));            
            }
            if(e.getSource() == lblParaQueSirve){
                lblMoneda2.setIcon(new ImageIcon(moneda2.getImage().getScaledInstance(lblMoneda2.getWidth(), lblMoneda2.getHeight(), Image.SCALE_SMOOTH)));                
                lblParaQueSirve.setIcon(new ImageIcon(paraQueSirve.getImage().getScaledInstance(lblParaQueSirve.getWidth(), lblParaQueSirve.getHeight(), Image.SCALE_SMOOTH)));
            }
        }
        
    }*/
}
