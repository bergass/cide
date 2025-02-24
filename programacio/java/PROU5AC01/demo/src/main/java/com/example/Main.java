package com.example;

interface interficieConduir {
    void conduir();

    int obtenirVelocitatMaxima();
}

interface interficieHabilitat {
    void albergarPersones(int nombre);

    int obtenirCapacitat();
}

abstract class vehicle {
    protected String nom;

    public vehicle(String nom) {
        this.nom = nom;
    }

    public void descriure() {
    
    }
}

class cotxe extends vehicle implements interficieConduir, interficieHabilitat {
    private int capacitat;

    public cotxe(String nom, int capacitat) {
        super(nom);
        this.capacitat = capacitat >= 4 ? capacitat : 4;
    }

    @Override
    public void conduir() {
        System.out.println("Estic conduint un cotxe a una velocitat de " + obtenirVelocitatMaxima() + " km/h");
    }

    @Override
    public int obtenirVelocitatMaxima() {
        return 200;
    }

    @Override
    public void albergarPersones(int nombre){
        if (nombre <= capacitat) {
            System.out.println("Aquest cotxe pot albergar " + nombre + " persones");
        } else {
            System.out.println("Aquest cotxe no pot albergar " + nombre + " persones");
        }
    }
    @Override
    public int obtenirCapacitat() {
        return capacitat;
    }

    @Override
    public void descriure() {
        System.out.println("Soc un vehicle. Soc un cotxe i em dic " + nom);
    }
}

class moto extends vehicle implements interficieConduir, interficieHabilitat {  
    private int capacitat;

    public moto(String nom, int capacitat) {
        super(nom);
        this.capacitat = capacitat >= 2 ? capacitat : 2;
    }

    @Override
    public void conduir() {
        System.out.println("Estic conduint una moto a una velocitat maxima de "+obtenirVelocitatMaxima()+ "km/h");
    }

    @Override
    public int obtenirVelocitatMaxima() {
        return 150;
    }

    @Override
    public void albergarPersones(int nombre){
        if (nombre <= capacitat) {
            System.out.println("Aquesta moto pot albergar " + nombre + " persones");
        } else {
            System.out.println("Aquesta moto no pot albergar " + nombre + " persones");
        }
    }
    @Override
    public int obtenirCapacitat() {
        return capacitat;
    }
    @Override
    public void descriure() {
        System.out.println("Soc un vehicle. Soc una moto i em dic " + nom);
    }
}

public class Main {
    public static void main(String[] args) {
        cotxe miCotxe = new cotxe("bmw m8", 4);
        miCotxe.descriure();
        miCotxe.conduir();
        miCotxe.obtenirVelocitatMaxima();
        miCotxe.albergarPersones(3);
        miCotxe.obtenirCapacitat();

        moto miMoto = new moto("h1 yamaha", 2);
        miMoto.descriure();
        miMoto.conduir();
        miMoto.obtenirVelocitatMaxima();
        miMoto.albergarPersones(1);
        miMoto.obtenirCapacitat();
       
    }
}