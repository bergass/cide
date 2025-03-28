package com.example; // define el paquete de la clase

import java.awt.Graphics; // importa la clase graphics para dibujar
import javax.swing.JPanel; // importa la clase jpanel para crear paneles

// Albert Bergas Consuegra

public class pelota { // define la clase pelota

    private int x = 50, y = 50; // coordenadas iniciales del circulo
    private int dx = 4, dy = 4; // velocidad del movimiento en x e y
    private final int RADIO = 10; // radio del circulo
    private final int RETRASO = 10; // retraso de la animacion
    private int contador1 = 0; // contador para el jugador 1
    private int contador2 = 0; // contador para el jugador 2

    public pelota() { // constructor de la clase pelota
        // constructor vacio
    }

    public int getX() { // devuelve la coordenada x
        return x;
    }

    public int getY() { // devuelve la coordenada y
        return y;
    }

    public int getRadio() { // devuelve el radio del circulo
        return RADIO;
    }

    public int getRetraso() { // devuelve el retraso de la animacion
        return RETRASO;
    }

    public int getContador1() { // devuelve el contador 1
        return contador1;
    }

    public int getContador2() { // devuelve el contador 2
        return contador2;
    }

    public void moverPelota(JPanel ventana) { // mueve la pelota dentro del panel
        if (x <= 0) { // si la pelota sale por la izquierda
            x = 400; // reinicia la posicion x
            y = 250; // reinicia la posicion y
            contador1++; // incrementa el contador 1
        } else if (x + 2 * RADIO >= ventana.getWidth()) { // si la pelota sale por la derecha
            x = 400; // reinicia la posicion x
            y = 250; // reinicia la posicion y
            contador2++; // incrementa el contador 2
        }

        if (y + 2 * RADIO >= ventana.getHeight() || y <= 0) { // si la pelota toca el borde superior o inferior
            dy = -dy; // invierte la direccion en y
        }
        x += dx; // actualiza la coordenada x
        y += dy; // actualiza la coordenada y
    }

    public void moverPelota2(pala palaa) { // Mueve la pelota considerando las palas
        // Colisión con el borde derecho de la pala
        if (x + dx + 2 * RADIO >= palaa.getX() && // lado derecho de la pelota rebota cuando es mayor/igual al lado izquierdo pala
            x + dx <= palaa.getX() + palaa.getAncho() && // lado izquierdo de la pelota rebota cuando es menor/igual al lado derecho pala
            y + dy + 2 * RADIO >= palaa.getY() && // lado inferior de la pelota rebota cuando es mayor/igual al lado superior
            y + dy <= palaa.getY() + palaa.getAlto()) { // lado superior de la pelota rebota cuando es menor/igual al lado inferior pala
            dx = -dx; // Invierte la dirección en X
            x += dx; // Ajusta la posición para evitar que se meta dentro de la pala
        }
        // Colisión con el borde izquierdo de la pala
        if (x + dx <= palaa.getX() + palaa.getAncho() && // lado izquierdo de la pelota rebota cuando es menor/igual al lado derecho pala
            x + dx + 2 * RADIO >= palaa.getX() && // lado derecho de la pelota rebota cuando es mayor/igual al lado izquierdo pala
            y + dy + 2 * RADIO >= palaa.getY() && // lado inferior de la pelota rebota cuando es mayor/igual al lado superior
            y + dy <= palaa.getY() + palaa.getAlto()) { // lado superior de la pelota rebota cuando es menor/igual al lado inferior pala
            dx = -dx; // Invierte la dirección en X
            x += dx; // Ajusta la posición para evitar que se meta dentro de la pala
        }
        // Colisión con el borde inferior de la pala
        if (y + dy + 2 * RADIO >= palaa.getY() && // lado inferior de la pelota rebota cuando es mayor/igual al lado superior
            y + dy <= palaa.getY() + palaa.getAlto() && // lado superior de la pelota rebota cuando es menor/igual al lado inferior pala
            x + dx + 2 * RADIO >= palaa.getX() && // lado derecho de la pelota rebota cuando es mayor/igual al lado izquierdo pala
            x + dx <= palaa.getX() + palaa.getAncho()) { // lado izquierdo de la pelota rebota cuando es menor/igual al lado derecho pala
            dy = -dy; // Invierte la dirección en Y
            y += dy; // Ajusta la posición para evitar que se meta dentro de la pala
        }
        // Colisión con el borde superior de la pala
        if (y + dy <= palaa.getY() + palaa.getAlto() && // lado superior de la pelota rebota cuando es menor/igual al lado inferior pala
            y + dy + 2 * RADIO >= palaa.getY() && // lado inferior de la pelota rebota cuando es mayor/igual al lado superior
            x + dx + 2 * RADIO >= palaa.getX() && // lado derecho de la pelota rebota cuando es mayor/igual al lado izquierdo pala
            x + dx <= palaa.getX() + palaa.getAncho()) { // lado izquierdo de la pelota rebota cuando es menor/igual al lado derecho pala
            dy = -dy; // Invierte la dirección en Y
            y += dy; // Ajusta la posición para evitar que se meta dentro de la pala
        }
    
        x += dx; // Actualiza la coordenada X
        y += dy; // Actualiza la coordenada Y
    }

    public void paint(Graphics g) { // Método para pintar la pelota
        // Método vacío, se implementará en el futuro
    }
}