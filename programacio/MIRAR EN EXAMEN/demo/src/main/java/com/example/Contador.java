package com.example; // define el paquete donde esta la clase

import javax.swing.*; // importa la libreria swing para crear interfaces graficas
import java.awt.*; // importa la libreria awt para manejar componentes graficos
import java.awt.event.KeyListener; // importa la interfaz KeyListener para manejar eventos de teclado
import java.awt.event.KeyEvent; // importa la clase KeyEvent para manejar eventos de teclado

public class Contador { // define la clase Contador

    public static void main(String[] args) { // metodo principal que se ejecuta al iniciar el programa
        JFrame frame = new JFrame("Calculadora"); // crea una ventana con el titulo calculadora
        frame.setSize(400, 300); // establece el tamano de la ventana a 400x300 pixeles
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cierra la aplicacion al cerrar la ventana
        frame.setLayout(new FlowLayout()); // establece el layout de la ventana como flowlayout

        JTextField texto = new JTextField(4); // crea un campo de texto con un ancho de 4 columnas

        JLabel contador = new JLabel("0"); // crea una etiqueta con el texto "0" para mostrar el contador

        texto.addKeyListener(new KeyListener() { // anade un listener al campo de texto para manejar eventos de teclado
            int conta = 0; // inicializa el contador a 0

            @Override
            public void keyTyped(KeyEvent e) { // metodo que se ejecuta cuando se escribe una tecla
                char letra = e.getKeyChar(); // obtiene el caracter de la tecla presionada
                if (letra == 'A' || letra == 'a') { // verifica si el caracter es 'A' o 'a'
                    conta++; // incrementa el contador
                    contador.setText(String.valueOf(conta)); // actualiza el texto de la etiqueta con el valor del contador
                }
            }

            @Override
            public void keyPressed(KeyEvent e) { // metodo que se ejecuta cuando se presiona una tecla
                // no hace nada se tiene que poner
            }

            @Override
            public void keyReleased(KeyEvent e) { // metodo que se ejecuta cuando se suelta una tecla
                // no hace nada se tiene que poner
            }
        });

        frame.add(texto); // anade el campo de texto a la ventana
        frame.add(contador); // anade la etiqueta a la ventana
        frame.setVisible(true); // hace visible la ventana
    }
}