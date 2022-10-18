package Practico5;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.Vector;

public class Ventana extends JFrame {

    private JPanel panelPrincipal = new JPanel();
    DefaultMutableTreeNode dmtn=new DefaultMutableTreeNode("Letras");
    DefaultMutableTreeNode n1 = new DefaultMutableTreeNode("a");
    DefaultMutableTreeNode n1_1 = new DefaultMutableTreeNode("a1");

    DefaultMutableTreeNode n2 = new DefaultMutableTreeNode("b");
    DefaultMutableTreeNode n3 = new DefaultMutableTreeNode("c");
    public Ventana(){
        dmtn.add(n1);
        n1.add(n1_1);
        dmtn.add(n2);
        dmtn.add(n3);

        JTree arbol1 = new JTree(dmtn);
        JScrollPane sp1 = new JScrollPane(arbol1);
        panelPrincipal.setBackground(Color.black);

        add(sp1,BorderLayout.WEST);
        add(panelPrincipal,BorderLayout.CENTER);
        //Configuracion del panel inicial
        setSize(500,500);
        setTitle("Practico 5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Ventana v = new Ventana();
    }
}
