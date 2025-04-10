package com.example;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Jugador {
    private int x, y; // Posición del jugador
    private final int width = 50, height = 50; // Tamaño del jugador

    public Jugador(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public void move(int dx) {
        // Mover al jugador horizontalmente
        x += dx;
    }

    public void draw(Graphics2D g) {
        // Dibujar al jugador como un rectángulo
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        // Retornar el área del jugador para detectar colisiones
        return new Rectangle(x, y, width, height);
    }
}
