package Practico3.vista;

import Practico3.Modelo.Circulo;
import Practico3.Modelo.Cuadrado;
import Practico3.Modelo.Escena;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanelImagen extends JPanel implements PropertyChangeListener, MouseListener, MouseMotionListener {

    private Escena modelo;

    public PanelImagen(Escena escena){
        modelo=escena;
        modelo.addListener(this);
        modelo.addListenerCirculo(this);
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
        modelo.seleccionarObjeto(e.getX(),e.getY());
        modelo.seleccionarCirculo(e.getX(),e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        modelo.soltarCuadrado();
        modelo.soltarCirculo();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Cuadrado m = modelo.getObjetoSeleccionado();
        if (m != null){
            m.moverA(e.getX(), e.getY());
        }
        Circulo cir = modelo.getCirculoSelccionado();
        if (cir!=null){
            cir.moverCirA(e.getX(),e.getY());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
