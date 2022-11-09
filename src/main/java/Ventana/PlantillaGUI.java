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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class PlantillaGUI extends JFrame{
    
    protected JLabel lblTitulo;
    protected JLabel lblFondo;
    protected JTextArea txtAInfo;
    protected JButton btnVolver;
    
    public PlantillaGUI(String titulo){
        
        iniciarComponentes();
        UIManager.put( "Button.select", false );
        setSize(860,550);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(titulo);
        
    }
    
    public void iniciarComponentes(){
        //LABEL TITULO
        ImageIcon titulo = new ImageIcon("titulo.png");
        lblTitulo = new JLabel();
        lblTitulo.setBounds(205, 20, 435, 116);
        lblTitulo.setIcon(new ImageIcon(titulo.getImage().getScaledInstance(lblTitulo.getWidth(), lblTitulo.getHeight(), Image.SCALE_SMOOTH)));
        add(lblTitulo);
        
        //BOTON VOLVER
        btnVolver = new JButton("VOLVER");
        btnVolver.setBounds(360, 450, 140,50);
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setBackground(Color.WHITE);
        btnVolver.setFont(new Font("Playbill",Font.BOLD,50));
        btnVolver.setFocusPainted(false);
        btnVolver.setRolloverEnabled(false);
        btnVolver.addMouseListener(new ManejadoraDeMouse());
        this.add(btnVolver);
        
        //TEXTAREA
        txtAInfo = new JTextArea();
        txtAInfo.setEditable(false);
        txtAInfo.setBounds(150, 315, 550, 120);
        txtAInfo.setFont(new Font("Calibri",Font.PLAIN,17));
        this.add(txtAInfo);
        
        //FONDO
        ImageIcon imagen1 = new ImageIcon("fondo.jpg");
        lblFondo = new JLabel();  
        lblFondo.setBounds(0, 0, 860, 550);
        lblFondo.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_SMOOTH)));
        this.add(lblFondo);
        
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        public void mouseClicked(MouseEvent e){
            if (e.getSource() == btnVolver){
                if (e.getButton() == 1){
                    irInicioGUI();
                } else{
                    e.consume();
                }  
            }
        }
 
        public void mouseEntered(MouseEvent e) {
            if(e.getSource() == btnVolver){
                btnVolver.setBackground(Color.BLACK);
                btnVolver.setForeground(Color.WHITE);
            }
        }

        public void mouseExited(MouseEvent e) {
            if(e.getSource() == btnVolver){
                btnVolver.setBackground(Color.WHITE);
                btnVolver.setForeground(Color.BLACK);
            }
        }

        public void mousePressed(MouseEvent e){
            if(e.getSource() == btnVolver){
                if (e.getButton() == 1){
                    btnVolver.setBackground(Color.WHITE);
                    btnVolver.setForeground(Color.BLACK);
                } else{
                    e.consume();
                } 
            }
        }
        
        public void mouseReleased(MouseEvent e){
            if(e.getSource() == btnVolver){
                if (e.getButton() == 1){
                    btnVolver.setBackground(Color.BLACK);
                    btnVolver.setForeground(Color.WHITE);
                } else{
                    e.consume();
                }
            }   
        }   
    }
    public void irInicioGUI(){
        InicioGUI ventanaInicio = new InicioGUI("Inicio");
        ventanaInicio.setVisible(true);
        this.dispose();
    }
}
