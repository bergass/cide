package com.example;

interface terrestre {
    public void caminar();
}

interface volador {
    public void volar();
}

interface aquatic {
    public void nedar();
}

public class Main {
    public static void main(String[] args) {

        zoologic miZoologic = new zoologic(3);

        animal obtenirAnimal = miZoologic.getAnimal(2);
        if (obtenirAnimal != null) {
            if (obtenirAnimal.getClass().equals(gos.class)) {
                
            }
        }

    }
}