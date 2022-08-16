import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Ventana extends JFrame {
    private static final Logger logger = LogManager.getLogger(Ventana.class);
    private JTextField txtTamaño = new JTextField();
    private JButton btnIniciar = new JButton("Iniciar");
    private OrdenamientoInsercion ordenInsercion = new OrdenamientoInsercion();
    private OrdenamientoBubble ordenBubble = new OrdenamientoBubble();
    private OrdenamientoQuick ordenQuick = new OrdenamientoQuick();
    private Random random = new Random();
    private int[] arreglo;
    private int[] arregloAux;
    private int[] arregloAux2;

    private int[] arregloInsercion;
    private int[] arregloBurbuja;
    private int[] arregloQuicksort;
    private int tamaño;


    public Ventana() {
        setTitle("Practico 1");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        cargarElementos();
        setVisible(true);
        btnIniciar.addActionListener(e -> {
            long limite = 1000000;
            long inicio = 10000;
            tamaño = Integer.parseInt(txtTamaño.getText());
            if (tamaño < inicio || tamaño > limite) {
                JOptionPane.showMessageDialog(null, "Ingrese un número entre " + inicio + " y " + limite);
                txtTamaño.setText("");
            } else {
                //AQUI LO SUBDIVIDO
                arreglo = new int[tamaño];//10000
                asignandoValores(arreglo, random);
                arregloAux = arreglo;//10.000

                int tamañoInsercion = (int) (arreglo.length * 0.3);
                int tamañoBurbuja = (int) (arreglo.length * 0.6 - tamañoInsercion);

                arregloInsercion = new int[tamañoInsercion];
                arregloBurbuja = new int[tamañoBurbuja];
                System.out.println("EL ARREGLO DESORDENADO");
                mostrarArreglo(arreglo);


                long inicio1 = System.nanoTime();
                ordenInsercion.ordenandoInsercion(arreglo);//10000
                long fin1 = System.nanoTime();
                long resultado1 = fin1 - inicio1;
                long inicio2 = System.nanoTime();
                //System.out.println("Insercion tarda: " + TimeUnit.MILLISECONDS.convert(resultado1,TimeUnit.NANOSECONDS) + " ms");
                ordenBubble.ordenandoBubble(arregloBurbuja);
                long fin2 = System.nanoTime();
                long resultado2 = fin2 - inicio2;
                //System.out.println("burbuja tarda: " + TimeUnit.MILLISECONDS.convert(resultado2,TimeUnit.NANOSECONDS) + " ms");
                //ordenQuick.ordenarQuick(arregloAux);
                //mostrarArreglo(arreglo);
                //mostrarArreglo(arregloAux);

                int posicion1 = 0;
                for (int i = 0; i < arreglo.length; i++) {
                    try {
                        if (arreglo[i] >= 0 && arreglo[i] <= 33000) {
                            arregloInsercion[posicion1] = arreglo[i];
                            posicion1++;
                        }
                    } catch (Exception exeption) {

                    }
                }
                int posicion2 = 0;
                for (int i = 0; i < arregloAux.length; i++) {
                    try {
                        if (arregloAux[i] >= 33001 && arregloAux[i] <= 66000) {
                            arregloBurbuja[posicion2] = arregloAux[i];
                            posicion2++;
                        }

                    } catch (Exception exeption) {

                    }
                }
                System.out.println("=========INSERCION==========");
                mostrarArreglo(arregloInsercion);
                System.out.println("===========BUBBLE===========");
                mostrarArreglo(arregloBurbuja);
                System.out.println("");
                logger.debug("LA INSERCION TARDA: " + TimeUnit.MILLISECONDS.convert(resultado1, TimeUnit.NANOSECONDS)+" ms");
                logger.debug("El BUBBLE TARDA: " + TimeUnit.MILLISECONDS.convert(resultado2, TimeUnit.NANOSECONDS)+" ms");
            }
        });
    }

    public void cargarElementos() {
        setLayout(null);
        txtTamaño.setBounds(50, 110, 80, 20);
        btnIniciar.setBounds(150, 110, 70, 20);
        add(txtTamaño);
        add(btnIniciar);
    }

    public static void asignandoValores(int[] a, Random aleatorio) {
        for (int i = 0; i < a.length; i++) {
            a[i] = aleatorio.nextInt(0, 100000);
        }
    }

    public static void mostrarArreglo(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " - ");
        }
        System.out.println();
    }
}
