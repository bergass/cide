package com.example;

public abstract class animal {
    private String nom;
    private String tipus;

    public animal(String nom, String tipus) {
        this.nom = nom;
        this.tipus = tipus;
    }

    public void mostrarInformacio() {
        System.out.println("L'animal es nom " + nom + " i es un " + tipus);
    }

    abstract public void emetreSo();
}
