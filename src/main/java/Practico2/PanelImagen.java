package Practico2;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanelImagen extends JPanel implements PropertyChangeListener {
    private int alto;
    private int ancho;
    public PanelImagen(){

    }
    public PanelImagen(int alto, int ancho){
        this.alto=alto;
        this.ancho=ancho;
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
}
