package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] miArray = {1, 20, 10, 40, 12};
        int tamanyArray = 0;
        int valorMaxim = 0;
        int posicioMaxim = 0;
        int posicioMinim = 0;
        int valorMinim = 1000;
        int sumaTotal = 0;
        float mitja = 0;

        tamanyArray = miArray.length;
        System.out.println(tamanyArray);

        for(int i=0;i<tamanyArray;i++) {
            System.out.println(miArray[i]);
            while (miArray[i] > valorMaxim) {
                valorMaxim = miArray[i];
                posicioMaxim = i;
            }
            while (miArray[i] < valorMinim) {
                valorMinim = miArray[i];
                posicioMinim = i;
            }
            sumaTotal = sumaTotal + miArray[i];
            mitja = (float) sumaTotal / tamanyArray;
        }
        
        System.out.println("El valor màxim es " + valorMaxim + " que es la posicio " + posicioMaxim);
        System.out.println("El valor minim es " + valorMinim + " que es la posicio " + posicioMinim);
        System.out.println("La suma total es " + sumaTotal);
        System.out.println("La mitja es " + mitja);

        for(int j=tamanyArray-1;j>=0;j--) {
                System.out.println(miArray[j]);
            }

        }
    }