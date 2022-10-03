package Practico4.Vista;

import Practico3.Modelo.Circulo;
import Practico3.Modelo.Cuadrado;
import Practico4.Modelo.Escena;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanelContenedor extends JPanel implements PropertyChangeListener, MouseListener, MouseMotionListener {
    private Escena modelo;
    private int x;
    private int y;
    private int ancho;
    private int alto;
    private Color fondo;
    public PanelContenedor (int x, int y, int w, int h, Color co){
        this.x=x;
        this.y=y;
        ancho=w;
        alto=h;
        fondo=co;
        setBounds(x,y,ancho,alto);
        setBackground(co);
    }
    public PanelContenedor(Escena escena){
        modelo=escena;
        modelo.addListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(modelo.getImagen().getAncho(),modelo.getImagen().getAlto());
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if (modelo==null)
            return;
        modelo.dibujar(g);
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
