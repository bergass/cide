package com.example;

public class peix extends animal implements aquatic {
    public peix(String nom, String tipus) {
        super(nom, tipus);
    }

    @Override
    public void nedar() {
    }

    @Override
    public void emetreSo() {
        System.out.println("Blub Blub");
    }
}
