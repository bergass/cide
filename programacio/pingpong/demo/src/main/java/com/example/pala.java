package com.example;

import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class pala {

    private int x = 20, y = 100; // Coordenadas iniciales de la pala
    // private int dx = 2, dy = 2; // Velocidad del movimiento en X e Y, se usa para
    // poder mover las palas
    private final int ancho = 20, alto = 110; // Sirve para controlar la velocidad de la animación, menor es más rápidoF

    public pala() {
        // moin
    }

    public void setX(int x) {// metodo set de any
        this.x = x;// cambia l'aribut per l'any posat
    }

    /* GETTER DE LOS ATRIBUTOS */
    public int getX() {
        return x;
    }

    public void setY(int y) {// metodo set de any
        this.y = y;// cambia l'aribut per l'any posat
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

    public void addKeyListenerToComponent(JPanel panel, int upKey, int downKey) {
        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // No hace nada
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode(); // se refiere al codigo ANSI de cada letra
                if (keyCode == upKey) {
                    moverPala(-20, panel.getHeight()); // Mueve la pala hacia arriba
                } else if (keyCode == downKey) {
                    moverPala(20, panel.getHeight()); // Mueve la pala hacia abajo
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // No hace nada
            }
        });
    }

    public void moverPala(int nuevaY, int altoPanel) {
        if (y + nuevaY >= 0 && y + alto + nuevaY <= altoPanel) {
            y += nuevaY;
        }
    }
}
