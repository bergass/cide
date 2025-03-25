package com.example; // define el paquete de la clase

import javax.swing.JPanel; // importa la clase jpanel para crear paneles
import java.awt.event.KeyEvent; // importa la clase keyevent para manejar eventos de teclado
import java.awt.event.KeyListener; // importa la clase keylistener para manejar eventos de teclado

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

    public void addKeyListenerToComponent(JPanel panel, int upKey, int downKey) { // añade un keylistener al panel
        panel.addKeyListener(new KeyListener() { // crea un nuevo keylistener
            @Override
            public void keyTyped(KeyEvent e) { // metodo para manejar eventos de tipo de tecla
                // no hace nada
            }

            @Override
            public void keyPressed(KeyEvent e) { // metodo para manejar eventos de presion de tecla
                int keyCode = e.getKeyCode(); // obtiene el codigo de la tecla presionada
                if (keyCode == upKey) { // si la tecla presionada es la tecla de subir
                    moverPala(-20, panel.getHeight()); // mueve la pala hacia arriba
                } else if (keyCode == downKey) { // si la tecla presionada es la tecla de bajar
                    moverPala(20, panel.getHeight()); // mueve la pala hacia abajo
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { // metodo para manejar eventos de liberacion de tecla
                // no hace nada
            }
        });
    }

    public void moverPala(int nuevaY, int altoPanel) { // metodo para mover la pala
        if (y + nuevaY >= 0 && y + alto + nuevaY <= altoPanel) { // si la nueva posicion es valida
            y += nuevaY; // actualiza la coordenada y
        }
    }
}