package com.example;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Obstaculo {
    private int x, y, width, height, speed;

    public Obstaculo(int startX, int startY, int speed) {
        this.x = startX;
        this.y = startY;
        this.width = 50;
        this.height = 50;
        this.speed = speed;
    }

    public void move() {
        // Mover el obstáculo hacia abajo
        y += speed;
    }

    public void draw(Graphics2D g) {
        // Dibujar el obstáculo como un rectángulo
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        // Retornar el área del obstáculo para detectar colisiones
        return new Rectangle(x, y, width, height);
    }

    public boolean isOutOfBounds(int screenHeight) {
        // Verificar si el obstáculo salió de la pantalla
        return y > screenHeight;
    }
}
