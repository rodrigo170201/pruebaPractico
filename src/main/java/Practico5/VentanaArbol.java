package Practico5;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class VentanaArbol extends JFrame {
    private JMenuBar menuInicio = new JMenuBar();
    private JMenu jmArchivo= new JMenu("Archivo");
    private JMenuItem itemNuevo = new JMenuItem("Nuevo");
    private JMenuItem itemSalir = new JMenuItem("Salir");
    private String txtLinkUsuario="";
    private PanelArbol panelPrincipal;
    public VentanaArbol(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        DibujarArbol<String> modelo = inicializarArbol();
        panelPrincipal = new PanelArbol(modelo);
        this.getContentPane().add(panelPrincipal,BorderLayout.CENTER);

        iniciarElementos();
        añadirAccionesDeBotones();


        /*PanelArbol panelPrincipal = new PanelArbol(modelo);
        this.getContentPane().add(panelPrincipal,BorderLayout.CENTER);*/

        this.pack();
        this.setVisible(true);
    }
    public void añadirAccionesDeBotones(){
        itemNuevo.addActionListener(e -> {
            txtLinkUsuario = JOptionPane.showInputDialog("Ingrese el link de la página");
            DibujarArbol<String> modelo1 = inicializarArbol();
            panelPrincipal = new PanelArbol(modelo1);
            this.getContentPane().add(panelPrincipal,BorderLayout.CENTER);
            //listaPaneles.adicionar(panelPrincipal);
            URL objUrl = null;
            try {
                objUrl = new URL(txtLinkUsuario);
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            }
            Scanner sc = null;
            try {
                sc = new Scanner(objUrl.openStream());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            StringBuffer sb = new StringBuffer();
            while (sc.hasNext()){
                sb.append(sc.next());
            }
            String resultado = sb.toString();
            System.out.println("Links de las paginas:");
            System.out.println(resultado);
            //String validarPagina="^http[s]?:\/\/[a-z]+([\.]+[a-z]+)+$";
            validarhttp(resultado);
            panelPrincipal.updateUI();

        });
        itemSalir.addActionListener(e -> {
            cerrarPrograma();
        });
    }
    public void validarhttp(String result){
        String conpararHttp = "http://";
        String conpararHttps = "https://";
        int vecesAmbos = 0;
        for (int i =0;i<result.length();i++){
            if (result.substring(i).startsWith(conpararHttp) || result.substring(i).startsWith(conpararHttps)){
                vecesAmbos++;
            }
        }
        System.out.println("Hay "+ vecesAmbos+ " paginas webs");
    }
    public void iniciarElementos(){
        setJMenuBar(menuInicio);
        menuInicio.add(jmArchivo);
        jmArchivo.add(itemNuevo);
        jmArchivo.add(itemSalir);
    }
    public static void main(String[] args) {
        new VentanaArbol();
    }
    private DibujarArbol<String> inicializarArbol(){
        Arbol<String> a = new Arbol<>();
        String[] vector = {"a", "b", "c", "d"};
        a.añadir("a",txtLinkUsuario, null);
        /*a.añadir("b", "b",txtLinkUsuario);
        a.añadir("c", "c",txtLinkUsuario);
        a.añadir("d", "d",txtLinkUsuario);*/
        for (int i= 0; i<vector.length;i++){
            String letra = vector[i];
            a.añadir(letra,letra,txtLinkUsuario);
        }


        DibujarArbol<String> resultado = new DibujarArbol<>(a);
        return resultado;
    }
    public void cerrarPrograma(){
        dispose();
        System.exit(0);
    }
}
