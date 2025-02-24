package com.example;

//Albert Bergas Consuegra
//DNI: 45185379Q

import java.util.Random;

public class sobrassada extends torrada implements graella, menjar {
    Random random = new Random();// inicialitza un random

    public sobrassada() {//constructor de sobrassada
        System.out.println("He comprat una sobrassada");//imprimeix
    }

    @Override //crida als metodes de la interficie
    public void posarCarnAGraella() {// metode
        System.out.println("He posat la sobrassada a la graella");//imprimeix
    }

    @Override //crida als metodes de la interficie
    public void llevarCarnDeGraella() {// metode
        System.out.println("He llevat la sobrassada de la graella");//imprimeix
    }

    @Override //crida als metodes de la interficie
    public void assabori() {// metode
        System.out.println("Estic assaborint la sobrassada");//imprimeix
    }

    @Override //crida als metodes de la interficie
    public boolean crema() {// metode
        int fet = random.nextInt(100);// instancia la variable fet que es un random de 100 numeros
        if (fet <= 49) { // si fet es menor de 49(50%)
            return false;// retorna false
        } else {//sino 
            return true;//retorna true
        }
        
    }

    @Override //crida als metodes de la interficie
    public boolean estaFet() {// metode
        int fet = random.nextInt(100);// instancia la variable fet que es un random de 100 numeros
        if (fet <= 49) {// si fet es menor de 49(50%)
            return false;// retorna false
        } else {//sino 
            return true;//retorna true
        }
    }
}
