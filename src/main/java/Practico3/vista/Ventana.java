package Practico3.vista;

import javax.swing.*;

public class Ventana extends JFrame {

    private PanelImagen panel;

    private JMenuBar barraMenu = new JMenuBar();
    private JMenu menuItems = new JMenu("Inicio");
    private JMenu menuEdit = new JMenu("Editar");
    private JMenuItem mn = new JMenuItem("Cargar Imagen");
    private JMenuItem itemSalir = new JMenuItem("Salir");
    private JMenuItem itemCuadrado = new JMenuItem("Cuadrado");

    public Ventana(){
        setTitle("Practico 3");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        cargarElementos();
        setVisible(true);
    }
    public void cargarElementos(){
        setJMenuBar(barraMenu);
        barraMenu.add(menuItems);
        barraMenu.add(menuEdit);
        menuItems.add(mn);
        menuItems.add(itemSalir);
        menuEdit.add(itemCuadrado);
        itemSalir.addActionListener(e -> {
            cerrarPrograma();
        });

    }
    public void cerrarPrograma(){
        dispose();
        System.exit(0);
    }

    public static void main(String[] args) {
        Ventana v = new Ventana();
    }
}
