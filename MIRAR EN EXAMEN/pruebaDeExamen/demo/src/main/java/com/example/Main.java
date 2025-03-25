package com.example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent; // importa la classe ActionEvent per manejar esdeveniments d'acció
import java.awt.event.ActionListener; // importa la interfície ActionListener per escoltar esdeveniments d'acció

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Prueba"); // crea una vent con el titulo calculadora
        frame.setSize(400, 400); // establece el tamano de la ventana a 400x300 pixeles
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cierra la aplicacion al cerrar la ventana
        frame.setLayout(new FlowLayout()); // establece el layout de la ventana como flowlayout

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 0, 2, 30); // Espai entre els components
        gbc.anchor = GridBagConstraints.WEST; // Centra els components

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Titol de la pelicula"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        JTextField titulo = new JTextField(4);
        panel.add(titulo, gbc);

        JSlider anyEstrena = new JSlider(JSlider.HORIZONTAL, 1900, 2025, 1963); // crea un slider horizontal con valores
                                                                                // de
                                                                                // 0 a 100 y valor inicial 50
        anyEstrena.setMajorTickSpacing(25); // establece intervalos grandes de 20 unidades
        anyEstrena.setMinorTickSpacing(5); // establece intervalos pequeños de 5 unidades
        anyEstrena.setPaintTicks(true); // muestra las marcas de los intervalos
        anyEstrena.setPaintLabels(true); // muestra las etiquetas numericas de los intervalos
        JLabel value = new JLabel("Valor de slider:" + anyEstrena.getValue()); // crea una etiqueta con el valor inicial
                                                                               // del slider

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Genero"), gbc);

        String[] generos = { "Accion", "Comedia", "Drama", "Terror", "Ciencia Ficcio" };
        JComboBox<String> comboBox = new JComboBox<>(generos);
        comboBox.setBounds(gbc.gridx = 1, gbc.gridy = 1, 150, 300);
        panel.add(comboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Año de estreno:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(anyEstrena, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Año seleccionado"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        anyEstrena.addChangeListener(new ChangeListener() { // añade un listener para cambios en el slider
            @Override
            public void stateChanged(ChangeEvent e) { // metodo que se ejecuta cuando cambia el valor del slider
                value.setText(""+anyEstrena.getValue()); // actualiza el texto de la etiqueta con el
                                                                           // nuevo valor del slider
            }
        });
        panel.add(value, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel ficha = new JLabel("");
        JButton mostrarFicha = new JButton("Mostrar Ficha"); // crea un botó amb el text "resta"
        mostrarFicha.addActionListener(new ActionListener() { // afegeix un listener al botó perquè quan es faci clic,
                                                              // es cridi al mètode resta amb els camps de text i
                                                              // l'etiqueta de resultat
            @Override
            public void actionPerformed(ActionEvent e) {
                ficha.setText("Pel·licula: " + titulo.getText() + "| Genere: " + comboBox.getSelectedItem() + "| Any: "
                        + anyEstrena.getValue());
            }
        });
        panel.add(mostrarFicha, gbc); // afegeix el botó al panell

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(ficha, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Selecciona una vocal"), gbc);

        String[] vocales = { "A", "E", "I", "O", "U" };
        JComboBox<String> comboVocales = new JComboBox<>(vocales);
        comboBox.setBounds(gbc.gridx = 1, gbc.gridy = 6, 150, 300);
        panel.add(comboVocales, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        JLabel numeroVocales = new JLabel();
        JButton contarVocales = new JButton("Contar Vocales"); // crea un botó amb el text "resta"
        contarVocales.addActionListener(new ActionListener() { // afegeix un listener al botó perquè quan es faci clic,
                                                               // es cridi al mètode resta amb els camps de text i
            @Override
                public void actionPerformed(ActionEvent e) { // mètode que s'executa quan es fa clic al botó
                String texto = titulo.getText(); // obtiene el texto ingresado en el campo de texto
                int count = 0;
                for (char c : texto.toCharArray()) { // recorre cada caracter de la palabra
                    if (c == 'A' || c == 'a') { // cuenta tanto 'A' mayúscula como 'a' minúscula
                        count++;
                    }
                }
                numeroVocales.setText("Número de letras 'A': " + count);
            }
        });
        panel.add(ficha, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(contarVocales, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(numeroVocales, gbc);

        frame.add(panel, BorderLayout.NORTH);
        frame.setVisible(true);
    }
}