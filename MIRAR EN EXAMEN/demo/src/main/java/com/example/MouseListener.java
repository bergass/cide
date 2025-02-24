package com.example; // define el paquete donde esta la clase

import javax.swing.*; // importa la libreria swing para crear interfaces graficas
import java.awt.*; // importa la libreria awt para manejar componentes graficos
import java.awt.event.MouseAdapter; // importa la clase MouseAdapter para manejar eventos de raton
import java.awt.event.MouseEvent; // importa la clase MouseEvent para manejar eventos de raton

public class MouseListener { // define la clase MouseListener
    public static void main(String[] args) { // metodo principal que se ejecuta al iniciar el programa
        JFrame frame = new JFrame("Calculadora"); // crea una ventana con el titulo calculadora
        frame.setSize(400, 300); // establece el tamano de la ventana a 400x300 pixeles
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cierra la aplicacion al cerrar la ventana
        frame.setLayout(new FlowLayout()); // establece el layout de la ventana como flowlayout

        JLabel label = new JLabel("texto"); // crea una etiqueta con el texto "texto"
        String originalText = label.getText(); // guarda el texto original del label

        label.addMouseListener(new MouseAdapter() { // anade un listener al label para manejar eventos de raton
            @Override
            public void mouseEntered(MouseEvent e) { // metodo que se ejecuta cuando el raton entra en el label
                label.setText("Raton sobre el label"); // cambia el texto del label
            }
            @Override
            public void mouseExited(MouseEvent e) { // metodo que se ejecuta cuando el raton sale del label
                label.setText(originalText); // restaura el texto original del label
            }
        });

        frame.add(label); // anade el label a la ventana
        frame.setVisible(true); // hace visible la ventana
    }
}