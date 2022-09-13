package Practico3.Modelo;

import Practico3.dibujar.iDibujar;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Texto implements iDibujar {
    private String text;
    private int x;
    private int y;
    private PropertyChangeSupport observar;
    private boolean seleccionado;
    public Texto(String texto, int w, int h, int tamaño){
        text=texto;
        x=w;
        y=h;
        observar=new PropertyChangeSupport(this);
    }
    public void addListener(PropertyChangeListener listener){
        observar.addPropertyChangeListener(listener);
    }
    @Override
    public void dibujar(Graphics g) {
        g.drawString("",x,y);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public PropertyChangeSupport getObservar() {
        return observar;
    }

    public void setObservar(PropertyChangeSupport observar) {
        this.observar = observar;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
    public void moverTextA(int x, int y){
        this.x=x;
        this.y=y;
        observar.firePropertyChange("TEXTO",false,true);
    }
}