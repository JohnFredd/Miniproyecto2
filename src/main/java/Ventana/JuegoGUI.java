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

import Logica.Ficha;
import Logica.Juego;
import Logica.Ronda;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
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
    private JButton btnSoundOn;
    private JButton btnSoundOff;
    private JTextField txtContador;
    private JTextArea txtAtexto;
    private JButton btnFinalizarJuego;
    private JPanel contenidoSuperior;
    private JPanel contenidoDerecho;
    private JPanel contenidoPpal;
    private Container contenedor;
    private Ficha[][] fichas;
    private Ronda ronda;
    private Juego juego;
    private String nombreJugador;
    private JLabel fichaAdivinar;
    private int[] fichaSeleccionada = {0,0};
    private boolean permisoParaSeleccionar;
    private JTextField entrada;
    
    public JuegoGUI(String nombreJugador){
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
        juego();
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
        lblPuntuacion = new JLabel("0",SwingConstants.CENTER);
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
        txtContador.setHorizontalAlignment(JTextField.CENTER);
        contenidoDerecho.add(txtContador);
        
        //TEXTO
        txtAtexto = new JTextArea();
        txtAtexto.setBounds(7, 196, 150, 120);
        txtAtexto.setFont(new Font("Calibri cuerpo",Font.BOLD,16));
        txtAtexto.setBorder(new LineBorder(Color.BLACK,4,false));

        txtAtexto.setEditable(false);
        contenidoDerecho.add(txtAtexto);
        
        //BOTON VOLVER A JUGAR
        btnFinalizarJuego = new JButton();
        btnFinalizarJuego.setText("FINALIZAR");
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
        contenidoPpal.setBackground(Color.BLACK);
        contenidoPpal.setLayout(new GridLayout(5,7));
        contenidoPpal.setBounds(10,125,690, 530);
        contenedor.add(contenidoPpal);
        
        //FONDO VENTANA
        ImageIcon imagen1 = new ImageIcon("fondo.jpg");
        lblFondo = new JLabel();  
        lblFondo.setBounds(0, 0, 900, 700);
        lblFondo.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_SMOOTH)));
        contenedor.add(lblFondo);
        
        //Ficha ADIVINAR
        fichaAdivinar = new JLabel();
        fichaAdivinar.setBounds(7, 326, 150, 150);
        fichaAdivinar.setBorder(new LineBorder(Color.BLACK,4,false));
        fichaAdivinar.setBackground(Color.WHITE);
        fichaAdivinar.setOpaque(true);
        contenidoDerecho.add(fichaAdivinar);
        
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
        long tiempoMS = juego.getTiempoJuego();
        long minutos = tiempoMS/60000;
        long segundos = (tiempoMS-(minutos*60000))/1000;
        String tiempo = String.valueOf(minutos)  + ":" + String.valueOf(segundos);
        GameOverGUI ventanaGameOver = new GameOverGUI("Game Over", juego.getCantAciertos(), juego.getCantFallos(), juego.getPuntajeTotal(), tiempo);
        ventanaGameOver.setVisible(true);
        this.dispose();
    }
    
    class ManejadoraDeFichas extends MouseAdapter {
        
        @Override
        public void mouseClicked(MouseEvent e) {
            boolean acerto;
            if(e.getComponent().isEnabled()) {
                for (int x=0;x<7;x++) {
                    for (int y=0;y<5;y++) {
                        if (e.getSource()==fichas[x][y]) {
                            ImageIcon imagen = new ImageIcon(fichas[x][y].getForma() + ".png");
                            fichas[x][y].setIcon(new ImageIcon(imagen.getImage().getScaledInstance(fichas[x][y].getWidth(), fichas[x][y].getHeight(), Image.SCALE_DEFAULT)));
                            fichas[x][y].setDisabledIcon(new ImageIcon(imagen.getImage().getScaledInstance(fichas[x][y].getWidth(), fichas[x][y].getHeight(), Image.SCALE_DEFAULT)));
                            fichas[x][y].setBackground(fichas[x][y].getColor());
                            fichas[x][y].setEnabled(false);
                            fichas[x][y].setBorder(new CompoundBorder(new LineBorder(Color.BLACK,2,false),new BevelBorder(BevelBorder.LOWERED)));
                            acerto = ronda.comprobarFicha(fichas[x][y],false);
                            if (acerto && ronda.getFichasFaltantes()==0) {
                                juego.actualizarDatos(true);
                                lblPuntuacion.setText(String.valueOf(juego.getPuntajeTotal()));
                                juego();
                            }
                            if (!acerto) {
                                juego.actualizarDatos(false);
                                actualizarVidas();
                                if (juego.getCantFallos()==3) {
                                    irGameOver();
                                }
                                juego();
                            }
                        }
                    }
                }
            }
        }
        
    }
    
    public void juego() {
        permisoParaSeleccionar = false;
        contenidoPpal.removeAll();
        contenedor.addKeyListener(new ManejadoraDeTeclado());
        fichaAdivinar.setIcon(null);
        fichaAdivinar.setBackground(Color.WHITE);
        ronda = new Ronda(juego);
        fichas = ronda.generarMapaFichas();
        txtAtexto.setText("""
                          
                            Observe las
                            figuras
                            detenidamente.
                          """);
        
        for (int x=0;x<7;x++) {
            for (int y=0;y<5;y++) {
                fichas[x][y].setBounds(x, y, 530/5, 690/7);
                ImageIcon imagen = new ImageIcon(fichas[x][y].getForma() + ".png");
                fichas[x][y].setIcon(new ImageIcon(imagen.getImage().getScaledInstance(fichas[x][y].getWidth(), fichas[x][y].getHeight(), Image.SCALE_DEFAULT)));
                fichas[x][y].setDisabledIcon(new ImageIcon(imagen.getImage().getScaledInstance(fichas[x][y].getWidth(), fichas[x][y].getHeight(), Image.SCALE_DEFAULT)));
                fichas[x][y].setBackground(fichas[x][y].getColor());
                fichas[x][y].setBorder(new CompoundBorder(new LineBorder(Color.BLACK,2,false),new CompoundBorder(new BevelBorder(BevelBorder.LOWERED),new BevelBorder(BevelBorder.LOWERED))));
                fichas[x][y].setFocusPainted(false);
                fichas[x][y].setRolloverEnabled(false);
                fichas[x][y].setEnabled(false);
                fichas[x][y].addMouseListener(new ManejadoraDeFichas());
                //fichas[x][y].addKeyListener(new ManejadoraDeTeclado());
                contenidoPpal.add(fichas[x][y]);
            }
        }
        
        Timer timerTexto = new Timer();
        TimerTask taskTexto = new TimerTask() {
            private int t = 5;

            @Override
            public void run() {
                txtContador.setText(String.valueOf(t));
                if (t == 0) {
                    cancel();
                }
                t -= 1;
            }
        };
        timerTexto.schedule(taskTexto, 0,1000);
        
        Timer timerFichas = new Timer();
        TimerTask taskFichas = new TimerTask() {

            @Override
            public void run() {
                permisoParaSeleccionar = true;
                String texto;
                if(ronda.getFichasFaltantes() == 1) {
                    texto = "\n  Encuentre la\n  ficha que\n  cumpla: ";
                } else {
                    texto = "\n  Encuentre las\n  " + ronda.getFichasFaltantes() +" fichas que\n  cumplan: ";
                }
                txtAtexto.setText(texto);
                for (int x=0;x<7;x++) {
                    for (int y=0;y<5;y++) {
                        fichas[x][y].setIcon(null);
                        fichas[x][y].setBackground(Color.WHITE);
                        fichas[x][y].setEnabled(true);
                        fichas[x][y].setBorder(new CompoundBorder(new LineBorder(Color.BLACK,2,false),new BevelBorder(BevelBorder.RAISED)));
                    }
                }
                ImageIcon icono = new ImageIcon(ronda.getFichaAdivinar().getForma() + ".png");
                fichaAdivinar.setIcon(new ImageIcon(icono.getImage().getScaledInstance(fichaAdivinar.getWidth(), fichaAdivinar.getHeight(), Image.SCALE_SMOOTH)));
                fichaAdivinar.setBackground(ronda.getFichaAdivinar().getColor());
            }
        };
        timerFichas.schedule(taskFichas, 6000);
    }
    
    public void actualizarVidas() {
        if (juego.getCantFallos()==1) {
            ImageIcon moneda = new ImageIcon("monedaGris.png");
            lblVida1.setIcon(new ImageIcon(moneda.getImage().getScaledInstance(lblVida1.getWidth(), lblVida1.getHeight(), Image.SCALE_SMOOTH)));
        }
        if (juego.getCantFallos()==2) {
            ImageIcon moneda = new ImageIcon("monedaGris.png");
            lblVida2.setIcon(new ImageIcon(moneda.getImage().getScaledInstance(lblVida2.getWidth(), lblVida2.getHeight(), Image.SCALE_SMOOTH)));
        }
        if (juego.getCantFallos()==3) {
            ImageIcon moneda = new ImageIcon("monedaGris.png");
            lblVida3.setIcon(new ImageIcon(moneda.getImage().getScaledInstance(lblVida3.getWidth(), lblVida3.getHeight(), Image.SCALE_SMOOTH)));
        }
    }
    
    class ManejadoraDeTeclado extends KeyAdapter {
        
        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("Key listener activado, permiso: " + String.valueOf(permisoParaSeleccionar));
            if(permisoParaSeleccionar) {
                switch (e.getKeyChar()) {
                    case KeyEvent.VK_UP -> {
                        if(fichaSeleccionada[1] != 0) {
                            fichaSeleccionada[1] -= 1;
                            cambiarBordeFichaSeleccionada(fichaSeleccionada[0],fichaSeleccionada[1]+1);
                        }
                    }
                    case KeyEvent.VK_DOWN -> {
                        if(fichaSeleccionada[1] != 5) {
                            fichaSeleccionada[1] += 1;
                            cambiarBordeFichaSeleccionada(fichaSeleccionada[0],fichaSeleccionada[1]-1);
                        }
                    }
                    case KeyEvent.VK_RIGHT -> {
                        if(fichaSeleccionada[0] != 7) {
                            fichaSeleccionada[0] += 1;
                            cambiarBordeFichaSeleccionada(fichaSeleccionada[0]-1,fichaSeleccionada[1]);
                        }
                    }
                    case KeyEvent.VK_LEFT -> {
                        if(fichaSeleccionada[0] != 0) {
                            fichaSeleccionada[0] -= 1;
                            cambiarBordeFichaSeleccionada(fichaSeleccionada[0]+1,fichaSeleccionada[1]);
                        }
                    }
                    case KeyEvent.VK_ENTER -> {

                    }
                    case KeyEvent.VK_SPACE -> {

                    }
                }
            }
        }
    }
    public void cambiarBordeFichaSeleccionada(int x, int y){
        fichas[x][y].setBorder(new CompoundBorder(new LineBorder(Color.BLACK,2,false),new BevelBorder(BevelBorder.RAISED)));
        fichas[fichaSeleccionada[0]][fichaSeleccionada[1]].setBorder(new CompoundBorder(new LineBorder(Color.BLACK,2,false),new CompoundBorder(new BevelBorder(BevelBorder.RAISED),new BevelBorder(BevelBorder.RAISED))));
    }
}
