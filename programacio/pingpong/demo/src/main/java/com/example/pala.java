package com.example;

public class pala {

    private int x = 20, y = 100; // Coordenadas iniciales de la pala
    //private int dx = 2, dy = 2; // Velocidad del movimiento en X e Y, se usa para poder mover las palas
    private final int ancho = 10, alto =200; // Sirve para controlar la velocidad de la animación, menor es más rápidoF

    public pala() {
        // moin
    }

    public void setX(int x) {//metodo set de any
        this.x = x;//cambia l'aribut per l'any posat
    }
        /* GETTER DE LOS ATRIBUTOS */
    public int getX() {
        return x;
    }

    public void setY(int y) {//metodo set de any
        this.y = y;//cambia l'aribut per l'any posat
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
