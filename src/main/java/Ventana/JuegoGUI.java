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

import Logica.Juego;
import Logica.Ronda;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class JuegoGUI extends JFrame{
    
    private JLabel lblFondo;
    private JLabel lblPlayerName;
    private JLabel lblPuntuacion;
    private JLabel lblVida1;
    private JLabel lblVida2;
    private JLabel lblVida3;
    private JLabel lblSonido;
    private JLabel lblTiempo;
    private JLabel lblFigAAdivinar;
    private JButton btnSoundOn;
    private JButton btnSoundOff;
    private JTextField txtContador;
    private JTextArea txtAtexto;
    private JButton btnFinalizarJuego;
    private JPanel contenidoSuperior;
    private JPanel contenidoDerecho;
    private JPanel contenidoPpal;
    private Container contenedor;
    private JButton[] fichas;
    private Ronda ronda;
    private Juego juego;
    private String nombreJugador;
    
    public JuegoGUI(/*Juego juego, Ronda ronda*/String nombreJugador){
        //this.juego = juego;
        //this.ronda = ronda;
        this.nombreJugador = nombreJugador;
        iniciarComponentes();
        UIManager.put( "Button.select", false );
        setSize(900,700);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Memorabble");
        juego = new Juego();
    }
    public void iniciarComponentes(){
        
        contenedor = getContentPane();
        contenedor.setLayout(null);
        
        //Panel de contenido superior
        contenidoSuperior = new JPanel();
        contenidoSuperior.setOpaque(false);
        
        //contenidoSuperior.setBackground(Color.BLUE);
        contenidoSuperior.setLayout(null);
        contenidoSuperior.setBounds(10, 10, 690, 105);
        contenedor.add(contenidoSuperior);
        
        //LABEL Sonido
        lblSonido = new JLabel("SONIDO",SwingConstants.CENTER);
        lblSonido.setBounds(10, 10, 130, 35);
        lblSonido.setFont(new Font("Calibri cuerpo",Font.PLAIN, 25));
        lblSonido.setOpaque(true);
        lblSonido.setForeground(Color.BLACK);
        lblSonido.setBackground(Color.WHITE);
        lblSonido.setBorder(new LineBorder(Color.BLACK,4,false));
        contenidoSuperior.add(lblSonido);
        
        //BOTÓN SONIDO ON
        btnSoundOn = new JButton("ON");
        btnSoundOn.setBounds(150, 10, 70,35);
        btnSoundOn.setFont(new Font("Calibri cuerpo",Font.BOLD,20));
        btnSoundOn.setForeground(Color.BLACK);
        btnSoundOn.setBackground(Color.WHITE);
        btnSoundOn.setBorder(new LineBorder(Color.RED,4,false));
        btnSoundOn.setFocusPainted(false);
        btnSoundOn.setRolloverEnabled(false);
        btnSoundOn.setEnabled(false);
        btnSoundOn.addMouseListener(new ManejadoraDeMouse());
        contenidoSuperior.add(btnSoundOn);
        
        //BOTÓN SONIDO OFF
        btnSoundOff = new JButton("OFF");
        btnSoundOff.setBounds(225, 10, 78,35);
        btnSoundOff.setFont(new Font("Calibri cuerpo",Font.BOLD,20));
        btnSoundOff.setForeground(Color.BLACK);
        btnSoundOff.setBackground(Color.WHITE);
        btnSoundOff.setBorder(new LineBorder(Color.RED,4,false));
        btnSoundOff.setFocusPainted(false);
        btnSoundOff.addMouseListener(new ManejadoraDeMouse());
        btnSoundOff.setRolloverEnabled(false);
        btnSoundOff.setEnabled(true);
        contenidoSuperior.add(btnSoundOff);
        
        //LABEL PUNTUACIÓN
        lblPuntuacion = new JLabel("PUNTUACIÓN:",SwingConstants.CENTER);
        lblPuntuacion.setBounds(350, 10, 190, 35);
        lblPuntuacion.setFont(new Font("Calibri cuerpo",Font.PLAIN, 25));
        lblPuntuacion.setOpaque(true);
        lblPuntuacion.setForeground(Color.BLACK);
        lblPuntuacion.setBackground(Color.WHITE);
        lblPuntuacion.setBorder(new LineBorder(Color.BLACK,4,false));
        contenidoSuperior.add(lblPuntuacion);
        
        //LABEL NÚMERO DE PUNTUACIÓN
        lblPuntuacion = new JLabel("1.000.000",SwingConstants.CENTER);
        lblPuntuacion.setBounds(550, 10, 130, 35);
        lblPuntuacion.setFont(new Font("Calibri cuerpo",Font.PLAIN, 20));
        lblPuntuacion.setOpaque(true);
        lblPuntuacion.setForeground(Color.BLACK);
        lblPuntuacion.setBackground(Color.WHITE);
        lblPuntuacion.setBorder(new LineBorder(Color.BLACK,4,false));
        contenidoSuperior.add(lblPuntuacion);
        
        //LABEL NOMBRE JUGADOR
        lblPlayerName = new JLabel("JUGADOR: " + nombreJugador, SwingConstants.CENTER);
        lblPlayerName.setBounds(120, 55, 440, 42);
        lblPlayerName.setFont(new Font("Arial",Font.PLAIN, 24));
        lblPlayerName.setOpaque(true);
        lblPlayerName.setBackground(Color.WHITE);
        lblPlayerName.setForeground(Color.BLACK);
        lblPlayerName.setBorder(new LineBorder(Color.BLACK,4,false));
        contenidoSuperior.add(lblPlayerName);
        
        //Panel de contenido derecho
        contenidoDerecho = new JPanel();
        contenidoDerecho.setLayout(null);
        contenidoDerecho.setBounds(710,10,165, 645); //Altura botones ventana: 35
        contenidoDerecho.setOpaque(false);
        contenedor.add(contenidoDerecho);
        
        //IMAGEN VIDA 1
        ImageIcon moneda = new ImageIcon("moneda.png");
        lblVida1 = new JLabel();
        lblVida1.setBounds(10, 55, 50, 50);
        lblVida1.setIcon(new ImageIcon(moneda.getImage().getScaledInstance(lblVida1.getWidth(), lblVida1.getHeight(), Image.SCALE_SMOOTH)));
        contenidoDerecho.add(lblVida1);
        
        //IMAGEN VIDA 2
        ImageIcon moneda2 = new ImageIcon("moneda.png");
        lblVida2 = new JLabel();
        lblVida2.setBounds(57, 10, 50, 50);
        lblVida2.setIcon(new ImageIcon(moneda2.getImage().getScaledInstance(lblVida2.getWidth(), lblVida2.getHeight(), Image.SCALE_SMOOTH)));
        contenidoDerecho.add(lblVida2);
        
        //IMAGEN VIDA 3
        ImageIcon moneda3 = new ImageIcon("moneda.png");
        lblVida3 = new JLabel();
        lblVida3.setBounds(100, 55, 50, 50);
        lblVida3.setIcon(new ImageIcon(moneda3.getImage().getScaledInstance(lblVida3.getWidth(), lblVida3.getHeight(), Image.SCALE_SMOOTH)));
        contenidoDerecho.add(lblVida3);
        
        //LABEL TIEMPO
        lblTiempo = new JLabel("TIEMPO", SwingConstants.CENTER);
        lblTiempo.setBounds(22, 115, 120, 40);
        lblTiempo.setFont(new Font("Calibri cuerpo",Font.PLAIN, 24));
        lblTiempo.setOpaque(true);
        lblTiempo.setBackground(Color.WHITE);
        lblTiempo.setForeground(Color.BLACK);
        lblTiempo.setBorder(new LineBorder(Color.BLACK,4,false));
        contenidoDerecho.add(lblTiempo);
        
        //TEXTO CONTADOR
        txtContador = new JTextField(20);
        txtContador.setBounds(12, 151, 140, 35);
        txtContador.setFont(new Font("Arial",Font.PLAIN,16));
        txtContador.setBackground(Color.WHITE);
        txtContador.setBorder(new LineBorder(Color.BLACK,4,false));
        txtContador.setEditable(false);
        txtContador.setText("11:11");
        txtContador.setHorizontalAlignment(JTextField.CENTER);
        contenidoDerecho.add(txtContador);
        
        //TEXTO
        txtAtexto = new JTextArea();
        txtAtexto.setBounds(7, 196, 150, 120);
        txtAtexto.setFont(new Font("Calibri cuerpo",Font.BOLD,16));
        txtAtexto.setBorder(new LineBorder(Color.BLACK,4,false));

        txtAtexto.setEditable(false);
        txtAtexto.setText("""
                          
                                  Observe
                                      las
                                   figuras
                              detenidamente
                          
                          """);
        contenidoDerecho.add(txtAtexto);
        
        //IMAGEN FIGURA A ADIVINAR
        ImageIcon figuraAdivinar = new ImageIcon("cruz.jpeg");
        lblFigAAdivinar = new JLabel();
        lblFigAAdivinar.setBounds(7, 326, 150, 150);
        lblFigAAdivinar.setIcon(new ImageIcon(figuraAdivinar.getImage().getScaledInstance(lblFigAAdivinar.getWidth(), lblFigAAdivinar.getHeight(), Image.SCALE_SMOOTH)));
        lblFigAAdivinar.setBorder(new LineBorder(Color.BLACK,4,false));
        contenidoDerecho.add(lblFigAAdivinar);
        
        //BOTON VOLVER A JUGAR
        btnFinalizarJuego = new JButton();
        btnFinalizarJuego.setText("FINALIZAR JUEGO");
        btnFinalizarJuego.setBounds(7, 575, 150, 60);
        btnFinalizarJuego.setForeground(Color.BLACK);
        btnFinalizarJuego.setBackground(Color.WHITE);
        btnFinalizarJuego.setFont(new Font("Calibri cuerpo",Font.BOLD,16));
        btnFinalizarJuego.setFocusPainted(false);
        btnFinalizarJuego.setBorder(new LineBorder(Color.RED,4,false));
        btnFinalizarJuego.setRolloverEnabled(false);
        btnFinalizarJuego.addMouseListener(new ManejadoraDeMouse());
        contenidoDerecho.add(btnFinalizarJuego); 
        
        //Panel de contenido principal
        contenidoPpal = new JPanel();
        contenidoPpal.setBackground(Color.DARK_GRAY);
        contenidoPpal.setLayout(new GridLayout(5,9));
        contenidoPpal.setBounds(10,125,690, 530);
        contenedor.add(contenidoPpal);
        
        //FONDO VENTANA
        ImageIcon imagen1 = new ImageIcon("fondo.jpg");
        lblFondo = new JLabel();  
        lblFondo.setBounds(0, 0, 900, 700);
        lblFondo.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_SMOOTH)));
        contenedor.add(lblFondo);
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseEntered(MouseEvent e) {
            
            if(btnSoundOn.isEnabled()){
                if(e.getSource() == btnSoundOn){
                    soundOnIluminado();
                }
            } else {
                e.consume();
                soundOnPlano();
            }
            
            if(btnSoundOff.isEnabled()){
                if(e.getSource() == btnSoundOff){
                    soundOffIluminado();
                }
            } else {
                e.consume();
                soundOffPlano();
            }
            
            if(e.getSource() == btnFinalizarJuego){
                finalizarIluminado();   
            }
        }
        
        @Override
        public void mouseExited(MouseEvent e) {
            
            if(btnSoundOn.isEnabled()){
                if(e.getSource() == btnSoundOn){
                    soundOnPlano();
                }
            } else {
                e.consume();
                soundOnPlano();
            }
            
            if(btnSoundOff.isEnabled()){
                if(e.getSource() == btnSoundOff){
                    soundOffPlano();
                }
            } else {
                e.consume();
                soundOffPlano();
            }
             
            if(e.getSource() == btnFinalizarJuego){
                finalizarPlano();
            }
        }
        
        @Override
        public void mousePressed(MouseEvent e){
            if(btnSoundOn.isEnabled()){
                if(e.getSource() == btnSoundOn){
                    if (e.getButton() == 1){
                        soundOnPlano();
                    } else{
                        e.consume();
                        soundOnPlano();
                    }
                }
            } else {
                e.consume();
            }
            if(btnSoundOff.isEnabled()){
                if(e.getSource() == btnSoundOff){
                    if (e.getButton() == 1){
                        soundOffPlano();
                    } else{
                        e.consume();
                    }
                }
            } else {
                e.consume();
            }
            if(e.getSource() == btnFinalizarJuego){
                if (e.getButton() == 1){
                    finalizarPlano();
                } else{
                    e.consume();
                } 
            }
        }
        
        @Override
        public void mouseReleased(MouseEvent e){
            if(btnSoundOn.isEnabled()){
                if(e.getSource() == btnSoundOn){
                    if (e.getButton() == 1){
                        soundOnIluminado();
                    } else{
                        e.consume();
                        soundOnPlano();
                    }    
                }  
            } else {
                e.consume();
            }
            
            if(btnSoundOff.isEnabled()){
                if(e.getSource() == btnSoundOff){
                    if (e.getButton() == 1){
                        soundOffIluminado();
                    } else{
                        e.consume();
                    }
                }
            } else {
                e.consume();
            } 
            
            if(e.getSource() == btnFinalizarJuego){
                if (e.getButton() == 1){
                    finalizarIluminado();
                } else{
                    e.consume();
                }
            }
        }
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == btnSoundOn){
                if (e.getButton() == 1){
                    btnSoundOn.setEnabled(false);
                    btnSoundOff.setEnabled(true);
                    btnSoundOn.setFocusPainted(false);
                    btnSoundOn.setRolloverEnabled(false);
                } else{
                    e.consume();
                }
            }
            if (e.getSource() == btnSoundOff){
                if (e.getButton() == 1){
                    btnSoundOff.setEnabled(false);
                    btnSoundOn.setEnabled(true);
                } else{
                    e.consume();
                }
            }
            if (e.getSource() == btnFinalizarJuego){
                if (e.getButton() == 1){
                    int resp = JOptionPane.showConfirmDialog(null, "¿Estás seguro que quieres\nabandonar el juego?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (resp == JOptionPane.NO_OPTION){
                        
                    }
                    if (resp == JOptionPane.YES_OPTION){
                        irGameOver();
                        } 
                    }
                } else{
                    e.consume();
                }
            }
        }
    
    public void soundOnIluminado(){
        btnSoundOn.setForeground(Color.WHITE);
        btnSoundOn.setBackground(Color.BLACK);
    }
    
    public void soundOnPlano(){
        btnSoundOn.setForeground(Color.BLACK);
        btnSoundOn.setBackground(Color.WHITE);
    }
    
    public void soundOffIluminado(){
        btnSoundOff.setForeground(Color.WHITE);
        btnSoundOff.setBackground(Color.BLACK);
    }
    public void soundOffPlano(){
        btnSoundOff.setForeground(Color.BLACK);
        btnSoundOff.setBackground(Color.WHITE);
    }
    
    public void finalizarIluminado(){
        btnFinalizarJuego.setForeground(Color.WHITE);
        btnFinalizarJuego.setBackground(Color.BLACK);
    }
    public void finalizarPlano(){
        btnFinalizarJuego.setForeground(Color.BLACK);
        btnFinalizarJuego.setBackground(Color.WHITE);
    }
    
    public void irGameOver(){
        GameOverGUI ventanaGameOver = new GameOverGUI("Game Over", 2, 3, 10000, "1:20");
        ventanaGameOver.setVisible(true);
        this.dispose();
    }   
}
