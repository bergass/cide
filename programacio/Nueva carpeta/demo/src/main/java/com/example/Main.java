package com.example;

import java.awt.BorderLayout;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Círculo Rebotante"); // Crea la ventana
            frame.setLayout(new BorderLayout());

            pelota panel = new pelota(); // Crea una instancia del panel
            pala panel2 = new pala();

            frame.add(panel, BorderLayout.CENTER); // Agrega el panel a la ventana
            frame.add(panel2, BorderLayout.NORTH);

            frame.setSize(400, 300); // Define el tamaño de la ventana
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura el cierre de la ventana
            frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
            frame.setVisible(true); // Muestra la ventana
        });
    }
}