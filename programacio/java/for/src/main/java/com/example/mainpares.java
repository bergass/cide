package com.example;

import java.util.Scanner;

public class mainpares {
    public static void main(String[] args) {
        System.out.println("Ingresa un numero entero positivo");
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();
        int sumaPares = 0;
        int contadorPares = 0;

        for (int i=1;i<=numero;i++){
            if (i%2 == 0) {
                System.out.println(i);
                sumaPares += i;
                contadorPares++;
            }
        }
        System.out.println("Suma total de numeros pares" + sumaPares);
        System.out.println("Ingresa un numero entero positivo" + contadorPares);
        sc.close();
    }
}