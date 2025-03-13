package com.example; // Define el paquete de la clase

import java.awt.*; // Importa las clases necesarias para gráficos

public class pala { // Define la clase pala
    private int x, y; // Coordenadas de la pala
    private final int width, height; // Ancho y alto de la pala
    private final int speed = 10; // Velocidad de movimiento de la pala

    public pala(int x, int y, int width, int height) { // Constructor de la clase
        this.x = x; // Inicializa la coordenada X
        this.y = y; // Inicializa la coordenada Y
        this.width = width; // Inicializa el ancho
        this.height = height; // Inicializa el alto
    }

    public void draw(Graphics g) { // Método para dibujar la pala
        g.setColor(Color.WHITE); // Establece el color de la pala
        g.fillRect(x, y, width, height); // Dibuja la pala como un rectángulo
    }

    public void moveUp() { // Método para mover la pala hacia arriba
        if (y > 0) { // Verifica si la pala no está en el borde superior
            y -= speed; // Mueve la pala hacia arriba
        }
    }

    public void moveDown(int panelHeight) { // Método para mover la pala hacia abajo
        if (y < panelHeight - height) { // Verifica si la pala no está en el borde inferior
            y += speed; // Mueve la pala hacia abajo
        }
    }

    public Rectangle getBounds() { // Método para obtener los límites de la pala
        return new Rectangle(x, y, width, height); // Devuelve un rectángulo que representa los límites de la pala
    }
}