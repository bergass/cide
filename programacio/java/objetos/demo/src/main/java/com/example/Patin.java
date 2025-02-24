package com.example;

public class Patin {
    private boolean estaEncendido;
    private int velocidad;
    private int orientacion;
    
    public Patin() {
        this.estaEncendido = false;
        this.velocidad = 3;
        this.orientacion = 0;
    }

    public void encender() {
        if (estaEncendido!=true) {
            this.estaEncendido = true;
            System.out.println("Esta encendido");
        } else {
            System.out.println("Ya esta encendido");
        }
    }
    public void apagar() {
        if (estaEncendido!=false) {
            this.estaEncendido = false;
            System.out.println("Esta apagado");
        } else {
            System.out.println("Ya esta apagado");
        }
    }

    public void subirVelocidad() {
        velocidad++;
    }
    public void bajarVelocidad() {
        velocidad--;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad2) {
        this.velocidad = velocidad2;
        System.out.println("La nueva vel es"+velocidad2);
    } 

    public void girarDerecha() {
        orientacion++;
        System.out.println(orientacion);
    }
    public void girarIzquierda() {
        orientacion--;
        System.out.println(orientacion);
    }
}
