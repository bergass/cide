package com.example;

import java.util.Random;

public class zoologic {
    private int tamany;
    private animal[] arrayAnimals;
    Random random = new Random();
    private boolean gosPosicionat;
    private boolean aguilaPosicionat;
    private boolean peixPosicionat;

    public zoologic(int tamanyZoologic) {
        this.tamany = tamanyZoologic;
        this.arrayAnimals = new animal[tamanyZoologic];
        System.out.println("he creat un zoologic");
        this.gosPosicionat = false;
        this.aguilaPosicionat = false;
        this.peixPosicionat = false;
        posicionaAnimals();
    }

    private void posicionaAnimals() {
        for (int i = 0; i < this.tamany; i++) {
            int array = random.nextInt(3);
            
            if (array == 0) {
                arrayAnimals[i] = new gos("gos "+array,"Mamifer");
                gosPosicionat = true;
            } else if (array == 1) {
                arrayAnimals[i] = new aguila("aguila "+array, "au");
                aguilaPosicionat = true;
            } else if (array == 2) {
                arrayAnimals[i] = new aguila("peix "+array, "peix");
                peixPosicionat = true;
            }
        }
    }

    public animal getAnimal(int i) {
        return arrayAnimals[i];
    }
}
