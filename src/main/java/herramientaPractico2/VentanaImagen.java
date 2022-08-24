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
        modelo = new Imagen(500,500);
        dibujarCuadrado();
    }

    public static void main(String[] args) {
        VentanaImagen v = new VentanaImagen();
    }
     public void dibujarCuadrado(){
         int totalLinea=0;
         int mitadInicio=0;

         for (int i=180; i< modelo.getAncho()-180; i++){
             modelo.setColor(i,180,255,255,255);
             totalLinea +=i;
             if (i==mitadInicio){
                 dibujarCuadrado();
             }
         }
         mitadInicio=totalLinea/3;

         System.out.println("El tamaño es: "+ mitadInicio);
         for (int i=180;i<modelo.getAncho()-180;i++){
             modelo.setColor(i, modelo.getAlto()-180, 255,255,255);
         }
         for (int j=180;j< modelo.getAlto()-180;j++){
             modelo.setColor(180,j,255,255,255);
         }
         for (int j=180;j< modelo.getAlto()-180;j++){
             modelo.setColor(modelo.getAncho()-180,j,255,255,255);
         }
     }
}
