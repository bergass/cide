package com.example;

public class TV {
    // atributos
    private boolean estaEncendido;
    private int volumen;
    private int canal;

    public TV() {
        this.estaEncendido = false;
        this.volumen = 10;
        this.canal = 1;
    }

    public void encender() {
        if (!estaEncendido) {
            estaEncendido = true;
            System.out.println("Esta encendida");
        } else {
            System.out.println("Ya esta encendido");
        }
    }

    public void apagar() {
        if (estaEncendido) {
            estaEncendido = false;
            System.out.println("Esta apagado");
        } else {

            System.out.println("Ya esta apagado");
        }
    }

    public void subirVolumen() {
        volumen++;
        System.out.println(volumen);
    }

    public void bajarVolumen() {
        volumen--;
        System.out.println(volumen);
    }

    public int getVolumen() {
        return volumen;
    }

    public void subirCanal() {
        canal++;
        System.out.println(canal);
    }

    public void bajarCanal() {
        canal--;
        System.out.println(canal);
    }

    public int getCanal() {
        return canal;

    }

    public void setCanal(int canaaaaal) {
        this.canal = canaaaaal;
        System.out.println("xd"+canal);
    }
}
