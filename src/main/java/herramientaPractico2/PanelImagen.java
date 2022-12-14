package herramientaPractico2;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PanelImagen extends JPanel {
    private Imagen modelo;
     public PanelImagen(Imagen img){
         modelo = img;
     }
     @Override
     public Dimension getPreferredSize(){
         return new Dimension(modelo.getAncho(),modelo.getAlto());
     }

     @Override
     protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if (modelo==null)
            return;
         BufferedImage rsm = new BufferedImage(modelo.getAncho(), modelo.getAlto(), BufferedImage.TYPE_INT_ARGB);
         Graphics2D g2d = rsm.createGraphics();
         modelo.dibujar(g2d);
         g.drawImage(rsm,0,0,null);
     }
}
