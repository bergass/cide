package com.example;

import javax.swing.*;
import java.awt.*;

public class PanelEjemplo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de JPanel");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);

        JButton boton = new JButton("Haz clic");
        panel.add(boton);

        frame.add(panel);

        frame.setVisible(true);
    }
}
