package com.example;
/**************************************/
/* Nom: Albert Bergas Consuegra 				*/
/* DNI/NIE: 45185379Q	*/
/* Data: 18/10/2024				*/
/* Exercici: PROU2EX01				*/
/**************************************/
import java.util.Scanner; /* importa una llibreria per poder posar un escaner. */
public class Main { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); /* Crea un nou objecte Scanner que li deim sc per llegir la entrada del usuari. */
        int i = 1; /* Definim la variable (i) perque per a la maquina sigui llegible. */
        System.out.println("Escribe un numero"); /* Cream un codi que fa que el sistema ens demani un número. */
        int numUsuario = sc.nextInt(); /* Llegeix un número introduit per l'usuari i per el sistema es numUsuari. */
            while (i<=numUsuario) { /* Mentre la variable i(1) es igual o menor que numUsuari. */
                if (i%2 == 0) { /*Si el residu de i es igual a 0 es par. */
                    System.out.println(i + " Par"); /* Imprimeix (i) i par(si el residu es igual a 0). */
                }else{ /*Sino */
                    System.out.println(i + " Impar"); /* Imprimeix (i) i impar(si el residu no es igual a 0). */
                }
                    i=i+1; /* Quan ha imprimit la variable (i) suma 1 fins que arriba al número escrit. */
            }
                sc.close(); /* Tancam l'escaner. */
    }
}