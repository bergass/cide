package com.example; // define el paquete donde esta la clase

import javax.swing.*; // importa la libreria swing para crear interfaces graficas
import java.awt.*; // importa la libreria awt para manejar componentes graficos
import java.awt.event.ActionListener; // importa la interfaz ActionListener para manejar eventos de accion
import java.awt.event.ActionEvent; // importa la clase ActionEvent para manejar eventos de accion

public class Checkbox { // define la clase checkbox
    public static void main(String[] args) { // metodo principal que se ejecuta al iniciar el programa
        JFrame frame = new JFrame("Calculadora"); // crea una ventana con el titulo calculadora
        frame.setSize(400, 300); // establece el tamano de la ventana a 400x300 pixeles
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cierra la aplicacion al cerrar la ventana
        frame.setLayout(new FlowLayout()); // establece el layout de la ventana como flowlayout

        JCheckBox checkBox = new JCheckBox("Mostrar dialogo"); // crea un checkbox con el texto mostrar dialogo
        checkBox.setSelected(false); // establece el checkbox como no seleccionado por defecto
        JCheckBox checkBox1 = new JCheckBox("Mostrar dialogo"); // crea un checkbox con el texto mostrar dialogo
        checkBox.setSelected(false); // establece el checkbox como no seleccionado por defecto

        checkBox.addActionListener(new ActionListener() { // anade un listener al checkbox para manejar eventos de accion
            @Override
            public void actionPerformed(ActionEvent e) { // metodo que se ejecuta cuando ocurre un evento de accion
                if (checkBox.isSelected()) { // si el checkbox esta seleccionado
                    JDialog dialog = new JDialog(frame,"Esta marcado"); // crea un dialogo con el titulo esta marcado
                    dialog.setSize(200,100); // establece el tamano del dialogo a 200x100 pixeles
                    dialog.add(new JLabel("Checkbox marcado")); // anade una etiqueta con el texto checkbox marcado al dialogo
                    dialog.setVisible(true); // hace visible el dialogo
                } else { // si el checkbox no esta seleccionado
                    JDialog dialog = new JDialog(frame,"No esta marcado"); // crea un dialogo con el titulo no esta marcado
                    dialog.setSize(200,100); // establece el tamano del dialogo a 200x100 pixeles
                    dialog.add(new JLabel("Checkbox desmarcado")); // anade una etiqueta con el texto checkbox desmarcado al dialogo
                    dialog.setVisible(true); // hace visible el dialogo
                }
            }
        });

        frame.add(checkBox); // anade el checkbox a la ventana

        frame.setVisible(true); // hace visible la ventana
    }
}