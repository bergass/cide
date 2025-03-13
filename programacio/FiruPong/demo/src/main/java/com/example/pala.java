package com.example;

public class pala {

    private int x = 25, y = 25; // Coordenadas iniciales de la pala
    //private int dx = 2, dy = 2; // Velocidad del movimiento en X e Y, se usa para poder mover las palas
    private final int ancho = 10, alto =200; // Sirve para controlar la velocidad de la animación, menor es más rápidoF

    public pala() {
        // moin
    }

    /* GETTER DE LOS ATRIBUTOS */
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void moverPala(int nuevaY, int altoPanel) {
        if (y + nuevaY >= 0 && y + alto + nuevaY <= altoPanel) {
            y += nuevaY;
        }
    }
}
