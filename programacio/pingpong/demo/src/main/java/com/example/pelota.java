package com.example; // Define el paquete de la clase

import java.awt.Graphics; // Importa la clase Graphics para dibujar
import javax.swing.JPanel; // Importa la clase JPanel para crear paneles


public class pelota { // Define la clase pelota

    private int x = 50, y = 50; // Coordenadas iniciales del círculo
    // X EMPIEZA A CONTAR DESDE IZQUIERDA, Y DESDE ARRIBA
    private int dx = 2, dy = 2; // Velocidad del movimiento en X e Y, se usa para poder mover el circulo
    private final int RADIO = 10; // Radio del círculo
    private final int RETRASO = 10; // Sirve para controlar la velocidad de la animación, menor es más rápido
    private int contador1 = 0;
    private int contador2 = 0;

    // Constructor que inicializa el panel e inicia el temporizador
    public pelota() {
        // Constructor vacío
    }

    /* GETTER DE LOS ATRIBUTOS */
    public int getX() { // Devuelve la coordenada X
        return x;
    }

    public int getY() { // Devuelve la coordenada Y
        return y;
    }

    public int getRadio() { // Devuelve el radio del círculo
        return RADIO;
    }

    public int getRetraso() { // Devuelve el retraso de la animación
        return RETRASO;
    }

    public int getContador1() {
        return contador1;
    }
    public int getContador2() {
        return contador2;
    }

    /* FUNCION DE MOVER LA PELOTA */
    public void moverPelota(JPanel ventana) { // Mueve la pelota dentro del panel
        if (x <= 0) { // sale por la izquierda
            x = 400;
            y = 250;
            contador1++;

        } else if (x + 2 * RADIO >= ventana.getWidth()) { // sale por la derecha
            x = 400;
            y = 250;
            contador2++;
        }

        if (y + 2 * RADIO >= ventana.getHeight() || y <= 0) { // Si la pelota toca el borde superior o inferior del
                                                              // panel
            dy = -dy; // Invierte la dirección en Y
        }
        x += dx; // Actualiza la coordenada X
        y += dy; // Actualiza la coordenada Y
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