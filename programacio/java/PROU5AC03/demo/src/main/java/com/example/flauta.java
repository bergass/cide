package com.example; // Aquesta línia indica a quin package pertany el fitxer

public class flauta extends instrument implements interficieVent{   // classe flauta que hereta de la classe instrument i implementa la interfície interficieVent
    public flauta(String nom, String tipus) { // constructor de la classe flauta
        super(nom, tipus); // crida al constructor de la classe instrument
    } 
    @Override // sobreescriu el mètode de la classe pare
    public void interpretar() { // mètode interpretar
        System.out.println(getNom()+": Tocant una melodia amb la flauta"); // mostrem un missatge per pantalla
    }

    @Override // sobreescriu el mètode de la classe pare
    public void afinarVent() { // mètode afinarVent
        System.out.println(getNom()+": Afinant la flauta"); // mostrem un missatge per pantalla
    }

    @Override // sobreescriu el mètode de la classe pare
    public void ferSonar() { // mètode ferSonar
        System.out.println(getNom()+": Fent sonar la flauta"); // mostrem un missatge per pantalla
    }
}
