package Practico2;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanelImagen extends JPanel implements PropertyChangeListener {
    private int alto=500;
    private int ancho=500;
    private Fractal objeto;
    /*public PanelImagen(){
        setLayout(null);
        setSize(500,500);
        setBackground(Color.white);
    }*/
    public PanelImagen(Fractal obj){
        setLayout(null);
        objeto = obj;
        objeto.addListener(this);
        setPreferredSize(new Dimension(ancho,alto));
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (objeto!=null){
            objeto.dibujar(g);
        }
        /*g.drawRect(180,180,100,100);
        g.setColor(Color.black);*/
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.repaint();
    }
}
