package Practico3.Modelo;

import Practico3.dibujar.iDibujar;
import Practico3.vista.PanelImagen;


import javax.sound.sampled.Line;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Escena implements iDibujar {
    private Imagen imagen;
    private ArrayList<Cuadrado> objCuadrados;
    private ArrayList<Circulo> objCirculos;
    private ArrayList<Texto> objTextos;
    private ArrayList<Linea> objLineas;
    private PropertyChangeSupport observado;
    public Escena(){
        imagen = new Imagen(400,400);
        objCuadrados = new ArrayList<>();
        objCirculos = new ArrayList<>();
        objTextos = new ArrayList<>();
        objLineas = new ArrayList<>();
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
        for (Circulo cir : objCirculos){
            cir.dibujar(g);
        }
        for (Texto t :objTextos){
            t.dibujar(g);
        }
        for (Linea l :objLineas){
            l.dibujar(g);
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
    public void addCirculo(Circulo cir){
        objCirculos.add(cir);
        observado.firePropertyChange("ESCENA CIRCULO",true,false);
    }
    public void addTexto(Texto t){
        objTextos.add(t);
        observado.firePropertyChange("TEXTO",true,false);
    }
    public void addLinea(Linea l){
        objLineas.add(l);
        observado.firePropertyChange("LINEA",false,true);
    }
    public void addListener(PanelImagen panelImagen){
        observado.addPropertyChangeListener(panelImagen);
        this.imagen.addListener(panelImagen);
        for (Cuadrado c:objCuadrados){
            c.addListener(panelImagen);
        }
    }
    public void addListenerCirculo(PanelImagen panelImagen){
        observado.addPropertyChangeListener(panelImagen);
        this.imagen.addListener(panelImagen);
        for (Circulo cir : objCirculos){
            cir.addListener(panelImagen);
        }
    }
    public void addListenerTexto(PanelImagen panelImagen){
        observado.addPropertyChangeListener(panelImagen);
        this.imagen.addListener(panelImagen);
        for (Texto t : objTextos){
            t.addListener(panelImagen);
        }
    }
    public void addListenerLineas(PanelImagen panelImagen){
        observado.addPropertyChangeListener(panelImagen);
        this.imagen.addListener(panelImagen);
        for (Linea l : objLineas){
            l.addListener(panelImagen);
        }
    }
    public Cuadrado getObjetoSeleccionado(){
        for (Cuadrado c : objCuadrados){
            if (c.isSeleccionado())return c;
        }
        return null;
    }
    public Circulo getCirculoSelccionado(){
        for (Circulo cir : objCirculos){
            if (cir.isSeleccionado())return cir;
        }
        return null;
    }
    public Linea getLineaSeleccionada(){
        for (Linea l : objLineas){
            if (l.isSeleccionado())return l;
        }
        return null;
    }
    public Texto getTextoSeleccionado(){
        for (Texto t : objTextos){
            if (t.isSeleccionado())return t;
        }
        return null;
    }
    public void soltarCuadrado(){
        for (Cuadrado c:objCuadrados){
            c.setSeleccionado(false);
        }
    }
    public void soltarCirculo(){
        for (Circulo cir:objCirculos){
            cir.setSeleccionado(false);
        }
    }
    private void soltarLinea(){
        for (Linea l : objLineas){
            l.setSeleccionado(false);
        }
    }
    public void seleccionarObjeto(int x,int y){
        for (Cuadrado c:objCuadrados){
            if (x>c.getX() && x <(c.getX()+c.getTamaño()) && y>c.getY()&& y <(c.getY()+c.getTamaño())){
                c.setSeleccionado(true);
            }
        }
    }
    public void seleccionarCirculo(int x, int y){
        for (Circulo cir : objCirculos){
            if (x>cir.getX()&& x<(cir.getX()+cir.getTamaño()) && y>cir.getY()&& y <(cir.getY()+cir.getTamaño())){
                cir.setSeleccionado(true);
            }
        }
    }
    public void seleccionarTexto(int x, int y){
        for (Texto t : objTextos){
            if (x>t.getX()&& x<(t.getX())&& y>t.getY()&&y<(t.getY()));
                t.setSeleccionado(true);
        }
    }
    public void seleccionarLinea(int x, int y){
        for (Linea l : objLineas){
            if (x>l.getX()&& x <(l.getX()+l.getTamaño()) && y>l.getY()&& y <(l.getY()+l.getTamaño())){
                l.setSeleccionado(true);
            }
        }
    }

}
