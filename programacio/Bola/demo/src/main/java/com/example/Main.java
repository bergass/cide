package com.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Círculo Rebotante"); // Crea la ventana
            CirculoRebotante panel = new CirculoRebotante(); // Crea una instancia del panel
            frame.add(panel); // Agrega el panel a la ventana
            frame.setSize(400, 300); // Define el tamaño de la ventana
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura el cierre de la ventana
            frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
            frame.setVisible(true); // Muestra la ventana
        });
    }
}