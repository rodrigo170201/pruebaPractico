package Practico4.Modelo;

import Practico4.Dibujar.iDibujar;
import Practico4.Listas.Lista;
import Practico4.Vista.PanelContenedor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeSupport;

public class Escena implements iDibujar {
    private Imagen imagen;
    private Lista<Cuadrado> objCuadrados;
    private PropertyChangeSupport observado;
    public Escena(){
        imagen = new Imagen(500,620);
        objCuadrados=new Lista<>();
        observado=new PropertyChangeSupport(this);
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    @Override
    public void dibujar(Graphics g) {
        if (imagen != null){
            BufferedImage rs = new BufferedImage(imagen.getAncho(), imagen.getAlto(),BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = rs.createGraphics();
            imagen.dibujar(g2d);
            g.drawImage(rs,260,10,null);
        }
        for (Cuadrado c:objCuadrados){
            c.dibujar(g);
        }
    }
    public void addListener(PanelContenedor panelContenedor){
        observado.addPropertyChangeListener(panelContenedor);
        this.imagen.addListener(panelContenedor);
        for (Cuadrado c:objCuadrados){
            c.addListener(panelContenedor);
        }
    }
    public void addCuadrado(Cuadrado c){
        objCuadrados.insertar(c);
        observado.firePropertyChange("ESCENA CUADRADO",true,false);
    }

}
