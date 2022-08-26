package Practico2;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Fractal implements IFractal {
    protected int profundidad;

    private PropertyChangeSupport objeto;

    public Fractal(int profundidad){
        objeto = new PropertyChangeSupport(this);
        this.profundidad=profundidad;
    }
    public void addListener(PropertyChangeListener listener){
        objeto.addPropertyChangeListener(listener);
    }
    public void cambia(){
        objeto.firePropertyChange("Fractal",false,true);
    }
    public void dibujar(Graphics g){
        hacerCuadrado(150,150,150,150,this.profundidad, g);
    }
    public void hacerCuadrado(int x, int y,int ancho, int alto, int profundidad, Graphics gr){
        int cAncho=ancho/3;
        int cAlto = alto/3;
        if (profundidad==1){
            gr.drawRect(x,y,ancho,alto);
        }else{
            hacerCuadrado(x,y,ancho,alto,profundidad-1,gr);
            hacerCuadrado(x-cAncho,y+cAlto,cAncho,cAlto,profundidad-1,gr);//1.1
            hacerCuadrado(x+cAncho,y-cAlto,cAncho,cAlto,profundidad-1,gr);//1.2
            hacerCuadrado(x+cAncho*3,y+cAlto,cAncho,cAlto,profundidad-1,gr);//1.3
            hacerCuadrado(x+cAncho,y+cAlto*3,cAncho,cAlto,profundidad-1,gr);//1.4
        }
    }
    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }
}
