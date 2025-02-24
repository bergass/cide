package com.example;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*; // importa la llibreria awt per manejar components gràfics
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DetectarRaton {
    public static void main(String[] args) { // metodo principal que se ejecuta al iniciar el programa

        JFrame frame = new JFrame("Detectar Raton"); // crea una finestra amb el títol "calculadora"
        frame.setSize(400, 300); // estableix la mida de la finestra a 400x300 píxels
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // estableix que l'aplicació es tanqui quan es tanca la finestra
        frame.setLayout(new BorderLayout()); // estableix el layout de la finestra com borderlayout

        JLabel label = new JLabel();

        label.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {
                label.setText("Ratón movido a: (" + e.getX() + ", " + e.getY() + ")"); // actualitza el text de l'etiqueta amb les coordenades del ratolí fora que se apreti cap boto(nomes el ratoli)
            }
            @Override
            public void mouseDragged(MouseEvent e) {
                label.setText("Ratón movido a: (" + e.getX() + ", " + e.getY() + ")"); // actualitza el text quan se esta apretant cualcun boto(per exemple quan arrastres algo)

            }
        });
        frame.add(label);
        frame.setVisible(true);
    }
    
}
