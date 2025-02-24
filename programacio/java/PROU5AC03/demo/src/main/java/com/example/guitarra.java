package com.example; // Aquesta línia indica a quin package pertany el fitxer

public class guitarra extends instrument implements interficieCordes { // classe guitarra que hereta de la classe instrument i implementa la interfície interficieCordes
    public guitarra(String nom, String tipus) {  // constructor de la classe guitarra
        super(nom, tipus); // crida al constructor de la classe instrument
    }
    @Override // sobreescriu el mètode de la classe pare
    public void interpretar() { // mètode interpretar
        System.out.println(getNom()+": Tocant una melodia amb la guitarra."); // mostrem un missatge per pantalla
    }

    @Override // sobreescriu el metodo de la classe pare
    public void afinarCordes() { // metodo afinarCordes
        System.out.println(getNom()+": Afinant les cordes"); // mostrem un missatge per pantalla
    }

    @Override // sobreescriu el metodo de la classe pare
    public void tocarArpegis() { // metodo tocarArpegis 
        System.out.println(getNom()+": Tocant arpegis"); // mostrem un missatge per pantalla
    }

}
