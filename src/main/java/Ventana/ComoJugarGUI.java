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

       
       cargarInfo();
       
       //TITULO
       ImageIcon titulo = new ImageIcon("ComoJugar.png");
       lblTitulo.setIcon(new ImageIcon(titulo.getImage().getScaledInstance(lblTitulo.getWidth(), lblTitulo.getHeight(), Image.SCALE_SMOOTH)));
       lblTitulo.setBounds(185, 0, 500, 120);
       
       //AREA DE TEXTO
       txtAInfo.setBounds(40, 300, 770, 140);

       //BOTON VOLVER
       btnVolver.setBounds(345, 450, 140, 50);
   }
   
    public void cargarInfo1(){
        
       txtAInfo.setText(" ");
       txtAInfo.append("\n   En MEMORABBLE, al iniciar el juego, aparecerán una serie de figuras de distintos \n");
       txtAInfo.append("   colores sobre una serie de fichas en pantalla.  Al cabo de unos segundos,\n");
       txtAInfo.append("   las figuras mostradas desaparecerán y el jugador tendra que responder al\n");
       txtAInfo.append("   requerimiento sobre las fichas y color que se solicite.\n");
       
       ImageIcon imagen = new ImageIcon("rombo.png");
       lblImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH)));

   }
    
    public void cargarInfo2(){
       txtAInfo.setText(" ");
       txtAInfo.append("\n   El requerimiento se mostrará en la parte derecha de la pantalla, cuando las figuras\n");
       txtAInfo.append("   en las fichas hayan desaparecido, el jugador deberá de pulsar sobre la ficha que\n");
       txtAInfo.append("   recuerde que cumpla con el requerimiento indicado en pantalla.\n");
       
       ImageIcon imagen= new ImageIcon("estrella.png");
       lblImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH)));
   }
    
    public void cargarInfo3(){
       txtAInfo.setText(" ");
       txtAInfo.append("\n   ¡¡ OJO !! Puede haber más de una ficha que cumpla el requerimiento indicado.\n");
       txtAInfo.append("\n   Deberá de pulsar sobre todas las fichas que lo cumplan.\n");

       ImageIcon imagen = new ImageIcon("cruz.png");
       lblImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH)));
  
   }
    
    public void cargarInfo4(){
       txtAInfo.setText(" ");
       txtAInfo.append("\n   En el ejemplo propuesto arriba, se pide pulsar sobre las fichas que contengan \n");
       txtAInfo.append("   figuras\n");
       
       ImageIcon imagen= new ImageIcon("rayo.png");
       lblImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH)));
  
   }
    
    public void cargarInfo5(){
       txtAInfo.setText(" ");
       txtAInfo.append("\n   Es importante que el jugador memorice tanto las formas, los colores y las\n");
       txtAInfo.append("   posiciones de cada una de las fichas.\n");
       txtAInfo.append("\n                  ¡¡APROVECHA CADA SEGUNDO Y HAZ ALGO MEMORABBLE!!\n");
       
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
               }
               if(paginaAct == 1){
                   cargarInfo();
                   btnFlechaIzq.setEnabled(false);
                   btnFlechaIzq.setVisible(false);
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
