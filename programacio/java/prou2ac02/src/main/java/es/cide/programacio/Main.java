package es.cide.programacio;
import java.util.Scanner;
public class Main {
    private static int ANYFIJO=2024;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime en que año naciste");
        int respuesta = 0;
        respuesta = sc.nextInt();
        int edad = 0;
        edad = ANYFIJO - respuesta;
        System.out.println(edad);
        if (edad >= 18) {
            System.out.println("mayor de edad");
        } else {
            System.out.println("menor de edad");
        }      
        sc.close();
    }
}