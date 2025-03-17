package com.example;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Círculo Rebotante"); // Crea la ventana
            juego pong = new juego();


            frame.add(pong); // Agrega el panel a la ventana

            frame.setSize(800, 500); // Define el tamaño de la ventana
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura el cierre de la ventana
            frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
            frame.setVisible(true); // Muestra la ventana
        });
    }
}
