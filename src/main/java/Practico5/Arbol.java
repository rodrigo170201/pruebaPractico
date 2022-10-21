package Practico5;



//import Practico4.Listas.Lista;

public class Arbol<E> {
    private Nodo<E> raiz;

    public Arbol() {
        raiz = null;
    }
    public void añadir(E o, String id, String idpadre){
        Nodo<E> nuevo = new Nodo<>(id,o);
        if (idpadre==null){
            raiz=nuevo;
            return;
        }
        Nodo<E> padre = raiz.buscar(idpadre);
        if (idpadre==null){
            return;
        }
        padre.añadirHijo(nuevo);
    }

    @Override
    public String toString(){
        if (raiz== null)
            return "[VACIO]";
        return raiz.toString();
    }
    public Nodo<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<E> raiz) {
        this.raiz = raiz;
    }

    public void resetVisita(){
        Nodo<E> actual = raiz;
        resetVisita(actual);
    }
    private void resetVisita(Nodo<E> actual){
        actual.resetVisita();
        for (Nodo<E> hijo:actual.getHijos()){
            resetVisita(hijo);
        }
    }
    /*public String bfs(){
        StringBuilder result = new StringBuilder();
        String separador="";
        Cola<Nodo<E>> visita = new Cola<>();
        visita.push(raiz);
        while (visita.getTamaño()>0){
            Nodo<E> aVisitar = visita.pull();
            aVisitar.visitar();
            result.append(separador).append(aVisitar.getIdentificador());
            separador = ",";

            Lista<Nodo<E>> nodosAMeterEnLaLista =
                    aVisitar.getHijosVisitadosYNoEnLista(visita);

            for (Nodo<E> hijo:nodosAMeterEnLaLista){
                visita.push(hijo);
            }

        }
        return result.toString();
    }*/

    /*public String dfs(){
        StringBuilder result = new StringBuilder();
        String separador = "";
        Pila<Nodo<E>> visita = new Pila<>();
        visita.push(raiz);

        while(visita.getTamaño() > 0) {
            Nodo<E> aVisitar = visita.pop();
            aVisitar.visitar();
            result.append(separador).append(aVisitar.getIdentificador());
            separador = ",";

            Lista<Nodo<E>> nodosAMeterEnLista =
                    aVisitar.getHijosVisitadosYNoEnLista(visita);

            for (Nodo<E> hijo:
                    nodosAMeterEnLista) {
                visita.push(hijo);
            }
        }

        return result.toString();
    }*/


    public static class Nodo<E>{
        private E contenido;
        private String identificador;
        private Lista<Nodo<E>> hijos;
        private Nodo<E> padre;
        private int visitado;

        public Nodo(String id, E o) {
            identificador = id;
            contenido=o;
            hijos = new Lista<>();
            padre = null;
            visitado=0;
        }
        public int getVisitado() {
            return visitado;
        }
        public void visitar(){
            this.visitado+=1;
        }

        public void resetVisita() {
            this.visitado = 0;
        }
        public E getContenido() {
            return contenido;
        }

        public void setContenido(E contenido) {
            this.contenido = contenido;
        }

        public String getIdentificador() {
            return identificador;
        }

        public void setIdentificador(String identificador) {
            this.identificador = identificador;
        }

        public Lista<Nodo<E>> getHijos() {
            return hijos;
        }

        public void setHijos(Lista<Nodo<E>> hijos) {
            this.hijos = hijos;
        }

        public Nodo<E> getPadre() {
            return padre;
        }

        public void setPadre(Nodo<E> padre) {
            this.padre = padre;
        }


        public void setVisitado(int visitado) {
            this.visitado = visitado;
        }
        public void añadirHijo(Nodo<E> nuevo){
            nuevo.setPadre(this);
            this.hijos.adicionar(nuevo);
        }
        public Nodo<E> buscar(String idpadre){
            if (this.identificador.equals(idpadre)){
                return this;
            }
            for (Nodo<E> hijo: hijos){
                Nodo<E> encontrado = hijo.buscar(idpadre);
                if (encontrado!=null)
                    return encontrado;
            }
            return null;
        }
        @Override
        public String toString(){
            StringBuilder resultado = new StringBuilder();
            resultado.append(identificador);
            if (hijos.getTamaño()==0)
                return resultado.toString();
            resultado.append("->(");
            String conector = "";
            for (Nodo<E> hijo:hijos){
                resultado.append(conector).append(hijo.toString());
                conector=",";
            }
            resultado.append(")");
            return resultado.toString();
        }

        public Lista<Nodo<E>> getHijosVisitadosYNoEnLista (Lista<Nodo<E>> visita){
            Lista<Nodo<E>> result = new Lista<>();
            for (Nodo<E> hijo:
                    hijos) {
                boolean enLista = false;
                for (Nodo<E> nodo:
                        visita) {
                    if (hijo.getIdentificador().equals(nodo.getIdentificador())) {
                        enLista = true;
                        break;
                    }
                }
                if (hijo.getVisitado() == 0 && !enLista) {
                    result.insertar(hijo);
                }
            }
            return result;
        }
    }
}
