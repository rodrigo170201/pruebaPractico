package Practico4.Vista;

import Practico4.Listas.Lista;
import Practico4.Modelo.Circulo;
import Practico4.Modelo.Cuadrado;
import Practico4.Modelo.Escena;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.io.File;

public class Ventana extends JFrame {
    private Escena modelo;
    private Lista<Escena> listaEscenas = new Lista<>();
    //Paneles
    private PanelContenedor panelLista = new PanelContenedor(10,10,220,620, Color.green);
    private PanelContenedor panelDeEscenas;
    private JMenuBar barraMenu = new JMenuBar();
    //
    private JMenu menuInicio = new JMenu("Inicio");
    private JMenu menuEditar = new JMenu("Editar");
    //Items
    private JMenuItem itemNuevo = new JMenuItem("Nuevo");
    private JMenuItem itemSalir = new JMenuItem("Salir");

    private JMenuItem itemCuadrado = new JMenuItem("Cuadrado");
    private JMenuItem itemCirculo = new JMenuItem("Circulo");
    private JMenuItem itemTexto = new JMenuItem("Texto");


    public Ventana (){
        setTitle("Practico 4");
        setSize(800,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        System.out.println(listaEscenas);
        iniciarImagen();
        cargarElementos();


        panelDeEscenas = new PanelContenedor(modelo);
        panelLista = new PanelContenedor(10,10,220,620,listaEscenas,Color.gray);
        add(panelLista);
        //add(panelDeEscenas);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panelDeEscenas,BorderLayout.CENTER);
        setVisible(true);
    }
    public void cargarElementos(){
        setLayout(null);
        setJMenuBar(barraMenu);
        //Barras
        barraMenu.add(menuInicio);
        barraMenu.add(menuEditar);
        //Items inicio
        menuInicio.add(itemNuevo);
        menuInicio.add(itemSalir);
        //Items editar
        menuEditar.add(itemCuadrado);
        menuEditar.add(itemCirculo);
        menuEditar.add(itemTexto);
        //Action listeners
        itemNuevo.addActionListener(e -> {
            archivoAbrir(panelDeEscenas);
        });
        itemSalir.addActionListener(e -> {
            cerrarPrograma();
        });
        itemCuadrado.addActionListener(e -> {
            objetosCuadrados();
        });
        itemCirculo.addActionListener(e -> {
            objetosCirculo();
        });
        itemTexto.addActionListener(e -> {

        });
    }
    private void archivoAbrir(PanelContenedor panelContenedor){
        String direccion ="C:\\Users\\pc\\IdeaProjects";
        JFileChooser inputFile = new JFileChooser();
        if (!direccion.equals(""))
            inputFile.setCurrentDirectory(new File(direccion));
        inputFile.showOpenDialog(this);
        if (inputFile.getSelectedFile()==null){
            JOptionPane.showMessageDialog(this,"Escoga una imagen");
            return;
        }
        File archivoConImagen = inputFile.getSelectedFile();
        modelo.getImagen().cargarImagen(archivoConImagen);
        listaEscenas.insertar(modelo);
            nombresArchivos(archivoConImagen);
    }
    public void nombresArchivos(File nombreArchivo){
        String nombres="";
        nombres=nombreArchivo.getName()+"\n";
        System.out.println(nombres);

    }
    public void cerrarPrograma(){
        dispose();
        System.exit(0);
    }
    public void objetosCuadrados(){
        Cuadrado c = new Cuadrado(50,50,100);
        c.addListener(panelDeEscenas);
        modelo.addCuadrado(c);
    }
    public void objetosCirculo(){
        Circulo cir =new Circulo(100,100,100);
        cir.addListener(panelDeEscenas);
        modelo.addCirculo(cir);
    }
    public void iniciarImagen(){
        modelo=new Escena();
        for (int i=0;i<300;i++){
            modelo.getImagen().setColor(i,100,10,10,10);
        }
    }

    public static void main(String[] args) {
        Ventana v = new Ventana();
    }
}
