package Practico2;

import javax.swing.*;
import java.util.EventListener;

public class Ventana extends JFrame {
    private JMenuBar barraMenu = new JMenuBar();
    private JMenu menuItems = new JMenu("Inicio");
    private JMenuItem e1 = new JMenuItem("Fractal");
    private  JMenuItem salir = new JMenuItem("Salir");
    private JFrame ventanaUsuario=new JFrame();
    private JTextField txtProfundidad=new JTextField();
    private JButton btnInicia = new JButton("Dibujar");
    private PanelImagen panelFractal;
    public Ventana(){
        super("Fractal");
        setSize(500,500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cargarElementos();
        panelFractal = new PanelImagen(500,500);
        add(panelFractal);
        //pack();
        setVisible(true);
    }
    private void cargarElementos(){
        setLayout(null);
        setJMenuBar(barraMenu);
        barraMenu.add(menuItems);
        menuItems.add(e1);
        menuItems.add(salir);
        e1.addActionListener(e -> {
            ventanita();
        });
        salir.addActionListener(e -> {
            cerrarPrograma();
        });
    }
    public void cerrarPrograma(){
        dispose();
        System.exit(0);
    }
    public void ventanita(){
        JLabel lbMensaje = new JLabel("Ingrese el número de profundidad ");
        ventanaUsuario.setSize(300,150);
        ventanaUsuario.setLayout(null);
        ventanaUsuario.setLocationRelativeTo(null);
        ventanaUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaUsuario.setVisible(true);
        lbMensaje.setBounds(20,30,200,20);
        txtProfundidad.setBounds(20,60,160,20);
        btnInicia.setBounds(190,60,80,20);
        ventanaUsuario.add(lbMensaje);
        ventanaUsuario.add(txtProfundidad);
        ventanaUsuario.add(btnInicia);
        btnInicia.addActionListener(e -> {

        });

    }

    public static void main(String[] args) {
        Ventana v = new Ventana();
    }

}
