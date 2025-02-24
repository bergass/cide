package com.example;

public class gos extends animal implements terrestre {
    public gos(String nom, String tipus) {
        super(nom, tipus);
    }

    @Override
    public void caminar(){}

    @Override
    public void emetreSo() {
        System.out.println("Bup Bup");
    }
}
