package com.example;

import java.awt.Graphics;

import javax.swing.JPanel;

public class pelota {

    private int x = 50, y = 50; // Coordenadas iniciales del círculo
    private int dx = 5, dy = 5; // Velocidad del movimiento en X e Y, se usa para poder mover el circulo
    private final int RADIO = 30; // Radio del círculo
    private final int RETRASO = 1; // Sirve para controlar la velocidad de la animación, menor es más rápido

    // Constructor que inicializa el panel e inicia el temporizador
    public pelota() {

    }

    /* GETTER DE LOS ATRIBUTOS */
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadio() {
        return RADIO;
    }

    public int getRetraso() {
        return RETRASO;
    }

    /* FUNCION DE MOVER LA PELOTA */
    public void moverPelota(JPanel ventana) {
        if (x + 2 * RADIO >= ventana.getWidth() || x <= 0) {
            dx = -dx;
        }
        if (y + 2 * RADIO >= ventana.getHeight() || y <= 0) {
            dy = -dy;
        }
        x += dx;
        y += dy;
    }
    
    public void moverPelota2(pala palaa) {
        if (x + 2 * RADIO >= palaa.getAncho() || x <= 0) {
            dx = -dx;
        }
        if (y + 2 * RADIO >= palaa.getAlto() || y <= 0) {
            dy = -dy;
        }
        x += dx;
        y += dy;
    }


    public void paint(Graphics g) {
        //
    }

}


