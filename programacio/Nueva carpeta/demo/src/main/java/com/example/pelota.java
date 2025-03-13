package com.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

// Clase que representa un panel donde se dibuja un círculo que rebota
public class pelota extends JPanel implements ActionListener {
    private int x = 50, y = 50; // Coordenadas iniciales del círculo
    private int dx = 2, dy = 2; // Velocidad del movimiento en X e Y
    private final int RADIO = 10; // Radio del círculo
    private final int RETRASO = 10; // Retraso del temporizador en milisegundos
    private Timer timer; // Temporizador para controlar la animación

    // Constructor que inicializa el panel e inicia el temporizador
    public pelota() {
        setBackground(Color.WHITE); // Define el color de fondo del panel
        timer = new Timer(RETRASO, this); // Crea el temporizador con retraso especificado
    }

    // Método para dibujar el círculo dentro del panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g; // Conversión a Graphics2D para mejorar el dibujo
        g2d.setColor(Color.RED); // Define el color del círculo
        g2d.fillOval(x, y, RADIO * 2, RADIO * 2); // Dibuja el círculo en las coordenadas x, y con el radio
    }

    // Método que se ejecuta en cada tic del temporizador para mover el círculo
    @Override
    public void actionPerformed(ActionEvent e) {
        // Comprueba si el círculo toca los bordes horizontales
        if (x + 2 * RADIO >= getWidth() || x <= 0) {
            dx = -dx; // Invierte la dirección horizontal
        }

        // Comprueba si el círculo toca los bordes verticales
        if (y + 2 * RADIO >= getHeight() || y <= 0) {
            dy = -dy; // Invierte la dirección vertical
        }

        // Actualiza la posición del círculo
        x += dx;
        y += dy;
        repaint(); // Redibuja el panel para actualizar la posición del círculo
    }
}