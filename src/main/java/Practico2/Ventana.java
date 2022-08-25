package Practico2;

import javax.swing.*;
import java.util.EventListener;

public class Ventana extends JFrame {
    private JMenuBar barraMenu = new JMenuBar();
    private JMenu menuItems = new JMenu("Inicio");
    private JMenuItem e1 = new JMenuItem("Fractal");
    private JMenuItem salir = new JMenuItem("Salir");
    private JFrame ventanaUsuario=new JFrame();
    private JTextField txtProfundidad=new JTextField();
    private JButton btnInicia = new JButton("Dibujar");
    public PanelImagen panel;
    private Fractal cuadrado;
    private int profundidad;
    public Ventana(){
        super("Fractal");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.add(panel);
        cargarElementos();
        //panelFractal = new PanelImagen(500,500);
        //pack();

        setResizable(false);
        setVisible(true);
    }
    private void cargarElementos(){
        setLayout(null);
        setJMenuBar(barraMenu);
        barraMenu.add(menuItems);
        menuItems.add(e1);
        menuItems.add(salir);
        e1.addActionListener(e -> {
            //ventanita();
            try {
                String numero = JOptionPane.showInputDialog("Ingrese el tamaño del fractal");
                profundidad = Integer.parseInt(numero);
                JOptionPane.showMessageDialog(null, "Dato ingresado");
                System.out.println("La profundidad es: " + profundidad);
                cuadrado.setProfundidad(profundidad);
                cuadrado.cambia();
            }catch (NullPointerException ex) {
                /*modelo.dibujar(getGraphics());
                txtProfundidad.setText("");*/
                JOptionPane.showMessageDialog(null,"Coloque numero, no letra");
            }

        });
        salir.addActionListener(e -> {
            cerrarPrograma();
        });
        //Panel de dibujo
        panel = new PanelImagen(cuadrado);
        getContentPane().add(panel);

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
            try {
                profundidad = Integer.parseInt(txtProfundidad.getText());
                JOptionPane.showMessageDialog(null, "Dato ingresado");
                System.out.println("La profundidad es: " + profundidad);
                ventanaUsuario.setVisible(false);
                cuadrado.dibujar(getGraphics());
                txtProfundidad.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ingrese un número valido, no letras");
                txtProfundidad.setText("");
            }
        });

    }
    public void cmdCuadros(){
        System.out.println("Cuadros dibujados");
        cuadrado.setProfundidad(Integer.parseInt(txtProfundidad.getText()));
        cuadrado.cambia();
    }

    public static void main(String[] args) {
        Ventana v = new Ventana();
    }

}
