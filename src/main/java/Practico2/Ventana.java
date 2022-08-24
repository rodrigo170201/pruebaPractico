package Practico2;

import javax.swing.*;

public class Ventana extends JFrame {
    private JMenuBar barraMenu = new JMenuBar();
    private JMenu menuItems = new JMenu("Inicio");
    private JMenuItem e1 = new JMenuItem("Fractal");
    private  JMenuItem salir = new JMenuItem("Salir");
    public Ventana(){
        super("Fractal");
        setSize(500,500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cargarElementos();
        //pack();
        setVisible(true);
    }
    private void cargarElementos(){
        setLayout(null);
        setJMenuBar(barraMenu);
        barraMenu.add(menuItems);
        menuItems.add(e1);
        menuItems.add(salir);

        salir.addActionListener(e -> {
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
