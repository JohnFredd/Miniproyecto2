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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


public class ComoJugarGUI extends PlantillaGUI {
    

    private JLabel lblImagen;
    private JButton btnFlechaDer;
    private JButton btnFlechaIzq;
    int paginaAct;
    
    public ComoJugarGUI(String titulo){
        super(titulo);
    }
    
   @Override
   public void iniciarComponentes(){

       paginaAct = 1;
       //panel 1
       /*panel1 = new JPanel ();
       panel1.setEnabled(false);
       panel1.setVisible(true);
       panel1.setBounds(260,115,310,175);
       /*panel1.setForeground(Color.BLACK);
       panel1.setBackground(Color.WHITE);
       panel1.setFont(new Font("chiller",Font.BOLD,22));
       this.add(panel1); */
       
       //IMAGEN 1 
       ImageIcon imagen = new ImageIcon ("corazon.png");
       lblImagen = new JLabel();
       lblImagen.setBounds(260,115,310,175);
       lblImagen.setEnabled(false);
       lblImagen.setVisible(true);
       lblImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH)));
       this.add(lblImagen);
       
       
       //BOTON FLECHA DERECHA
       ImageIcon flechaDer = new ImageIcon("flechaDer.png");
       btnFlechaDer = new JButton();
       btnFlechaDer.setEnabled(true);
       btnFlechaDer.setVisible(true);
       btnFlechaDer.setBounds(670, 175, 60,50);
       btnFlechaDer.setIcon(new ImageIcon(flechaDer.getImage().getScaledInstance(btnFlechaDer.getWidth(), btnFlechaDer.getHeight(), Image.SCALE_SMOOTH)));
       btnFlechaDer.setContentAreaFilled(false);
       btnFlechaDer.setBorderPainted(false);
       btnFlechaDer.setFocusPainted(false);
       btnFlechaDer.addMouseListener(new ComoJugarGUI.ManejadoraDeMouse());
       this.add(btnFlechaDer);
       
       //BOTON FLECHA IZQUIERDA
       ImageIcon flechaIzq = new ImageIcon("flechaIzq.png");
       btnFlechaIzq = new JButton();
       btnFlechaIzq.setEnabled(false);
       btnFlechaIzq.setVisible(false);
       btnFlechaIzq.setBounds(100, 175, 60,50);
       btnFlechaIzq.setIcon(new ImageIcon(flechaIzq.getImage().getScaledInstance(btnFlechaIzq.getWidth(), btnFlechaIzq.getHeight(), Image.SCALE_SMOOTH)));
       btnFlechaIzq.setContentAreaFilled(false);
       btnFlechaIzq.setBorderPainted(false);
       btnFlechaIzq.setFocusPainted(false);
       btnFlechaIzq.addMouseListener(new ComoJugarGUI.ManejadoraDeMouse());
       this.add(btnFlechaIzq);
       
       super.iniciarComponentes();
       
       
       //CONFIGURACION SOBRE PLANTILLA

       //paginaAct = 1 ;
       cargarInfo();
       //txtAInfo.append("\n    Un juego que te permite entrenar tu capacid  ad de\n");
       System.out.print(paginaAct);
       //paginaAct = 0 ;
       
       //TITULO
       ImageIcon titulo = new ImageIcon("ComoJugar.png");
       lblTitulo.setIcon(new ImageIcon(titulo.getImage().getScaledInstance(lblTitulo.getWidth(), lblTitulo.getHeight(), Image.SCALE_SMOOTH)));
       lblTitulo.setBounds(185, 0, 500, 120);
       
       //AREA DE TEXTO
       txtAInfo.setBounds(40, 315, 770, 120);

       //BOTON VOLVER
       btnVolver.setBounds(345, 450, 140, 50);
   }
   
    public void cargarInfo1(){
       txtAInfo.setText(" ");
       txtAInfo.append("\n    Un juego que te permite entrenar tu capacidad de\n");
       ImageIcon imagen = new ImageIcon("corazon.png");
       lblImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH)));
       
   }
   public void cargarInfo2(){
       txtAInfo.setText(" ");
       txtAInfo.append("    codificación y recuerdo de información visual y espacial.\n");
       ImageIcon imagen2= new ImageIcon("corazon.png");
       lblImagen.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH)));
  
   }
   public void cargarInfo3(){
       txtAInfo.setText(" ");
       txtAInfo.append("    Este tipo de habilidades es relevante en la práctica de\n");
       ImageIcon imagen = new ImageIcon("corazon.png");
       lblImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH)));
  
   }
   public void cargarInfo4(){
       txtAInfo.setText(" ");
       txtAInfo.append("    algunos deportes, el reconocimiento de caras o para\n");
       ImageIcon imagen= new ImageIcon("corazon.png");
       lblImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH)));
  
   }
   public void cargarInfo5(){
       txtAInfo.setText(" ");
       txtAInfo.append("    recordar dónde guardamos nuestras cosas.");
       ImageIcon imagen = new ImageIcon("corazon.png");
       lblImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH)));
  
   }
   public void cargarInfo(){
       switch (paginaAct) {
           case 1 ->{
           cargarInfo1(); 
           }
           case 2 ->{
           cargarInfo2(); 
           }
           case 3 ->{
           cargarInfo3(); 
           }
           case 4 ->{
           cargarInfo4(); 
           }
           case 5 ->{
           cargarInfo5(); 
           }
       }
   }
   
   class ManejadoraDeMouse extends MouseAdapter{
       @Override
       public void mouseEntered(MouseEvent e) {

            if(e.getSource() == btnFlechaIzq ){
                btnFlechaIzqPress();
            }
            if(e.getSource() == btnFlechaDer ){
                btnFlechaDerPress();
            }
        }
       
       @Override
       public void mouseExited(MouseEvent e) {
           if(e.getSource() == btnFlechaIzq){
               btnFlechaIzqNPress();
           }
           if(e.getSource() == btnFlechaDer){
               btnFlechaDerNPress();
            } 
        }
       
       @Override
       public void mousePressed(MouseEvent e){
           if(e.getSource() == btnFlechaIzq){
               if (e.getButton() == 1){
                    btnFlechaIzqNPress();
               }else{
                    e.consume();
               }
           }
           if(e.getSource() == btnFlechaDer ){
               if (e.getButton() == 1){
                   btnFlechaDerNPress();
                }else{
                   e.consume();
                } 
           }
       }
       
       @Override
       public void mouseReleased(MouseEvent e){
           if(e.getSource() == btnFlechaIzq){
               if (e.getButton() == 1){
                   btnFlechaIzqNPress();
               }else{
                   e.consume();
               }
           }
           
           if(e.getSource() == btnFlechaDer ){
               if (e.getButton() == 1){
                    btnFlechaDerPress();
               }else{
                   e.consume();
               }
           }
        }
       
       @Override
       public void mouseClicked(MouseEvent e){
           if (e.getSource() == btnFlechaDer && e.getButton() == 1 ){
               if(paginaAct < 5){
                   paginaAct += 1;
                   cargarInfo();
                   btnFlechaIzq.setEnabled(true);
                   btnFlechaIzq.setVisible(true);
                   System.out.print(paginaAct);
               
               }
               if(paginaAct == 5){
                   cargarInfo();
                   btnFlechaDer.setEnabled(false);
               }
           } else {
               e.consume();
           }
           if (e.getSource() == btnFlechaIzq && e.getButton() == 1 ){
               if(paginaAct > 1){
                   paginaAct -= 1;
                   cargarInfo();
                   btnFlechaDer.setEnabled(true);
                   btnFlechaDer.setVisible(true);
                   System.out.print(paginaAct);
               }
               if(paginaAct == 1){
                   cargarInfo();
                   btnFlechaIzq.setEnabled(false);
                   btnFlechaIzq.setVisible(false);
                   System.out.print(paginaAct);
               }
            } else {
               e.consume();
           }
       }
   }

   public void btnFlechaIzqPress(){
       ImageIcon flechaIzqPress = new ImageIcon("flechaIzqPress.png");
       btnFlechaIzq.setIcon(new ImageIcon(flechaIzqPress.getImage().getScaledInstance(btnFlechaIzq.getWidth(), btnFlechaIzq.getHeight(), Image.SCALE_SMOOTH)));
   }
   
   public void btnFlechaDerPress(){
       ImageIcon flechaDerPress = new ImageIcon("flechaDerPress.png");
       btnFlechaDer.setIcon(new ImageIcon(flechaDerPress.getImage().getScaledInstance(btnFlechaDer.getWidth(), btnFlechaDer.getHeight(), Image.SCALE_SMOOTH)));
   } 
   
   public void btnFlechaIzqNPress(){
       ImageIcon flechaIzqNPress = new ImageIcon("flechaIzq.png");
       btnFlechaIzq.setIcon(new ImageIcon(flechaIzqNPress.getImage().getScaledInstance(btnFlechaIzq.getWidth(), btnFlechaIzq.getHeight(), Image.SCALE_SMOOTH)));
   }
   
   public void btnFlechaDerNPress(){
       ImageIcon flechaDerNPress = new ImageIcon("flechaDer.png");
       btnFlechaDer.setIcon(new ImageIcon(flechaDerNPress.getImage().getScaledInstance(btnFlechaDer.getWidth(), btnFlechaDer.getHeight(), Image.SCALE_SMOOTH)));
   }
}
