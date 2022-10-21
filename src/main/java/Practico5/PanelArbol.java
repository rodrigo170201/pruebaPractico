package Practico5;

import javax.swing.*;
import java.awt.*;

public class PanelArbol extends JPanel {
    private DibujarArbol<String> modelo;
    public PanelArbol(DibujarArbol<String> src){
        modelo=src;
        updateUI();
    }
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(500,500);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        modelo.dibujar(0,0,g);
    }
}
