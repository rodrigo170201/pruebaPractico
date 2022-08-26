package Practico2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.util.EventListener;

public class Ventana extends JFrame {
    private Logger log = LogManager.getLogger(Ventana.class);
    private JMenuBar barraMenu = new JMenuBar();
    private JMenu menuItems = new JMenu("Iniciar");
    private JMenuItem e1 = new JMenuItem("Fractal");
    private JMenuItem salir = new JMenuItem("Salir");
    public PanelImagen panel;
    private Fractal cuadrado;
    private int profundidad;
    private boolean esVerdadero = false;
    public Ventana(){
        super("Fractal");
        setSize(600,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.add(panel);
        cuadrado = new Fractal(2);
        cargarElementos();
        //setResizable(false);
        setVisible(true);
    }
    private void cargarElementos(){
        //Panel de dibujo
        panel = new PanelImagen(cuadrado);
        getContentPane().add(panel);
        setJMenuBar(barraMenu);
        barraMenu.add(menuItems);
        menuItems.add(e1);
        menuItems.add(salir);
        e1.addActionListener(e -> {
            //ventanita();
            while(esVerdadero == false){
                try {
                    String numero = JOptionPane.showInputDialog("Ingrese el tamaño del fractal");
                    profundidad = Integer.parseInt(numero);
                    if (profundidad<=0){
                        JOptionPane.showMessageDialog(null,"Ingrese un número mayor a 0");
                    }else {
                        esVerdadero = true;
                        log.debug("La profundidad del fractal es: " + profundidad);
                        cuadrado.setProfundidad(profundidad);
                        cuadrado.cambia();
                    }
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Coloque numero, no letra");
                }
            }
            esVerdadero=false;
        });
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
