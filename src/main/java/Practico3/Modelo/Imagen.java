package Practico3.Modelo;

import Practico3.dibujar.iDibujar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;


public class Imagen implements iDibujar {
    private int ancho;
    private int alto;

    private int [][] pixeles;
    private PropertyChangeSupport observado;
    private static Logger logger = LogManager.getRootLogger();

    public Imagen(int w, int h){
        ancho=w;
        alto=h;
        pixeles=new int[ancho][alto];
        observado = new PropertyChangeSupport(this);
    }
    public Imagen(Imagen img){
        ancho=img.getAncho();
        alto=img.getAlto();

        pixeles=new int[ancho][alto];
        for (int i = 0; i < ancho; i++) {
            for (int j=0;i<alto;j++){
                pixeles[i][j]= img.get(i,j);
            }
        }
        observado=new PropertyChangeSupport(this);
    }
    public int[][] getPixeles(){
        return pixeles;
    }
    public void setPixeles(int[][]nuevos, int w, int h){
        pixeles=nuevos;
        ancho=w;
        alto=h;
        observado.firePropertyChange("IMAGEN",true,false);

    }
    public void cambiosRealizados(){
        observado.firePropertyChange("IMAGEN",true,false);
    }
    public int get(int i, int j){
        return pixeles[i][j];
    }

    public void addListener(PropertyChangeListener listener){
        observado.addPropertyChangeListener(listener);
    }
    public void setColor(int x, int y, int r, int g, int b){
        pixeles[x][y]=b | (g<<8) | (r<<16);
    }


    @Override
    public void dibujar(Graphics g) {
        for (int i = 0;i<ancho;i++){
            for (int j = 0; j < alto; j++) {
                g.setColor(new Color(pixeles[i][j]));
                g.drawLine(i,j,i,j);
            }
        }
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
    public void cargarImagen(File archivoConImagen){
        BufferedImage bi = null;
        try {
            bi= ImageIO.read(archivoConImagen);

        }catch (Exception e){
            logger.error("No se puede cargar la imagen", e);
            return;
        }
        ancho = bi.getWidth();
        alto = bi.getWidth();

        pixeles=new int[ancho][alto];
        for (int j=0;j<alto;j++){
            for (int i=0;i<ancho;i++){
                int bgr =bi.getRGB(i,j);
                pixeles[i][j]=bgr;
            }
        }
        observado.firePropertyChange("IMAGEN",true,false);
    }
}
