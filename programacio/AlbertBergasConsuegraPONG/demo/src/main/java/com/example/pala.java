package com.example; // define el paquete de la clase

// Albert Bergas Consuegra

public class pala { // define la clase pala

    private int x = 20, y = 100; // coordenadas iniciales de la pala
    private final int ancho = 20, alto = 110; // dimensiones de la pala

    public pala() { // constructor de la clase pala
        // constructor vacio
    }

    public void setX(int x) { // metodo set para la coordenada x
        this.x = x; // asigna el valor a la coordenada x
    }

    public int getX() { // metodo get para la coordenada x
        return x;
    }

    public void setY(int y) { // metodo set para la coordenada y
        this.y = y; // asigna el valor a la coordenada y
    }

    public int getY() { // metodo get para la coordenada y
        return y;
    }

    public int getAncho() { // metodo get para el ancho de la pala
        return ancho;
    }

    public int getAlto() { // metodo get para el alto de la pala
        return alto;
    }

    public void moverPala(int nuevaY, int altoPanel) { // metodo para mover la pala
        if (y + nuevaY >= 0 && y + alto + nuevaY <= altoPanel) { // si la nueva posicion es valida
            y += nuevaY; // actualiza la coordenada y
        }
    }
}