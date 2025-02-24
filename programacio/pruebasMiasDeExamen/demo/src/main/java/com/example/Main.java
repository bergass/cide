package com.example;

import javax.swing.*; // importa la libreria swing para crear interfaces graficas
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Prueba"); // crea una ventana con el titulo calculadora
        frame.setSize(600, 400); // establece el tamano de la ventana a 400x300 pixeles
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cierra la aplicacion al cerrar la ventana
        frame.setLayout(new FlowLayout()); // establece el layout de la ventana como flowlayout

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10));

        JTextField escribe = new JTextField();
        JButton boton = new JButton("Mostrar texto");
        JLabel palabra = new JLabel("");
        palabra.setFont(new Font("Arial", Font.PLAIN, 2));

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                palabra.setText(escribe.getText());
            }
        });

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 50); // crea un slider horizontal con valores de 0 a 100
                                                                     // y valor inicial 50
        slider.setMajorTickSpacing(20); // establece intervalos grandes de 20 unidades
        slider.setMinorTickSpacing(5); // establece intervalos pequeños de 5 unidades
        slider.setPaintTicks(true); // muestra las marcas de los intervalos
        slider.setPaintLabels(true); // muestra las etiquetas numericas de los intervalos

        slider.addChangeListener(new ChangeListener() { // añade un listener para cambios en el slider
            @Override
            public void stateChanged(ChangeEvent e) { // metodo que se ejecuta cuando cambia el valor del slider
                palabra.setFont(new Font("Arial", Font.PLAIN, slider.getValue()));
            }
        });
        panel.add(escribe);
        panel.add(boton);
        panel.add(palabra);
        panel.add(slider);
        frame.add(panel);
        frame.setVisible(true);
    }
}