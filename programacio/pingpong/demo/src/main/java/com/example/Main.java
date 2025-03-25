package com.example; // define el paquete de la clase

import javax.swing.JFrame; // importa la clase jframe para crear ventanas
import javax.swing.JPanel; // importa la clase jpanel para crear paneles
import javax.swing.SwingUtilities; // importa la clase swingutilities para manejar la cola de eventos
import javax.swing.JButton; // importa la clase jbutton para crear botones
import javax.swing.JLabel; // importa la clase jlabel para crear etiquetas
import javax.swing.JTextField; // importa la clase jtextfield para crear campos de texto

import java.awt.event.ActionEvent; // importa la clase actionevent para manejar eventos
import java.awt.event.ActionListener; // importa la clase actionlistener para manejar eventos
import javax.swing.*; // importa todas las clases de javax.swing
import java.awt.*; // importa todas las clases de java.awt

public class Main { // define la clase main
    public static void main(String[] args) { // metodo principal
        SwingUtilities.invokeLater(() -> { // ejecuta el codigo en la cola de eventos
            JFrame frame = new JFrame("Ping PONG"); // crea la ventana
            frame.setSize(800, 500); // define el tamaño de la ventana
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // configura el cierre de la ventana
            frame.setLocationRelativeTo(null); // centra la ventana en la pantalla

            JPanel menu = new JPanel(new GridBagLayout()); // crea un panel con layout gridbaglayout
            java.awt.GridBagConstraints gbc = new GridBagConstraints(); // crea un objeto gridbagconstraints para manejar las posiciones
            gbc.insets = new Insets(2, 0, 2, 30); // establece los margenes internos del layout
            gbc.anchor = GridBagConstraints.WEST; // establece el anclaje de los componentes al oeste

            JLabel bienvenida = new JLabel("Bienvenido al Ping PONG"); // crea una etiqueta de bienvenida
            gbc.gridx = 2; // establece la columna
            gbc.gridy = 0; // establece la fila
            menu.add(bienvenida, gbc); // añade la etiqueta al panel

            JLabel introduccion = new JLabel("A continuación elegiras el nombre de J1 y el J2"); // crea una etiqueta de introduccion
            gbc.gridx = 2; // establece la columna
            gbc.gridy = 1; // establece la fila
            gbc.gridwidth = 2; // establece que el boton ocupa 2 columnas
            menu.add(introduccion, gbc); // añade la etiqueta al panel

            JLabel J1 = new JLabel("Nombre del Jugador 1:"); // crea una etiqueta para el jugador 1
            gbc.gridx = 0; // establece la columna
            gbc.gridy = 2; // establece la fila
            gbc.gridwidth = 1; // establece que el boton ocupa 1 columna
            menu.add(J1, gbc); // añade la etiqueta al panel
            JTextField nj1 = new JTextField(10); // crea un campo de texto para el jugador 1
            gbc.gridx = 1; // establece la columna
            gbc.gridy = 2; // establece la fila
            gbc.gridwidth = 3; // establece que el boton ocupa 3 columnas
            menu.add(nj1, gbc); // añade el campo de texto al panel

            JLabel J2 = new JLabel("Nombre del Jugador 2:"); // crea una etiqueta para el jugador 2
            gbc.gridx = 3; // establece la columna
            gbc.gridy = 2; // establece la fila
            gbc.gridwidth = 1; // establece que el boton ocupa 1 columna
            menu.add(J2, gbc); // añade la etiqueta al panel
            JTextField nj2 = new JTextField(10); // crea un campo de texto para el jugador 2
            gbc.gridx = 4; // establece la columna
            gbc.gridy = 2; // establece la fila
            gbc.gridwidth = 3; // establece que el boton ocupa 3 columnas
            menu.add(nj2, gbc); // añade el campo de texto al panel

            JButton empezar = new JButton("Empezar"); // crea un boton para empezar el juego
            gbc.gridx = 2; // establece la columna
            gbc.gridy = 3; // establece la fila
            empezar.addActionListener(new ActionListener() { // añade un actionlistener al boton
               @Override
                public void actionPerformed(ActionEvent e) { // metodo para manejar el evento de clic
                    String nombreJ1 = nj1.getText(); // obtiene el nombre del jugador 1
                    String nombreJ2 = nj2.getText(); // obtiene el nombre del jugador 2
                    juego pong = new juego(nombreJ1, nombreJ2); // crea un nuevo juego con los nombres de los jugadores
                    frame.remove(menu); // elimina el menu de la ventana
                    frame.add(pong); // añade el juego a la ventana
                    frame.revalidate(); // actualiza la ventana (ayudita de chatGPT(no ho hagues tret mai))
                    frame.repaint(); // repinta la ventana
                }
            });
            menu.add(empezar, gbc); // añade el boton al panel

            frame.add(menu); // añade el panel a la ventana
            frame.setVisible(true); // muestra la ventana
        });
    }
}