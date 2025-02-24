package com.example;

public abstract class instrument { // clase abstracta instrument 
    private String nom; // atribut nom
    private String tipus; // atribut tipus

    public instrument(String nom, String tipus) { // constructor de la clase instrument
        this.nom = nom; // inicialitzem l'atribut nom
        this.tipus = tipus; // inicialitzem l'atribut tipus
    }

    public void mostrarInformacio() { // mètode per mostrar la informació de l'instrument
        System.out.println("Instrument: " + nom + " , tipus " + tipus); // mostrem el nom i el tipus de l'instrument
    }

    abstract public void interpretar(); // mètode abstracte interpretar

    public String getNom() { // mètode per obtenir el nom de l'instrument
        return nom; // retornem el nom de l'instrument
    }

}
