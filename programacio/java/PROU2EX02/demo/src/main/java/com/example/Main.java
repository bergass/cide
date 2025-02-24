package com.example;
import java.util.Scanner;
/**************************************/
/* Nom: Albert Bergas Consuegra 				*/
/* DNI/NIE: 45185379Q 			*/
/* Data: 25/10/2024 				*/
/* Exercici: PROU2EX02				*/
/**************************************/

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); /* Crea un nou objecte Scanner que li deim sc per llegir la entrada del usuari. */

        double numU1 = 0; /*Definim la variable numU1 */
        double numU2 = 0; /*Definim la variable numU2 */

        for (int i=0;i<5;i++) { /* Definim que (i) sigui 0; mentres (i) sigui menor que 5; imprimeix (i) i sumale (i) */

            System.out.println("Elige entre estas opciones \n 1)Sumar \n 2)Restar \n 3)Multiplicar \n 4)Dividir \n 5)Salir");/* Imprimeix el missatge inicial */
            int opUsuari = sc.nextInt();/*Definim la variable opUsuari que sera la que noltros escriguem */

            while (opUsuari<1 || opUsuari>5) { /* Mentre opUsuari sigui menor que 1 o major que 6 */
            System.out.println("Escribe un numero vàlido"); /* Imprimeix el missatge, per aixi definir els numeros no valids */
            opUsuari = sc.nextInt(); /* L'usuari Introdueix un numero que sigui o major que 1 o menor que 6 perque no sorti a sortir l'avis */
            } /* while tancat */  
                switch (opUsuari) { /* Canvia opUsuari per el següents case */

                    case 1: /* Quan opUsuari sigui 1 */
                    System.out.println("Que numero deseas sumar"); /* Imprimeix el missatge */
                    numU1 = sc.nextInt(); /* L'usuari introdueix la variable de numU1*/
    
                    System.out.println("Por que numero lo deseas sumar"); /* Imprimeix el missatge */
                    numU2 = sc.nextInt(); /* L'usuari introdueix la variable de numU2*/
    
                    System.out.println("La suma de " +numU1+ " + " +numU2+ " es " +(numU1+numU2)+ "\n"); /* Imprimeix el missatge */
                
                    break; /* Per una vegada que faci el case 1 acabi el switch */

                    case 2: /* Quan opUsuari sigui 2 */
                    System.out.println("Que numero deseas resta"); /* Imprimeix el missatge */
                    numU1 = sc.nextInt(); /* L'usuari introdueix la variable de numU1*/
    
                    System.out.println("Por que numero lo deseas restar"); /* Imprimeix el missatge */
                    numU2 = sc.nextInt(); /* L'usuari introdueix la variable de numU2*/
    
                    System.out.println("La resta de " +numU1+ " - " +numU2+ " es " +(numU1-numU2)+ "\n"); /* Imprimeix el missatge */
                
                    break; /* Per una vegada que faci el case 2 acabi el switch */

                    case 3: /* Quan opUsuari sigui 3 */
                    System.out.println("Que numero deseas multiplicar"); /* Imprimeix el missatge */
                    numU1 = sc.nextInt(); /* L'usuari introdueix la variable de numU1*/
    
                    System.out.println("Por que numero lo deseas multiplicar"); /* Imprimeix el missatge */
                    numU2 = sc.nextInt(); /* L'usuari introdueix la variable de numU2*/
    
                    System.out.println("La multiplicación de " +numU1+ " x " +numU2+ " es " +(numU1*numU2)+ "\n"); /* Imprimeix el missatge */
                
                    break; /* Per una vegada que faci el case 3 acabi el switch */

                    case 4: /* Quan opUsuari sigui 4 */
                    System.out.println("Que numero deseas dividir"); /* Imprimeix el missatge */
                    numU1 = sc.nextInt(); /* L'usuari introdueix la variable de numU1*/
    
                    System.out.println("Por que numero lo deseas dividir"); /* Imprimeix el missatge */
                    numU2 = sc.nextInt(); /* L'usuari introdueix la variable de numU2*/

                    while (numU2<1) { /* Mentre que la segona variable (numU2) sigui menor que 1 */
                        System.out.println("No se puede dividir entre 0 \n"); /* Imprimeix el missatge */
                        System.out.println("Por que numero lo deseas dividir"); /* Imprimeix el missatge */
                        numU2 = sc.nextInt(); /* L'usuari introdueix la variable de numU2*/
                    } /* while tancat */
    
                    System.out.println("La división de " +numU1+ " / " +numU2+ " es " +(numU1/numU2)+ "\n"); /* Imprimeix el missatge */
                    
                    break; /* Per una vegada que faci el case 4 acabi el switch */

                    default:
                    i=5; /* Si opUsuari no es cap de es case posats canviam la variable (i) per 6 per aixi sortir del switch  */
                }  /* switch tancat */
        } /* for tancat */
        System.out.println("Gracias, adios"); /* Imprimeix el missatge */
        sc.close(); /* Tanca l'escaner */
    } /* main tancat */
} /* public class main tancat */