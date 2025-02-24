package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] array = {
                { 5, 400, 60, 1 }, /* (i) */
                { 100, 7777 }, /* (i) */
                { 1200, 200, 15 }

                /* (i) */

        };
        int filasDeMiArray = 0;
        filasDeMiArray = array.length;
        int columnasDeMiArray = 0;
        int sumaTotal = 0;
        float mitjana = 0;
        int num = 0;
        int numMax = 0;
        int numMin = 0;

        for (int i = filasDeMiArray - 1; i >= 0; i--) {
            columnasDeMiArray = array[i].length;

            for (int j = columnasDeMiArray - 1; j >= 0; j--) {
                System.out.println(array[i][j]);
                sumaTotal = sumaTotal + array[i][j];
                num = num + 1;
                mitjana = sumaTotal / num;

                if (array[i][j] > numMax) {
                    numMax = array[i][j];
                    numMin = numMax;
                }

                if (array[i][j] < numMin) {
                    numMin = array[i][j];
                }
            }
        }
        System.out.println("El numero minim es " + numMin);
        System.out.println("El numero maxim es " + numMax);
        System.out.println(sumaTotal);
        System.out.println(mitjana);

        sc.close();
    }
}