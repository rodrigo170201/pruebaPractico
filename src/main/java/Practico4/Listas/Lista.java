package Practico4.Listas;

import Practico2.IFractal;
import Practico4.Modelo.Escena;

import javax.swing.*;
import java.util.Iterator;

public class Lista<E> implements Iterable<E>{
    protected Nodo<E> raiz;
    protected int tamaño;
    public Lista(){
        raiz=null;
        tamaño=0;
    }

    public Nodo<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<E> raiz) {
        this.raiz = raiz;
    }
    public void insertar(E o){
        Nodo<E> nuevo = new Nodo(o);
        nuevo.setSiguiente(this.raiz);
        raiz=nuevo;
        tamaño++;
    }
    public void adicionar(E o){
        if (tamaño==0){
            insertar(o);
            return;
        }
        Nodo<E> nuevo = new Nodo(o);
        Nodo<E> actual = raiz;
        while (actual.getSiguiente()!= null){
            actual=actual.getSiguiente();
        }
        actual.setSiguiente(nuevo);
        tamaño++;
    }
    /*public Lista mostrarLista(Escena escena){
        Lista<Escena> laLista=null;
        JLabel nombre;
        if (raiz==null){
            return null;
        }else {
            for (Escena e:laLista){
                e.getImagen();
                e.se
            }
        }
        return laLista;
    }*/
    public void eliminar(int pos){
        if (pos==0){
            raiz = raiz.getSiguiente();
            tamaño--;
            return;
        }
        int i=0;
        Nodo<E> actual = raiz;
        while (i<pos-1){
            actual = actual.getSiguiente();
            i++;
        }
        actual.setSiguiente(actual.getSiguiente().getSiguiente());
        tamaño--;
    }
    @Override
    public String toString(){
        if (raiz==null){
            return "Vacia";
        }
        StringBuilder resultado = new StringBuilder();
        Nodo<E> actual = raiz;
        String conector="";
        while (actual!=null){
            resultado.append(conector).append(actual.getContenido());
            conector=" -> ";
            actual=actual.getSiguiente();
        }
        return resultado.toString();
    }

    public int getTamaño() {
        return tamaño;
    }
    public E get(int i){
        if (i==0)
            return  raiz.getContenido();
        Nodo<E> actual = raiz;
        int posActual=0;
        while (posActual<i){
            posActual++;
            actual=actual.getSiguiente();
        }
        return actual.getContenido();
    }
    @Override
    public Iterator<E> iterator() {
        return new IteradorLista<>(raiz);
    }
    class Nodo<E>{
        private E contenido;
        private Nodo<E> siguiente;

        public Nodo(E o){
            this.contenido=o;
            this.siguiente=null;
        }

        public E getContenido() {
            return contenido;
        }

        public void setContenido(E contenido) {
            this.contenido = contenido;
        }

        public Nodo<E> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<E> siguiente) {
            this.siguiente = siguiente;
        }
    }
    class IteradorLista<E> implements Iterator<E>{
        private Nodo<E> siguiente;

        public IteradorLista(Nodo<E> actual){
            this.siguiente=actual;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }
}
