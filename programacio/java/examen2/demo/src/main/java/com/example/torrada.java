package com.example;

//Albert Bergas Consuegra
//DNI: 45185379Q

public class torrada { // superclasse torrada
    private String festivitat;//atribut de festivitat
    private String any;//atribut de festivitat

    public torrada() {
        System.out.println("He creat una torrada"); //imprimeix
    }

    public void setAny(String any) {//metodo set de any
        this.any = any;//cambia l'aribut per l'any posat
        System.out.println("He canviat l'any de la torrada");//imprimeix
    }

    public String getAny() { // metodo get d'any
    System.out.println("dawi");
        return any;// retorna l'any
        
    }

    public void setFestivitat(String festivitat) {// metodo set de festivitat
        this.festivitat = festivitat; // cambia l'atribut per la festivitat posada
        System.out.println("He canviat la festivitat");//imprimeix
    }

    public String getFestivitat() { // metodo get de festivitat
        return festivitat; // retorna la festivitat
    }
}
