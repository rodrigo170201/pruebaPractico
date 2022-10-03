package Practico4.Modelo;

import Practico4.Dibujar.iDibujar;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Cuadrado implements iDibujar {
    private int x;
    private int y;
    private int tamaño;
    private PropertyChangeSupport observar;
    private boolean seleccionado;
    public Cuadrado(int m, int n, int t){
        x=m;
        y=n;
        tamaño=t;
        observar=new PropertyChangeSupport(this);
    }
    public void addListener(PropertyChangeListener listener){
        observar.addPropertyChangeListener(listener);
    }
    @Override
    public void dibujar(Graphics g) {
        g.fillRect(x,y,tamaño,tamaño);
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

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
    public void moverCuadradoA(int x, int y){
        this.x=x;
        this.y=y;
        observar.firePropertyChange("CUADRADO",false,true);
    }

}
