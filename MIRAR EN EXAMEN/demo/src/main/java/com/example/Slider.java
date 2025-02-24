package com.example; // define el paquete donde esta la clase

import javax.swing.*; // importa la libreria swing para crear interfaces graficas
import java.awt.*; // importa la libreria awt para manejar componentes graficos
import javax.swing.event.ChangeEvent; // importa la clase ChangeEvent para manejar eventos de cambio
import javax.swing.event.ChangeListener; // importa la clase ChangeListener para escuchar cambios en componentes

public class Slider { // define la clase Slider
    public static void main(String[] args) { // metodo principal que se ejecuta al iniciar el programa
        JFrame frame = new JFrame("Calculadora"); // crea una ventana con el titulo "Calculadora"
        frame.setSize(400, 300); // establece el tamaño de la ventana a 400x300 pixeles
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cierra la aplicacion al cerrar la ventana
        frame.setLayout(new FlowLayout()); // establece el layout de la ventana como FlowLayout

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100,50); // crea un slider horizontal con valores de 0 a 100 y valor inicial 50
        slider.setMajorTickSpacing(20); // establece intervalos grandes de 20 unidades
        slider.setMinorTickSpacing(5);  // establece intervalos pequeños de 5 unidades
        slider.setPaintTicks(true);     // muestra las marcas de los intervalos
        slider.setPaintLabels(true);    // muestra las etiquetas numericas de los intervalos

        JLabel label = new JLabel("Valor de slider:"+slider.getValue()); // crea una etiqueta con el valor inicial del slider

        slider.addChangeListener(new ChangeListener() { // añade un listener para cambios en el slider
            @Override
            public void  stateChanged(ChangeEvent e) { // metodo que se ejecuta cuando cambia el valor del slider
                label.setText("Valor de slider:"+slider.getValue()); // actualiza el texto de la etiqueta con el nuevo valor del slider
            }
        });

        frame.add(slider); // añade el slider a la ventana
        frame.add(label); // añade la etiqueta a la ventana

        frame.setVisible(true); // hace visible la ventana
    }
}