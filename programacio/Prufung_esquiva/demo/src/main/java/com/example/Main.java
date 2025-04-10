package com.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Crear la ventana principal del juego
        JFrame frame = new JFrame("Esquiva los Obstáculos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // Tamaño de la ventana

        // Agregar el panel del juego
        GameEngine gameEngine = new GameEngine();
        frame.add(gameEngine);

        frame.setVisible(true); // Mostrar la ventana
    }
}