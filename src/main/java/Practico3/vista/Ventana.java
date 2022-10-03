package Practico3.vista;

import Practico3.Modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Ventana extends JFrame {
    private Escena modelo;
    private PanelImagen panel;


    private JMenuBar barraMenu = new JMenuBar();
    private JMenu menuItems = new JMenu("Inicio");
    private JMenu menuEdit = new JMenu("Editar");
    private JMenuItem mn = new JMenuItem("Cargar Imagen");
    private JMenuItem itemSalir = new JMenuItem("Salir");
    private JMenuItem itemCuadrado = new JMenuItem("Cuadrado");
    private JMenuItem itemCirculo = new JMenuItem("Circulo");
    private JMenuItem itemTexto = new JMenuItem("Texto");
    private JMenuItem itemLinea = new JMenuItem("Linea");

    public Ventana(){
        setLayout(null);
        setTitle("Practico 3");
        setSize(800,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        iniciarImagen();

        cargarElementos();


        panel = new PanelImagen(modelo);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel,BorderLayout.CENTER);

        this.pack();
        setVisible(true);
    }
    public void cargarElementos(){
        setJMenuBar(barraMenu);
        //barras
        barraMenu.add(menuItems);
        barraMenu.add(menuEdit);
        //items
        menuItems.add(mn);
        menuItems.add(itemSalir);
        menuEdit.add(itemCuadrado);
        menuEdit.add(itemCirculo);
        menuEdit.add(itemTexto);
        menuEdit.add(itemLinea);
        mn.addActionListener(e -> {
           archivoAbrir();
        });
        itemSalir.addActionListener(e -> {
            cerrarPrograma();
        });
        itemCuadrado.addActionListener(e -> {
            objetosCuadrados();
        });
        itemCirculo.addActionListener(e -> {
            objetosCirculos();
        });
        itemTexto.addActionListener(e -> {
            String txtTexto = JOptionPane.showInputDialog("Ingrese su texto");
            Texto tx = new Texto(txtTexto,200,200,txtTexto.length());
            tx.addListener(panel);
            modelo.addTexto(tx);
        });
        itemLinea.addActionListener(e -> {
            objetosLineas();
        });

    }
    private void objetosCuadrados(){
        Cuadrado c = new Cuadrado(50,50,100);
        c.addListener(panel);
        modelo.addCuadrado(c);
    }
    private void objetosCirculos(){
        Circulo cir = new Circulo(100,100,100);
        cir.addListener(panel);
        modelo.addCirculo(cir);
    }
    private void objetosLineas(){
        Linea l = new Linea(150,150,100);
        l.addListener(panel);
        modelo.addLinea(l);
    }

    private void archivoAbrir(){
        String direccion = "C:\\Users\\pc\\IdeaProjects";
        JFileChooser inputFile = new JFileChooser();
        if (!direccion.equals(""))
            inputFile.setCurrentDirectory(new File(direccion));
        inputFile.showOpenDialog(this);
        if (inputFile.getSelectedFile()==null){
            JOptionPane.showMessageDialog(this,"Escoge una imagen");
            return;
        }

        File archivoConImagen = inputFile.getSelectedFile();
        modelo.getImagen().cargarImagen(archivoConImagen);
    }
    private void iniciarImagen(){
        modelo=new Escena();
        for (int i=0;i<300;i++){
            modelo.getImagen().setColor(i,100,0,0,0);
        }
    }
    public void cerrarPrograma(){
        dispose();
        System.exit(0);
    }
    public static void main(String[] args) {
        Ventana v = new Ventana();
    }
}
