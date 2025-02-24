package com.example;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        boolean jugar = true;
        while (jugar) {
            
        }
        Random random = new Random();
        int numeroAleatorio = 0;
        boolean hasAcertado = false;
        int numero = 0;
        Scanner sc = new Scanner(System.in);
        string sino = n;
        numeroAleatorio = random.nextInt(100) + 1;
        System.out.println(numeroAleatorio);

        while (hasAcertado) {
            System.out.println("Adivina el numero que estoy pensando entre el 1 y el 100");
            numero = sc.nextInt();
            if (numero<numeroAleatorio) {
            System.out.println("Has fallado, El numero que buscaras mas pequeño.");            
             } else if (numero>numeroAleatorio) {
                System.out.println("Has fallado, El numero que buscaras mas grande.");            
            }else{
                System.out.println("Has acertado");    
                hasAcertado=true;        
            }
        }
        System.out.println("Quieres jugar de nuevo");
        sino = sc.next();
        if (sino equal="n") {
            jugar = false;
        }
    }
}