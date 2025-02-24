package com.example;

public class aguila extends animal implements volador{
    public aguila(String nom, String tipus) {
        super(nom, tipus);
    }

    @Override
    public void volar(){}

    @Override
    public void emetreSo() {
        System.out.println("Screech");
    }   
}

