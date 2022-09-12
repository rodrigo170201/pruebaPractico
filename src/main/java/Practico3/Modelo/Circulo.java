package Practico3.Modelo;

import Practico3.dibujar.iDibujar;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Circulo implements iDibujar {
    private int x;
    private int y;
    private int tamaño;
    private PropertyChangeSupport observar;
    private boolean seleccionado;

    public Circulo(int w, int h, int t){
        x=w;
        y=h;
        tamaño=t;
        observar=new PropertyChangeSupport(this);
    }
    public void addListener(PropertyChangeListener listener){
        observar.addPropertyChangeListener(listener);
    }


    @Override
    public void dibujar(Graphics g) {
        g.fillOval(x,y,tamaño,tamaño);
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

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
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
    public void moverCirA(int x, int y){
        this.x=x;
        this.y=y;
        observar.firePropertyChange("CIRCULO",false,true);
    }

}
