package Practico2;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanelImagen extends JPanel implements PropertyChangeListener {
    private int alto=600;
    private int ancho=600;
    private Fractal objeto;
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
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.repaint();
    }
}
