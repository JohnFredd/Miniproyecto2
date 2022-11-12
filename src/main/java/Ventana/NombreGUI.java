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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class NombreGUI extends PlantillaGUI{       
    
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JButton btnContinuar;
    
    public NombreGUI(String titulo){
        super(titulo);
        verificarTexto(txtNombre);
        verificarLongitud();
    }
    
    @Override
    public void iniciarComponentes(){
        
        //BOTON CONTINUAR
        btnContinuar = new JButton("CONTINUAR");
        btnContinuar.setBounds(310, 435, 240,65);
        btnContinuar.setForeground(Color.BLACK);
        btnContinuar.setBackground(Color.WHITE);
        btnContinuar.setFont(new Font("Playbill",Font.BOLD,70));
        btnContinuar.setFocusPainted(false);
        btnContinuar.setBorder(new LineBorder(Color.BLACK,2,false));
        btnContinuar.setRolloverEnabled(false);
        btnContinuar.addMouseListener(new ManejadoraDeMouse());
        add(btnContinuar); 
        
        //LABEL NOMBRE
        ImageIcon nombre = new ImageIcon("IngresaTuNombre.png"); 
        lblNombre = new JLabel();
        lblNombre.setBounds(271, 325, 317,60);
        lblNombre.setIcon(new ImageIcon(nombre.getImage().getScaledInstance(lblNombre.getWidth(), lblNombre.getHeight(), Image.SCALE_SMOOTH)));
        add(lblNombre);
        
        //CAMPO INGRESAR NOMBRE
        txtNombre = new JTextField(25);
        txtNombre.setBackground(Color.WHITE);
        txtNombre.setBounds(360, 387, 140, 35);
        txtNombre.setFont(new Font("Arial",Font.PLAIN,14));
        txtNombre.setColumns(14);
        txtNombre.setHorizontalAlignment(JTextField.CENTER);
        add(txtNombre);
        
        super.iniciarComponentes();
        
        //CONFIGURACION SOBRE PLANTILLA
        txtAInfo.setVisible(false);
        btnVolver.setBounds(30, 450, 140,50);
    }
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            if (e.getSource() == btnContinuar){
                if (e.getButton() == 1){
                    if (txtNombre.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Por favor ingrese un nombre para continuar", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        irJuegoGUI(); 
                    }
                } else{
                    e.consume();
                }  
            }
        }
 
        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource() == btnContinuar){
                btnContinuar.setBackground(Color.BLACK);
                btnContinuar.setForeground(Color.WHITE);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(e.getSource() == btnContinuar){
                btnContinuar.setBackground(Color.WHITE);
                btnContinuar.setForeground(Color.BLACK);
            }
        }

        @Override
        public void mousePressed(MouseEvent e){
            if(e.getSource() == btnContinuar){
                if (e.getButton() == 1){
                    btnContinuar.setBackground(Color.WHITE);
                    btnContinuar.setForeground(Color.BLACK);
                } else{
                    e.consume();
                } 
            }
        }
        
        @Override
        public void mouseReleased(MouseEvent e){
            if(e.getSource() == btnContinuar){
                if (e.getButton() == 1){
                    btnContinuar.setBackground(Color.BLACK);
                    btnContinuar.setForeground(Color.WHITE);
                } else{
                    e.consume();
                }
            }   
        }   
    }
    
    public void irJuegoGUI(){
        JuegoGUI ventanaJuego = new JuegoGUI(/*juego, ronda*/txtNombre.getText());
        ventanaJuego.setVisible(true);
        this.dispose();
    }
    
    private void verificarTexto(JTextField a){
        a.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (!Character.isAlphabetic(c) && !Character.isSpaceChar(c)){
                    e.consume();
                }
            }
        });
    }
    private void verificarLongitud(){
        txtNombre.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent evt){
                if (txtNombre.getText().length() > 18){
                    evt.consume();
            }
            }
        });
    }
}
