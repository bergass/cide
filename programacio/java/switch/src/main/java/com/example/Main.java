package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Dame un numero del 1 al 7");
        Scanner sc = new Scanner(System.in);
        int dia = 0;
        dia = sc.nextInt();
        switch (dia) {
                case 1:
            System.out.println("lunes");
                break;
                case 2:
            System.out.println("martes");
                break;
                case 3:
            System.out.println("miercoles");
                break;
                case 4:
            System.out.println("jueves");
                break;
                case 5:
            System.out.println("viernes");
                break;
                case 6:
            System.out.println("sabado");
                break;
                case 7:
            System.out.println("domingo");
                break;
            default:System.out.println("Esto no es un dia de la semana");
                break;
        }
        if (dia<5) {
            System.out.println("Entre semana");
        }else{
            System.out.println("Fin de semana");
        }}
}