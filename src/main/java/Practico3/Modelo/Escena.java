package Practico3.Modelo;

import Practico3.dibujar.iDibujar;
import Practico3.vista.PanelImagen;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Escena implements iDibujar {
    private Imagen imagen;
    private ArrayList<Cuadrado> objCuadrados;
    private PropertyChangeSupport observado;
    public Escena(){
        imagen = new Imagen(400,400);
        objCuadrados = new ArrayList<>();
        observado = new PropertyChangeSupport(this);
    }


    @Override
    public void dibujar(Graphics g) {
        if (imagen != null){
            BufferedImage rs = new BufferedImage(imagen.getAncho(),imagen.getAlto(),BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = rs.createGraphics();
            imagen.dibujar(g2d);
            g.drawImage(rs,0,0,null);
        }
        for (Cuadrado c : objCuadrados){
            c.dibujar(g);
        }
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public void addCuadrado(Cuadrado c){
        objCuadrados.add(c);
        observado.firePropertyChange("ESCENA",true ,false);
    }
    public void addListener(PanelImagen panelImagen){
        observado.addPropertyChangeListener(panelImagen);
        this.imagen.addListener(panelImagen);
        for (Cuadrado c:objCuadrados){
            c.addListener(panelImagen);
        }
    }
    public Cuadrado getObjetoSeleccionado(){
        for (Cuadrado c : objCuadrados){
            if (c.isSeleccionado())return c;
        }
        return null;
    }
    public void soltarObjeto(){
        for (Cuadrado c:objCuadrados){
            c.setSeleccionado(false);
        }
    }
    public void seleccionarObjeto(int x,int y){
        for (Cuadrado c:objCuadrados){
            if (x>c.getX() && x <(c.getX()+c.getTamaño()) && y>c.getY()&& y <(c.getY()+c.getTamaño())){
                c.setSeleccionado(true);
            }
        }
    }

}
