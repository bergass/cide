package com.example;

import javax.swing.*; // importa la libreria swing para crear interfaces graficas
import java.awt.*; // importa la libreria awt para manejar componentes graficos
import java.awt.event.ActionEvent; // importa la classe ActionEvent per manejar esdeveniments d'acció
import java.awt.event.ActionListener; // importa la clase ChangeListener para escuchar cambios en componentes

public class ContadorSobrePalabra {
    public static void main(String[] args) { // metodo principal que se ejecuta al iniciar el programa

        JFrame frame = new JFrame("Calculadora"); // crea una ventana con el titulo "Calculadora"
        frame.setSize(400, 300); // establece el tamaño de la ventana a 400x300 pixeles
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cierra la aplicacion al cerrar la ventana
        frame.setLayout(new FlowLayout()); // establece el layout de la ventana como FlowLayout

        JTextField palabra = new JTextField(20); // campo de texto para ingresar la palabra
        JLabel contador = new JLabel(); // etiqueta para mostrar el conteo de letras

        JButton boton = new JButton("Pulsar para contar");
        boton.addActionListener(new ActionListener() { // afegeix un listener al botó perquè quan es faci clic, es cridi al mètode suma amb els camps de text i l'etiqueta de resultat
            
            @Override
            public void actionPerformed(ActionEvent e) { // mètode que s'executa quan es fa clic al botó
                String texto = palabra.getText(); // obtiene el texto ingresado en el campo de texto
                int count = 0;
                for (char c : texto.toCharArray()) { // recorre cada caracter de la palabra
                    if (c == 'A' || c == 'a') { // cuenta tanto 'A' mayúscula como 'a' minúscula
                        count++;
                    }
                }
                contador.setText("Número de letras 'A': " + count); // muestra el conteo en la etiqueta
            }
        });

        frame.add(palabra); // añade el campo de texto a la ventana
        frame.add(boton); // añade el botón a la ventana
        frame.add(contador); // añade la etiqueta a la ventana

        frame.setVisible(true); // hace visible la ventana
    }
}