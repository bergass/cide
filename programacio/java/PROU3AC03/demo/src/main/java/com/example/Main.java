package com.example;

public class Main {
    public static void main(String[] args) {
        animal miAnimal = new animal(22);
        miAnimal.hazRuido();
        miAnimal.getPeso();
        miAnimal.setPeso(2);

        animal snoopy = new perro(20);
        snoopy.hazRuido();
        snoopy.getPeso();
        snoopy.setPeso(4);

        animal harry = new gato(10);
        harry.hazRuido();
        harry.getPeso();
        harry.setPeso(5);

    }
}