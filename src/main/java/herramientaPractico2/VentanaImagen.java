package herramientaPractico2;

import javax.swing.*;
import java.awt.*;

public class VentanaImagen extends JFrame {
    private Imagen modelo;
    public VentanaImagen(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializarImagen();
        PanelImagen panel = new PanelImagen(modelo);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }
    public void inicializarImagen(){
        modelo = new Imagen(700,700);
        dibujarCuadrado();
    }

    public static void main(String[] args) {
        VentanaImagen v = new VentanaImagen();
    }
     public void dibujarCuadrado(){
         for (int i=100; i< modelo.getAncho()-100; i++){
             modelo.setColor(i,100,255,255,255);
         }
         for (int i=100;i<modelo.getAncho()-100;i++){
             modelo.setColor(i, modelo.getAlto()-100, 255,255,255);
         }
         for (int j=100;j< modelo.getAlto()-100;j++){
             modelo.setColor(100,j,255,255,255);
         }
         for (int j=100;j< modelo.getAlto()-100;j++){
             modelo.setColor(modelo.getAncho()-100,j,255,255,255);
         }
     }
}
