package com.example; // Aquesta línia indica a quin package pertany el fitxer

interface interficieVent { // Aquesta interfície conté dos mètodes
    public void afinarVent(); // Mètode per afinar la flauta

    public void ferSonar(); // Mètode per fer sonar la flauta
}

interface interficiePercussio { // Aquesta interfície conté dos mètodes
    public void afinarTambor(); // Mètode per afinar el tambor

    public void colpejarTambor(); // Mètode per colpejar el tambor 
}

interface interficieCordes {    // Aquesta interfície conté dos mètodes
    public void afinarCordes(); // Mètode per afinar les cordes

    public void tocarArpegis(); // Mètode per tocar arpegis
}

public class Main { 

    public static void main(String[] args) { // Aquesta funció és l'entrada del programa
        guitarra miGuitarra = new guitarra("Fender Stratocaster", "Corda"); // Creem un objecte de la classe guitarra
        miGuitarra.mostrarInformacio(); // Mostrem la informació de la guitarra
        miGuitarra.afinarCordes(); // Afinem les cordes de la guitarra
        miGuitarra.tocarArpegis(); // Tocam arpegis amb la guitarra
        miGuitarra.interpretar(); // Interpretam una melodia amb la guitarra
        System.out.println(""); // Saltem una línia

        tambor miTambor = new tambor("Tambor Yamaha", "Percussio"); // Creem un objecte de la classe tambor
        miTambor.mostrarInformacio(); // Mostrem la informació del tambor
        miTambor.afinarTambor(); // Afinem el tambor
        miTambor.colpejarTambor(); // Colpejam el tambor
        miTambor.interpretar(); // Interpretam un ritme amb el tambor
        System.out.println(""); // Saltem una línia

        flauta miFlauta = new flauta("Flauta Yamaha", "Vent"); // Creem un objecte de la classe flauta
        miFlauta.mostrarInformacio(); // Mostrem la informació de la flauta
        miFlauta.afinarVent(); // Afinem la flauta
        miFlauta.ferSonar(); // Fem sonar la flauta
        miFlauta.interpretar(); // Tocam una melodia amb la flauta
        System.out.println(""); // Saltem una línia

    }
}