package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); /* cream scanner */
        int quantitatCaramel = 0; /* identificam la variable dels caramels de cada nin */
        int nin = 0; /* identificam la variable per sebre quin nin escriu cada quantitat */
        int maxCaramels = 0;
        int valor1 = 0;
        int valor2 = 0;
        int valor3 = 0;
        int valor4 = 0;
        int valor5 = 0;
        int valor6 = 0;
        int valor7 = 0;

        for (int i = 0; i < 7; i++) { /* repetim el bucle fins a 7 vegades */
            nin = nin + 1; /* la variable de nin li afegim un cada vegada que acaba el bucle */
            System.out.println("Quants de caramels tens?"); /* demanam la pregunta */
            quantitatCaramel = sc.nextInt();/* deixam que l' usuari introdueixi la quantitat dels caramels */
            System.out.println("El nin " + nin + " te " + quantitatCaramel + " Caramels"); /* imprimim el missatge */
        }
        int[] numeroNins = { quantitatCaramel };
        int quantitatNins = numeroNins.length;
        
        System.out.println(quantitatNins);
        System.out.println(quantitatNins);
    }
}
