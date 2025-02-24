package com.example;

//Albert Bergas Consuegra
//DNI: 45185379Q

import java.util.Random;

public class botifarro extends torrada implements graella, menjar { // classe botifarro que hereda torrada i implementa les interifices graella i menjar
    private boolean coent; //atribut de coent
    Random random = new Random(); // inicialitza un random

    public botifarro() { //constructor de botifarro
        System.out.println("He comprat un botifarro");//imprimeix
    }

    @Override //crida als metodes de la interficie
    public void posarCarnAGraella() { // metode
        System.out.println("He posat el botifarro a la graella");//imprimeix
    }

    @Override //crida als metodes de la interficie
    public void llevarCarnDeGraella() { // metode
        System.out.println("He llevat el botifarro de la graella");//imprimeix
    }

    @Override //crida als metodes de la interficie
    public void assabori() {// metode
        System.out.println("Estic assaborint el botifarro");//imprimeix
    }


    
    @Override //crida als metodes de la interficie
    public boolean crema() {// metode
        int fet = random.nextInt(100); // instancia la variable fet que es un random de 100 numeros
        if (fet <= 49) { // si fet es menor de 49(50%)
            return false; // retorna false
        } else { //sino 
            return true;//retorna true
        }
    }

    public void setCoent(boolean coent) {// metode set de coent
        this.coent = coent; // canvia l'atribut coent per el posat
        System.out.println("Canvii si es coent o no");//imprimeix
    }

    public boolean getCoent() { // metode get de coent
        return coent; // retorna coent
    }

    @Override//crida als metodes de la interficie
    public boolean estaFet() { // metode
        int fet = random.nextInt(100);// instancia la variable fet que es un random de 100 numeros
        if (fet <= 69) {// si fet es menor de 69(70%)
            return false;// retorna false
        } else {//sino 
            return true;//retorna true
        }
    }
}
