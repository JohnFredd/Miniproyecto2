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
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class InicioGUI extends PlantillaGUI{
    
    private JButton btnJugar;
    private JButton btnComoJugar;
    private JButton btnParaQueSirve;
    private JButton btnMoneda1;
    private JButton btnMoneda2;
    
    public InicioGUI(String titulo){
        super(titulo);
    }
    
    @Override
    public void iniciarComponentes(){
        
        //BOTON JUGAR
        btnJugar = new JButton("JUGAR");
        btnJugar.setBounds(340, 180, 160,65);
        btnJugar.setForeground(Color.BLACK);
        btnJugar.setBackground(Color.WHITE);
        btnJugar.setFont(new Font("Playbill",Font.BOLD,70));
        btnJugar.setFocusPainted(false);
        btnJugar.setRolloverEnabled(false);
        btnJugar.addMouseListener(new ManejadoraDeMouse());
        this.add(btnJugar); 
        
        //BOTÓN CÓMO JUGAR
        ImageIcon comoJugar = new ImageIcon("ComoJugar.png");
        btnComoJugar = new JButton();  
        btnComoJugar.setBounds(15, 380, 304, 84);
        btnComoJugar.setOpaque(false);
        btnComoJugar.setContentAreaFilled(false);
        btnComoJugar.setBorderPainted(false);
        btnComoJugar.setFocusPainted(false);
        btnComoJugar.setIcon(new ImageIcon(comoJugar.getImage().getScaledInstance(btnComoJugar.getWidth(), btnComoJugar.getHeight(), Image.SCALE_SMOOTH)));
        btnComoJugar.addMouseListener(new ManejadoraDeMouse());
        add(btnComoJugar);
        
        //MONEDA 1
        ImageIcon moneda = new ImageIcon("moneda.png");
        btnMoneda1 = new JButton();  
        btnMoneda1.setBounds(90, 350, 150, 150);
        btnMoneda1.setIcon(new ImageIcon(moneda.getImage().getScaledInstance(btnMoneda1.getWidth(), btnMoneda1.getHeight(), Image.SCALE_SMOOTH)));
        btnMoneda1.setOpaque(false);
        btnMoneda1.setContentAreaFilled(false);
        btnMoneda1.setBorderPainted(false);
        btnMoneda1.setFocusPainted(false);
        btnMoneda1.addMouseListener(new ManejadoraDeMouse());
        this.add(btnMoneda1);
        
        //BOTÓN PARA QUE SIRVE
        ImageIcon paraQueSirve = new ImageIcon("ParaQueSirve.png");
        btnParaQueSirve = new JButton();  
        btnParaQueSirve.setBounds(495, 380, 350, 84);
        btnParaQueSirve.setOpaque(false);
        btnParaQueSirve.setContentAreaFilled(false);
        btnParaQueSirve.setBorderPainted(false);
        btnParaQueSirve.setFocusPainted(false);
        btnParaQueSirve.setIcon(new ImageIcon(paraQueSirve.getImage().getScaledInstance(btnParaQueSirve.getWidth(), btnParaQueSirve.getHeight(), Image.SCALE_SMOOTH)));
        btnParaQueSirve.addMouseListener(new ManejadoraDeMouse());
        add(btnParaQueSirve);
        
        //MONEDA 2
        ImageIcon moneda2 = new ImageIcon("moneda2.png");
        btnMoneda2 = new JButton();  
        btnMoneda2.setBounds(600, 350, 150, 150);
        btnMoneda2.setIcon(new ImageIcon(moneda2.getImage().getScaledInstance(btnMoneda2.getWidth(), btnMoneda2.getHeight(), Image.SCALE_SMOOTH)));
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
    
    class ManejadoraDeMouse extends MouseAdapter{
        ImageIcon moneda2 = new ImageIcon("moneda2.png");
        ImageIcon moneda2Iluminada = new ImageIcon("moneda2Retro.png");
        ImageIcon paraQueSirve = new ImageIcon("ParaQueSirve.png");
        ImageIcon paraQueSirveIluminado = new ImageIcon("ParaQueSirveRetro.png");
        ImageIcon moneda = new ImageIcon("moneda.png");
        ImageIcon monedaIluminada = new ImageIcon("monedaRetro.png");
        ImageIcon comoJugar = new ImageIcon("ComoJugar.png");
        ImageIcon comoJugarIluminado = new ImageIcon("ComoJugarRetro.png");

        public void mouseEntered(MouseEvent e) {
            if(e.getSource() == btnMoneda2 | e.getSource() == btnParaQueSirve){
                btnMoneda2.setIcon(new ImageIcon(moneda2Iluminada.getImage().getScaledInstance(btnMoneda2.getWidth(), btnMoneda2.getHeight(), Image.SCALE_SMOOTH)));
                btnParaQueSirve.setIcon(new ImageIcon(paraQueSirveIluminado.getImage().getScaledInstance(btnParaQueSirve.getWidth(), btnParaQueSirve.getHeight(), Image.SCALE_SMOOTH)));            
            }
            if(e.getSource() == btnMoneda1 | e.getSource() == btnComoJugar){
                btnMoneda1.setIcon(new ImageIcon(monedaIluminada.getImage().getScaledInstance(btnMoneda1.getWidth(), btnMoneda1.getHeight(), Image.SCALE_SMOOTH)));
                btnComoJugar.setIcon(new ImageIcon(comoJugarIluminado.getImage().getScaledInstance(btnComoJugar.getWidth(), btnComoJugar.getHeight(), Image.SCALE_SMOOTH)));               
            }
            if(e.getSource() == btnJugar){
                btnJugar.setForeground(Color.WHITE);
                btnJugar.setBackground(Color.BLACK);    
            }
        }
        
        public void mouseExited(MouseEvent e) {
            if(e.getSource() == btnMoneda2| e.getSource() == btnParaQueSirve){
                btnMoneda2.setIcon(new ImageIcon(moneda2.getImage().getScaledInstance(btnMoneda2.getWidth(), btnMoneda2.getHeight(), Image.SCALE_SMOOTH)));
                btnParaQueSirve.setIcon(new ImageIcon(paraQueSirve.getImage().getScaledInstance(btnParaQueSirve.getWidth(), btnParaQueSirve.getHeight(), Image.SCALE_SMOOTH)));            
            }
            if(e.getSource() == btnMoneda1 | e.getSource() == btnComoJugar){
                btnMoneda1.setIcon(new ImageIcon(moneda.getImage().getScaledInstance(btnMoneda1.getWidth(), btnMoneda1.getHeight(), Image.SCALE_SMOOTH)));
                btnComoJugar.setIcon(new ImageIcon(comoJugar.getImage().getScaledInstance(btnComoJugar.getWidth(), btnComoJugar.getHeight(), Image.SCALE_SMOOTH)));            
            }
            if(e.getSource() == btnJugar){
                btnJugar.setForeground(Color.BLACK);
                btnJugar.setBackground(Color.WHITE);   
            }      
        }
    }
}
