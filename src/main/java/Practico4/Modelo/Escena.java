package Practico4.Modelo;

import Practico3.vista.PanelImagen;
import Practico4.Dibujar.iDibujar;
import Practico4.Listas.Lista;
import Practico4.Vista.PanelContenedor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class Escena implements iDibujar {
    private Imagen imagen;
    private Lista<Cuadrado> objCuadrados;
    private Lista<Circulo> objCirculos;
    private PropertyChangeSupport observado;
    public Escena(){
        imagen = new Imagen(500,620);
        objCuadrados=new Lista<>();
        objCirculos=new Lista<>();
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
    public void addListenerCirculo(PanelContenedor panelContenedor){
        observado.addPropertyChangeListener(panelContenedor);
        this.imagen.addListener(panelContenedor);
        for (Circulo cir : objCirculos){
            cir.addListener(panelContenedor);
        }
    }
    public void addCuadrado(Cuadrado c){
        objCuadrados.insertar(c);
        observado.firePropertyChange("ESCENA CUADRADO",true,false);
    }
    public void addCirculo(Circulo cir){
        objCirculos.insertar(cir);
        observado.firePropertyChange("ESCENA CIRCULO",true,false);
    }
    public Cuadrado getObjetoSeleccionado(){
        for (Cuadrado c :objCuadrados){
            if (c.isSeleccionado())return c;
        }
        return null;
    }
    public void soltarCuadrado(){
        for (Cuadrado c:objCuadrados){
            c.setSeleccionado(false);
        }
    }
    public void soltarCirculo(){
        for (Circulo c:objCirculos){
            c.setSeleccionado(false);
        }
    }
    public void seleccionarCuadrado(int x,int y){
        for (Cuadrado c:objCuadrados){
            if (x>c.getX()&& x <(c.getX()+c.getTamaño())&& y>c.getY()&& y<(c.getY()+c.getTamaño())){
                c.setSeleccionado(true);
            }
        }
    }
    public void seleccionarCirculo(int x, int y){
        for (Circulo cir : objCirculos){
            if (x>cir.getX()&&x<(cir.getX()+cir.getTamaño())&& y>cir.getY()&& y<(cir.getY()+cir.getTamaño())){
                cir.setSeleccionado(true);
            }
        }
    }


}
