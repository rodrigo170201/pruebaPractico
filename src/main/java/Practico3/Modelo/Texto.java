package Practico3.Modelo;

import Practico3.dibujar.iDibujar;

import java.awt.*;
import java.beans.PropertyChangeSupport;

public class Texto implements iDibujar {
    private String text;
    private int x;
    private int y;
    private PropertyChangeSupport observar;
    private boolean seleccionado;
    public Texto(String texto, int w, int h){
        text=texto;
        x=w;
        y=h;
    }
    @Override
    public void dibujar(Graphics g) {
        g.drawString("",x,y);
    }
}
