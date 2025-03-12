package com.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class pala extends JPanel implements ActionListener {
    private int x = 25, y = 30; // Coordenadas iniciales del círculo
    private final int RETRASO = 10; // Retraso del temporizador en milisegundos
    private Timer timer; // Temporizador para controlar la animación
    private int dx = 4, dy = 4; // Velocidad del movimiento en X e Y


    public pala() {
        setBackground(Color.RED); // Define el color de fondo del panel
        timer = new Timer(RETRASO, this); // Crea el temporizador con retraso especificado
        timer.start(); // Inicia el temporizador
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g; // Conversión a Graphics2D para mejorar el dibujo
        g2d.setColor(Color.RED); // Define el color del círculo
        g2d.drawLine(x, y, x + 10, y + 40); // Dibuja el círculo en las coordenadas x, y con el radio
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Comprueba si el círculo toca los bordes horizontales
        // Actualiza la posición del círculo
        x += dx;
        y += dy;
        repaint();
    }
}
