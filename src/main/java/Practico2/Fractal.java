package Practico2;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Fractal implements IFractal {
    private int x;
    private int y;
    private int tamaño;
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
        objeto.firePropertyChange("FRACTAL",false,true);
    }
    public void dibujar(Graphics g){
        hacerCuadrado(10,10,300,300,this.profundidad, g);
    }
    public void hacerCuadrado(int x, int y,int ancho, int alto, int profundidad, Graphics gr){
        int cAncho=ancho/3;
        int cAlto = alto/3;
        if (profundidad==1){
            gr.drawRect(100,100,tamaño,tamaño);
            gr.setColor(Color.black);
        }else{
            hacerCuadrado(x,y,ancho,alto,profundidad-1,gr);
            hacerCuadrado(x-cAncho/2,y+cAlto,cAncho,cAlto,profundidad-1,gr);//1.1
            hacerCuadrado(x+cAncho,y-cAlto/2,cAncho,cAlto,profundidad-1,gr);//1.2
            hacerCuadrado(x+(cAncho*5)/2,y+cAlto,cAncho,cAlto,profundidad-1,gr);//1.3
            hacerCuadrado(x+cAncho,y+(cAlto*5)/2,cAncho,cAlto,profundidad-1,gr);//1.4
        }
    }
    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }
}
