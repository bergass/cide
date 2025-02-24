package com.example; // Aquesta línia indica a quin package pertany el fitxer

public class tambor extends instrument implements interficiePercussio{ // classe tambor que hereta de la classe instrument i implementa la interfície interficiePercussio
    public tambor(String nom, String tipus) { // constructor de la classe tambor
        super(nom, tipus); // crida al constructor de la classe instrument
    }
    @Override // sobreescriu el mètode de la classe pare
    public void interpretar() { // mètode interpretar
        System.out.println(getNom()+": Interpretant un ritme amb el tambor"); // mostrem un missatge per pantalla
    }

    @Override // sobreescriu el mètode de la classe pare
    public void afinarTambor() { // mètode afinarTambor
        System.out.println(getNom()+": Afinant el tambor"); // mostrem un missatge per pantalla
    }

    @Override // sobreescriu el mètode de la classe pare
    public void colpejarTambor() { // mètode colpejarTambor
        System.out.println(getNom()+": Colpejant el tambor"); // mostrem un missatge per pantalla
    }
}
